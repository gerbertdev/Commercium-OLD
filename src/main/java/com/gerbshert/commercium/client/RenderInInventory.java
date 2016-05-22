package com.gerbshert.commercium.client;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nonnull;

/**
 * Created by Gabriel on 18-May-16.
 */
public class RenderInInventory {
    @SubscribeEvent
    public void renderGUIpublic(@Nonnull GuiOpenEvent event) {
        if (event.getGui() instanceof GuiInventory) {
            GuiScreen gui = event.getGui();
        }
    }
}
