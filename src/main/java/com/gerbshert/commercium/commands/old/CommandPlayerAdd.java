package com.gerbshert.commercium.commands.old;

import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.List;

/**
 * Created by Gabriel on 18-May-16.
 */
public class CommandPlayerAdd extends CommandBase {
    public CommandPlayerAdd() {
    }

    @Override
    public String getCommandName() {
        return "addmoney";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/addmoney <player> <amount>";
    }

    @Override
    public List<String> getCommandAliases() {
        return Lists.newArrayList(new String[]{"addmoney"});
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = sender.getEntityWorld();
        //CommerceEvents.addMoney(world.getPlayerEntityByName(args[0]), Double.parseDouble(args[1]));
    }

    @Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) {
        return args.length == 1 ? getListOfStringsMatchingLastWord(args, server.getAllUsernames()) : Collections.<String>emptyList();
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}