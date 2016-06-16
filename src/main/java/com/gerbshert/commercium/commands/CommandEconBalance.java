package com.gerbshert.commercium.commands;

import com.gerbshert.commercium.Bank;
import com.gerbshert.commercium.libraries.Strings;
import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.List;

/**
 * Created by Gabriel on 22-May-16.
 */
public class CommandEconBalance extends CommandBase {
    public CommandEconBalance() {
    }

    @Override
    public String getCommandName() {
        return "balance";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/balance <playerName>";
    }

    @Override
    public List<String> getCommandAliases() {
        return Lists.newArrayList(new String[]{"balance"});
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        switch (args.length) {
            case 0:
                if (sender instanceof EntityPlayer) {
                    ((EntityPlayer) sender).addChatMessage(new TextComponentString("[Commercium]: Your balance is " + Bank.getBalance(sender.getName())));
                }
                break;
            case 1:
                if (sender instanceof EntityPlayer) {
                    ((EntityPlayer) sender).addChatMessage(new TextComponentString("[Commercium]: Balance of " + args[1] + " is " + Bank.getBalance(args[1])));
                }
                ;
                break;
            default:
                if (sender instanceof EntityPlayer) {
                    ((EntityPlayer) sender).addChatMessage(new TextComponentString("[Commercium]: Try '/help balance'"));
                }
                ;
                break;
        }
    }


    @Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[]
            args, BlockPos pos) {
        return args.length == 2 ? getListOfStringsMatchingLastWord(args, server.getAllUsernames()) : Collections.<String>emptyList();
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
