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

import java.util.List;

/**
 * Created by Gabriel on 15-Jun-16.
 */
public class CommandEconPay extends CommandBase {
    public CommandEconPay() {
    }

    @Override
    public String getCommandName() {
        return "econPay";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/econPay {playerName}";
    }

    @Override
    public List<String> getCommandAliases() {
        return Lists.newArrayList(new String[]{"econPay", "economyPay", "commercePay", Strings.MOD_ID + "Pay", "econpay", "economypay", "commercepay", Strings.MOD_ID + "pay"});
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        Double amount = 0.00;
        Boolean commandRan = true;

        try {
            amount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            commandRan = false;
        } finally {
            if (commandRan) {
                if (sender instanceof EntityPlayer) {
                    switch (args.length) {
                        case 2:
                            Bank.sendBalance(sender.getName(), args[1], amount);
                            ((EntityPlayer) sender).addChatMessage(new TextComponentString("[Commercium]: you sent" + args[1] + amount));
                            break;
                        default:
                            ((EntityPlayer) sender).addChatMessage(new TextComponentString("[Commercium]: Try '/help econPay'"));
                            break;
                    }
                }
            } else {
                if (sender instanceof EntityPlayer) {
                    sender.addChatMessage(new TextComponentString("[Commercium]: " + args[0] + " is not a valid number"));
                }
            }
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