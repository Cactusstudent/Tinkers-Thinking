package com.creeping_creeper.tinkers_thinking.common.integration;
import com.creeping_creeper.tinkers_thinking.TinkersThinking;
import com.creeping_creeper.tinkers_thinking.common.recipes.DryingRackRecipes;
import com.creeping_creeper.tinkers_thinking.common.things.ModBlocks;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DryingRackRecipesCategory implements IRecipeCategory<DryingRackRecipes> {
    // 区分合成分类的ID
    public static final ResourceLocation UID = new ResourceLocation(TinkersThinking.MODID,
            "drying_rack");
    // png file texture
    public static final ResourceLocation TEXTURE = new ResourceLocation(TinkersThinking.MODID,
            "textures/gui/drying_rack_gui.png");

    // 合成分类的背景图片
    private final IDrawable background;
    // 合成分类的图标
    private final IDrawable icon;

    // 构造方法
    public DryingRackRecipesCategory(IGuiHelper helper){
        // 渲染背景图片。图片的开始位置和图片的结束的位置 u,v,width,height
        this.background  = helper.createDrawable(TEXTURE,0,0,176,85);
        // 图标
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK,new ItemStack(ModBlocks.drying_rack.get()));

    }

    // 返回JEITutorialModPlugin定义的type
    @Override
    public @NotNull RecipeType<DryingRackRecipes> getRecipeType() {
        return JEITutorialModPlugin.DryingRackRecipes_TYPE;
    }

    // 合成界面的标题是什么
    @Override
    public @NotNull Component getTitle() {
        return Component.literal("Drying Rack");
    }
    //
    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    // 添加合成表的输入slot和输出的slot
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, DryingRackRecipes recipe, @NotNull IFocusGroup focuses) {
        // 在86,15的位置设置一个用于输入的slot，内容为recipe的ingredients的第0个。
        builder.addSlot(RecipeIngredientRole.INPUT,86,15).addIngredients(recipe.getIngredients().get(0));
        // 在86,60的位置设置一个用于输出的slot，内容为recipe的合成结果。
        builder.addSlot(RecipeIngredientRole.OUTPUT,86,60).addItemStack(recipe.getResultItem());
    }
}
