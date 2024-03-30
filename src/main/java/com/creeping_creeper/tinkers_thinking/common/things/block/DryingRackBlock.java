package com.creeping_creeper.tinkers_thinking.common.things.block;

import com.creeping_creeper.tinkers_thinking.common.things.block.entity.DryingRackBlockEntity;
import com.creeping_creeper.tinkers_thinking.common.things.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class DryingRackBlock extends BaseEntityBlock {
    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }
    // 当方块被移除时候调用的方法
    @Override
    public void onRemove(BlockState state, Level level, BlockPos blockPos, BlockState newState, boolean isMoving) {
        // 判断新的方块是不是和旧的方块是同一个方块
        if(state.getBlock() != newState.getBlock()){
            // 获得方块的entity
            BlockEntity block = level.getBlockEntity(blockPos);
            // 如果该entity 是
            if(block instanceof DryingRackBlockEntity){
//                entity.drops();
                // 调用实体的掉落方法。
                ((DryingRackBlockEntity) block).drops();
            }

        }
        super.onRemove(state, level, blockPos, newState, isMoving);
    }

    // 方块被右键使用时候
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, Level level,
                                          @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand,
                                          @NotNull BlockHitResult res) {
        // 判断在服务器
        if (!level.isClientSide()&& hand == InteractionHand.MAIN_HAND){
            BlockEntity entity = level.getBlockEntity(pos);
            // 尝试打开GUI可以能会报错，传入参数是player，entity，pos
            if (entity instanceof DryingRackBlockEntity){
                if (((DryingRackBlockEntity) entity).itemStackHandler.getStackInSlot(0).isEmpty()&&((DryingRackBlockEntity) entity).itemStackHandler.getStackInSlot(1).isEmpty()) {
                    if (!player.getItemInHand(hand).isEmpty()) {
                        ItemStack itemStack = player.getItemInHand(hand);
                        ((DryingRackBlockEntity) entity).itemStackHandler.setStackInSlot(0, new ItemStack(itemStack.getItem(), 1));
                        itemStack.shrink(1);
                    }
                    if (player.getItemInHand(hand).isEmpty() && !player.getItemInHand(InteractionHand.OFF_HAND).isEmpty()) {
                        ItemStack itemStack = player.getItemInHand(InteractionHand.OFF_HAND);
                        ((DryingRackBlockEntity) entity).itemStackHandler.setStackInSlot(0, new ItemStack(itemStack.getItem(), 1));
                        itemStack.shrink(1);
                    }
                    return InteractionResult.SUCCESS;
                } else if (!((DryingRackBlockEntity) entity).itemStackHandler.getStackInSlot(0).isEmpty()) {
                    ItemHandlerHelper.giveItemToPlayer(player, ((DryingRackBlockEntity) entity).itemStackHandler.getStackInSlot(0), player.getInventory().selected);
                    ((DryingRackBlockEntity) entity).itemStackHandler.extractItem(0, 1, false);
                    level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
                } else  {
                    ItemHandlerHelper.giveItemToPlayer(player, ((DryingRackBlockEntity) entity).itemStackHandler.getStackInSlot(1), player.getInventory().selected);
                    ((DryingRackBlockEntity) entity).itemStackHandler.extractItem(1, 1, false);
                    level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
                }return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DryingRackBlockEntity(pos,state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        // 为指定的实体创建一个新的BlockEntityticker
        return createTickerHelper(type, ModBlockEntities.Drying_Rack.get(),
                DryingRackBlockEntity::tick);
    }
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;// 具有属性是水平的朝向
    public DryingRackBlock(Properties properties) {
        super(properties);
    }
    private static final VoxelShape EAST =
            Block.box(6, 12, 0, 10, 16, 16);
    private static final VoxelShape NORTH =
            Block.box(0, 12, 6, 16, 16, 10);

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        Direction direction = p_60555_.getValue(FACING);
        return switch (direction) {
            case EAST, WEST -> EAST;
            default -> NORTH;
        };
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }
    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }
    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}