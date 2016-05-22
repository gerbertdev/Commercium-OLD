package com.gerbshert.commercium.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Gabriel on 18-May-16.
 */
public class GuiEvent {

    @SideOnly(value = Side.CLIENT)
    @SubscribeEvent
    public void guiPostInit(GuiScreenEvent.InitGuiEvent.Post event) {
        if (event.getGui() instanceof GuiInventory) {
            GuiContainer gui = (GuiContainer) event.getGui();
            int INVENTORYSIZEX = 176;
            int INVENTORYSIZEY = 166;
            int guiLeft = (gui.width - INVENTORYSIZEX) / 2;
            int guiTop = (gui.height - INVENTORYSIZEY) / 2;

            if (!gui.mc.thePlayer.getActivePotionEffects().isEmpty()) {
                guiLeft = 160 + (gui.width - INVENTORYSIZEX - 200) / 2;
            }
            event.getButtonList().add(new CurrencyStat(354, guiLeft + 160, guiTop + 71, 10, 10, "currency"));
        }
    }
}
