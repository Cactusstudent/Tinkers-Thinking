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
import slimeknights.tconstruct.TConstruct;

public class DryingRackRecipesCategory implements IRecipeCategory<DryingRackRecipes> {
    public static final ResourceLocation UID = new ResourceLocation(TinkersThinking.MODID,
            "drying_rack");
    public static final ResourceLocation TEXTURE = new ResourceLocation(TinkersThinking.MODID,
            "textures/gui/drying_rack_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    // 构造方法
    public DryingRackRecipesCategory(IGuiHelper helper){
        this.background  = helper.createDrawable(TEXTURE,0,0,176,85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK,new ItemStack(ModBlocks.drying_rack.get()));

    }
    @Override
    public @NotNull RecipeType<DryingRackRecipes> getRecipeType() {
        return JEIModPlugin.DryingRackRecipes_TYPE;
    }
    @Override
    public @NotNull Component getTitle() {
        return TConstruct.makeTranslation("jei", "drying_rack");
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
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, DryingRackRecipes recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT,86,15).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT,86,60).addItemStack(recipe.getResultItem());
    }
}
