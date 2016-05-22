package com.gerbshert.commercium;

import com.gerbshert.commercium.client.gui.GuiEvent;
import com.gerbshert.commercium.commands.old.*;
import com.gerbshert.commercium.libraries.Strings;
import com.gerbshert.commercium.network.PacketHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;


/**
 * Created by Gabriel on 17-May-16.
 */
@Mod(modid = Strings.MOD_ID, version = Strings.MOD_VRESION, name = Strings.MOD_NAME)
public class Commercium {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new GuiEvent());
        PacketHandler.registerPackets();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        //event.registerServercommand(new CommandBase());
        //event.registerServerCommand(new CommandConfig());
        event.registerServerCommand(new CommandGift());
        event.registerServerCommand(new CommandHelp());
        event.registerServerCommand(new CommandSteal());
        event.registerServerCommand(new CommandPay());
        event.registerServerCommand(new CommandPlayerAdd());
        event.registerServerCommand(new CommandPlayerSet());
        //event.registerServerCommand(new CommandTrade());
    }

}

