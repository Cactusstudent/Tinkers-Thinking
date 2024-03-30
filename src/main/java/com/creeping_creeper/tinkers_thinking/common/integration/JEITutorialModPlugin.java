package com.creeping_creeper.tinkers_thinking.common.integration;

import com.creeping_creeper.tinkers_thinking.TinkersThinking;
import com.creeping_creeper.tinkers_thinking.common.recipes.DryingRackRecipes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

    @JeiPlugin
    public class JEITutorialModPlugin implements IModPlugin {
        // 使用category指定一个type
        public static RecipeType<DryingRackRecipes> DryingRackRecipes_TYPE =
                new RecipeType<>(DryingRackRecipesCategory.UID, DryingRackRecipes.class);


        //返回插件的id
        @Override
        public @NotNull ResourceLocation getPluginUid() {
            return new ResourceLocation(TinkersThinking.MODID,"jei_plugin");

        }
        // 将type注册到JEIplugin
        // 自定义物品合成的分类以及该分类下的物品的位置
        @Override
        public void registerCategories(IRecipeCategoryRegistration registration) {
            registration.addRecipeCategories(new DryingRackRecipesCategory(registration.getJeiHelpers().getGuiHelper()));
        }

        // 注册合成的信息
        // 获得所有的该type下的所有合成表。
        // 注册type的合成表
        @Override
        public void registerRecipes(IRecipeRegistration registration) {
            RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
            List<DryingRackRecipes> recipesDryingRack = rm.getAllRecipesFor(DryingRackRecipes.Type.INSTANCE);

            registration.addRecipes(DryingRackRecipes_TYPE,recipesDryingRack);
        }
}
