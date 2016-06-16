package com.gerbshert.commercium.commands;

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

import java.util.List;

/**
 * Created by Gabriel on 15-Jun-16.
 */
public class CommandEconCommands extends CommandBase {
    public CommandEconCommands() {
    }

    @Override
    public String getCommandName() {
        return "econCommands";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/econCommands";
    }

    @Override
    public List<String> getCommandAliases() {
        return Lists.newArrayList(new String[]{"econCommands", "economyCommands", "commerceCommands", Strings.MOD_ID + "Commands", "econcommands", "economycommands", "commercecommands", Strings.MOD_ID + "commands"});
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender instanceof EntityPlayer) {
            sender.addChatMessage(new TextComponentString("[Commercium]: Available Commands { econAdd, econSet, econRemove, econPay, econBalance, econModInfo }"));
        }
    }


    @Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) {
        return null;
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