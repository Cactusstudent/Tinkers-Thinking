package com.creeping_creeper.tinkers_thinking.common.things.block.entity;

import com.creeping_creeper.tinkers_thinking.common.networking.ModMessages;
import com.creeping_creeper.tinkers_thinking.common.networking.packet.packet.ItemStackSyncS2CPacket;
import com.creeping_creeper.tinkers_thinking.common.recipes.DryingRackRecipes;
import com.creeping_creeper.tinkers_thinking.common.things.block.DryingRackBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class DryingRackBlockEntity extends BlockEntity {

    public  final ItemStackHandler itemStackHandler = new ItemStackHandler(2) {
        // 当槽位的内容改变时候，设置改变
        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0 -> true;
                case 1 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    // 设置itemstacks
    private final Map<Direction, LazyOptional<WrappedHandler>> directionWrappedHandlerMap =
                Map.of(Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(itemStackHandler, (i) -> i == 1,
                                (i, s) -> false)),
                        Direction.UP, LazyOptional.of(() -> new WrappedHandler(itemStackHandler, (i) -> i == 1,
                                (index, stack) -> itemStackHandler.isItemValid(0, stack))),
                        Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(itemStackHandler, (i) -> i == 1,
                                (index, stack) -> itemStackHandler.isItemValid(0, stack))),
                        Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(itemStackHandler, (i) -> i == 1,
                                (index, stack) -> itemStackHandler.isItemValid(0, stack))),
                        Direction.EAST, LazyOptional.of(() -> new WrappedHandler(itemStackHandler, (i) -> i == 1,
                                (index, stack) -> itemStackHandler.isItemValid(0, stack))),
                        Direction.WEST, LazyOptional.of(() -> new WrappedHandler(itemStackHandler, (i) -> i == 1,
                                (index, stack) -> itemStackHandler.isItemValid(0, stack))));
    // data 用于存储GUI数据接口
    protected final ContainerData data;
    // 合成进度追踪
    private int progress = 0;
    private int maxProgress = 2998;
    private static boolean canInsertItemToOutputSlot(SimpleContainer inventory) {
        return  inventory.getItem(1).isEmpty();
    }
    // 用于获得ItemStackHandler的能力
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    //
    public DryingRackBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.Drying_Rack.get(), blockPos, blockState);
        this.data = new ContainerData() {

            // 返回和设置合成进度的数据
            @Override
            public int get(int index) {
                return switch (index){
                    case 0-> DryingRackBlockEntity.this.progress;
                    case 1->DryingRackBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0->DryingRackBlockEntity.this.progress = value;
                    case 1->DryingRackBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };

    }
    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) {
                return lazyItemHandler.cast();
            }
            if (directionWrappedHandlerMap.containsKey(side)) {
                if (itemStackHandler.getStackInSlot(0).isEmpty()&& itemStackHandler.getStackInSlot(1).isEmpty()) {
                    Direction LocalDir = this.getBlockState().getValue(DryingRackBlock.FACING);
                    if (side == Direction.UP || side == Direction.DOWN) {
                        return directionWrappedHandlerMap.get(side).cast();
                    }
                    return switch (LocalDir) {
                        default -> directionWrappedHandlerMap.get(side.getOpposite()).cast();
                        case EAST -> directionWrappedHandlerMap.get(side.getClockWise()).cast();
                        case SOUTH -> directionWrappedHandlerMap.get(side).cast();
                        case WEST -> directionWrappedHandlerMap.get(side.getCounterClockWise()).cast();
                    };
                }else return directionWrappedHandlerMap.get(Direction.DOWN).cast();
            }
        }
        return super.getCapability(cap, side);
    }
    // 在onload阶段，加载lazyItemHandler
    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(()->itemStackHandler);
    }
    // 重写了BlockEntity中的invalidateCaps方法。
    // 在卸载实体方块时候将layItemHandler变量无效
    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    // 存储实体的数据
    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory",itemStackHandler.serializeNBT());
        nbt.putInt("drying_rack.progress",this.progress);
        super.saveAdditional(nbt);

    }
    // 读取实体的数据
    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        itemStackHandler.deserializeNBT(nbt.getCompound("inventory"));
        this.progress = nbt.getInt("drying_rack.progress");
    }

    // 当方块被破坏时候掉落方块中的内容。
    public void drops(){
        SimpleContainer inventory = new SimpleContainer(itemStackHandler.getSlots());
        for(int i = 0;i<itemStackHandler.getSlots();i++){
            inventory.setItem(i,itemStackHandler.getStackInSlot(i));
        }
        if (this.level != null) {
            Containers.dropContents(this.level,this.worldPosition,inventory);
        }
    }

    //静态方法，每次回调都会更新状态
    public static void tick(Level level, BlockPos blockPos, BlockState state, DryingRackBlockEntity entity) {
        if (level.isClientSide){
            return;
        }else   ModMessages.sendToClients(new ItemStackSyncS2CPacket(entity.itemStackHandler, blockPos));
        if(hasRecipe(entity)){
            // 进度增加
            entity.progress ++ ;
            setChanged(level,blockPos,state);
            // 如果进度条满了
            if(entity.progress >= entity.maxProgress){
                // 合成一个物品
                craftItem(entity);
            }
        }else{
            // 没有合成表就重置
            entity.resetProgress();
            setChanged(level,blockPos,state);
        }
    }
    // 重置进度
    private void resetProgress() {
        this.progress = 0;
    }
    // 合成物品
    private static void craftItem(DryingRackBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemStackHandler.getSlots());
        for(int i=0;i < entity.itemStackHandler.getSlots() ; i++){
            inventory.setItem(i, entity.itemStackHandler.getStackInSlot(i));
        }
        // 获得当前的recipe
        Optional<DryingRackRecipes> recipe = Optional.empty();
        if (level != null) {
            recipe = level.getRecipeManager().getRecipeFor(DryingRackRecipes.Type.INSTANCE,inventory,level);
        }

        if(hasRecipe(entity)){
            // 合成的结果是recipe的result
            entity.itemStackHandler.extractItem(0,1,false);
            entity.itemStackHandler.setStackInSlot(1,new ItemStack(recipe.get().getResultItem().getItem(), 1));
            entity.resetProgress();
        }
    }
    // 是否具有合成表
    private static boolean hasRecipe(DryingRackBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemStackHandler.getSlots());
        for(int i = 0; i< entity.itemStackHandler.getSlots(); i++){
            inventory.setItem(i, entity.itemStackHandler.getStackInSlot(i));
        }
        Optional<DryingRackRecipes> recipe = Optional.empty();
        if (level != null) {
            recipe = level.getRecipeManager().getRecipeFor(DryingRackRecipes.Type
                    .INSTANCE,inventory,level);
        }

        return recipe.isPresent()&& canInsertItemToOutputSlot(inventory);
    }
    // 判断插入slot是是否是相同的item，以及是否为空

    // 判断堆叠是否已满，还能否放入item
    public ItemStack getRenderStack(){
        ItemStack itemStack;
        if(itemStackHandler.getStackInSlot(1).isEmpty()){
            itemStack = itemStackHandler.getStackInSlot(0);
        }else{
            itemStack = itemStackHandler.getStackInSlot(1);
        }
        return itemStack;
    }
    public void setHandler(ItemStackHandler itemStackHandler){
        for(int i=0;i<itemStackHandler.getSlots();i++){
            this.itemStackHandler.setStackInSlot(i,itemStackHandler.getStackInSlot(i));
        }
    }
}
