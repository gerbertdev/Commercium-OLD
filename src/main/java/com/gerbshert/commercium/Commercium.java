package com.gerbshert.commercium;

import com.gerbshert.commercium.bankdata.DataHandler;
import com.gerbshert.commercium.commands.CommandEcon;
import com.gerbshert.commercium.commands.CommandEconBalance;
import com.gerbshert.commercium.commands.CommandEconCommands;
import com.gerbshert.commercium.commands.CommandEconModInfo;
import com.gerbshert.commercium.libraries.Strings;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import static com.gerbshert.commercium.bankdata.DataReaderWriter.loadDataToArray;
import static com.gerbshert.commercium.bankdata.DataReaderWriter.unloadArrayToData;


/**
 * Created by Gabriel on 17-May-16.
 */
@Mod(modid = Strings.MOD_ID, version = Strings.MOD_VRESION, name = Strings.MOD_NAME, acceptableRemoteVersions = "*")
public class Commercium {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        new DataHandler();
        MinecraftForge.EVENT_BUS.register(new Events());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        loadDataToArray();
        event.registerServerCommand(new CommandEcon());
        event.registerServerCommand(new CommandEconCommands());
        event.registerServerCommand(new CommandEconModInfo());
        event.registerServerCommand(new CommandEconBalance());
    }

    @Mod.EventHandler
    public void serverUnload(FMLServerStoppingEvent event) {
        unloadArrayToData();
    }

    private class Events {
        @SubscribeEvent
        public void serverJoin(PlayerEvent.PlayerLoggedInEvent event) {
            String player = event.player.getDisplayNameString();
            if (!DataHandler.getPlayerExist(player)) {
                DataHandler.newPlayerBalance(player);
            }
        }
    }
}

