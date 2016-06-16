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
 * Created by Gabriel on 22-May-16.
 */
public class CommandEcon extends CommandBase {
    public CommandEcon() {
    }

    @Override
    public String getCommandName() {
        return "econ";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/econ";
    }

    @Override
    public List<String> getCommandAliases() {
        return Lists.newArrayList(new String[]{"econ", "economy", "commerce", Strings.MOD_ID});
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender instanceof EntityPlayer) {
            sender.addChatMessage(new TextComponentString("[Commercium]: Welcome to Commercium! Use /econCommands for a list of available commands."));
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
