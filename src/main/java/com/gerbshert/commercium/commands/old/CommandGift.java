package com.gerbshert.commercium.commands.old;

import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.List;

/**
 * Created by Gabriel on 18-May-16.
 */
public class CommandGift extends CommandBase {
    public CommandGift() {
    }

    @Override
    public String getCommandName() {
        return "giftitem";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/giftitem <player> (sends item in hand)";
    }

    @Override
    public List<String> getCommandAliases() {
        return Lists.newArrayList(new String[]{"gift"});
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = sender.getEntityWorld();
        EntityPlayer player = world.getPlayerEntityByName(sender.getName());
        //CommerceEvents.sendItem(player, world.getPlayerEntityByName(args[0]), player.inventory.getCurrentItem());
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
        return 0;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}