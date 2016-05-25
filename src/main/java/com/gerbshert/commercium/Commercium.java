package com.gerbshert.commercium;

import com.gerbshert.commercium.commands.CommandEcon;
import com.gerbshert.commercium.libraries.Strings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
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

    public static class Events {
        @Mod.EventHandler
        public void serverJoin(PlayerDropsEvent event) {
            System.out.println("Player Joined");
            /*if (event.getEntity() instanceof EntityPlayer) {
                System.out.println("Player Joined");
                String player = ((EntityPlayer) event.getEntity()).getDisplayNameString();
                if (!BankData.getPlayerExist(player)) {
                    BankData.newPlayerBalance(player);
                }

            }*/
        }
    }
}

