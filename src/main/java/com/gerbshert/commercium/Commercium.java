package com.gerbshert.commercium;

import com.gerbshert.commercium.commands.CommandEcon;
import com.gerbshert.commercium.libraries.Strings;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;


/**
 * Created by Gabriel on 17-May-16.
 */
@Mod(modid = Strings.MOD_ID, version = Strings.MOD_VRESION, name = Strings.MOD_NAME)
public class Commercium {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        new BankData();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new Events());

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandEcon());
        BankData.createBankData();
    }

    public class Events {
        @SubscribeEvent
        public void serverJoin(PlayerEvent.PlayerLoggedInEvent event) {
            System.out.println("Player Join Event");
            System.out.println("Player Joined");
            String player = event.player.getDisplayNameString();
            if (!BankData.getPlayerExist(player)) {
                BankData.newPlayerBalance(player);
            }
        }
    }
}
