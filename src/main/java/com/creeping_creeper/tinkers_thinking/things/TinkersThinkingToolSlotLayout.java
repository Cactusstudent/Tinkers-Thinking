package com.creeping_creeper.tinkers_thinking.things;
import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.tinkering.AbstractStationSlotLayoutProvider;
import slimeknights.tconstruct.tools.TinkerToolParts;

import javax.annotation.Nonnull;
public class TinkersThinkingToolSlotLayout extends AbstractStationSlotLayoutProvider {

        public TinkersThinkingToolSlotLayout(DataGenerator generator) {
            super(generator);
        }

        @Override
        protected void addLayouts() {
            defineModifiable(TinkersThinkingItems.Paxel)
                    .sortIndex(SORT_HARVEST)
                    .addInputItem(TinkerToolParts.smallAxeHead.get(), 31, 22)
                    .addInputItem(TinkerToolParts.toolHandle.get(), 22, 53)
                    .addInputItem(TinkerToolParts.pickHead.get(), 22, 53)
                    .build();

            defineModifiable(TinkersThinkingItems.Knife)
                    .sortIndex(SORT_WEAPON)
                    .addInputItem(TinkersThinkingItems.Narrow_Blade.get(), 30, 21)
                    .addInputItem(TinkerToolParts.toolHandle.get(), 22, 53)
                    .addInputItem(TinkersThinkingItems.Narrow_Blade.get(), 51, 40)
                    .build();

            defineModifiable(TinkersThinkingItems.Knife)
                    .sortIndex(SORT_RANGED + SORT_LARGE)
                    .addInputItem(TinkerToolParts.bowGrip.get(), 25, 30)
                    .addInputItem(TinkerToolParts.bowLimb.get(), 45, 50)
                    .addInputItem(TinkerToolParts.bowGrip.get(), 65, 70)
                    .build();
        }

            @Nonnull
            @Override
            public String getName() {
                return "Tinkers Thinking Tool Slot Layout";
            }
}
