package com.gerbshert.commercium.client.gui;


import com.gerbshert.commercium.Bank;
import com.gerbshert.commercium.libraries.Strings;
import com.gerbshert.commercium.network.NetworkRequestPlayerData;
import com.gerbshert.commercium.network.PacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Gabriel on 18-May-16.
 */
public class CurrencyStat extends GuiButton {
    protected static final ResourceLocation currencyTextures = new ResourceLocation(Strings.MOD_ID, "textures/gui/coinStack.png");
    protected int updateTick = 0;

    public CurrencyStat(int buttonId, int x, int y, int width, int height, String buttonText) {
        super(buttonId, x, y, width, height, buttonText);
    }

    public void drawButton(Minecraft mc, int x, int y) {
        if (this.visible) {
            String playerName = mc.thePlayer.getName();
            if (updateTick >= 3) {
                PacketHandler.network.sendToServer(new NetworkRequestPlayerData(playerName));
                updateTick = 0;
            } else {
                updateTick = updateTick + 1;
            }


            mc.getTextureManager().bindTexture(currencyTextures);
            FontRenderer fontrenderer = mc.fontRendererObj;
            this.drawModalRectWithCustomSizedTexture(this.xPosition, this.yPosition, 0, 0, 10, 10, 10, 10);
            fontrenderer.drawString(Bank.getClientPlayerBank(playerName), (float) ((this.xPosition - 13)
                    - fontrenderer.getStringWidth(Bank.getClientPlayerBank(playerName)) / 2), (float) (this.yPosition + 2), 0x333333, false);
        }
    }
}