package com.gerbshert.commercium.commands;

import com.gerbshert.commercium.Bank;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

/**
 * Created by Gabriel on 22-May-16.
 */
public class EconCommandHandler {
    static String player1Name;
    static String player2Name;
    static EntityPlayer player1;
    static EntityPlayer player2;


    public static void executeEconCommand(EntityPlayer sender, String[] args, World world) {
        player1 = sender;
        player1Name = player1.getDisplayNameString();

        if (args.length == 0) {
            System.out.println("legth of 1");
            sender.addChatMessage(new TextComponentString("[Commercium]: Usage = \"/econ <command> <arguments>\"."));
        }
        if (args.length == 1) {
            System.out.println("legth of 2");
            String command = args[0];
            System.out.println(command);
            if (command.equals("bank") || command.equals("bal") || command.equals("balance")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: Your bank balance is " + Bank.getBalance(sender.getName()) + " ."));
            } else if (command.equals("pay")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: Usage = \"/econ pay <player> <amount>\"."));
            } else if (command.equals("gift")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: Usage = \"/econ gift <player> <amount>\"."));
            } else if (command.equals("set")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: (OP ONLY) Usage = \"/econ set <player> <amount>\"."));
            } else if (command.equals("give")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: (OP ONLY) Usage = \"/econ give <player> <amount>\"."));
            } else if (command.equals("take")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: (OP ONLY) Usage = \"/econ take <player> <amount>\"."));
            } else if (command.equals("help")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: (OP ONLY) Usage = \"/econ help <command>\"."));
            } else if (command.equals("commands")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: balance(bank, bal), pay(gift), set[OP only], give[OP only], take[OP only], help, commands."));
            }
        }
        if (args.length == 2) {
            player2 = world.getPlayerEntityByName(args[1]);
            player2Name = player2.getDisplayNameString();
            System.out.println("legth of 3");
            String command = args[0];
            System.out.println(command);
            EntityPlayer editie = world.getPlayerEntityByName(args[1]);
            String help = args[1];
            if (command.equals("bank") || command.equals("bal") || command.equals("balance")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: " + editie.getDisplayName() + "'s bank balance is " + Bank.getBalance(args[1]) + "."));
            } else if (command.equals("pay")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: Usage = \"/econ pay <player> <amount>\"."));
            } else if (command.equals("gift")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: Usage = \"/econ gift <player> <amount>\"."));
            } else if (command.equals("set")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: (OP ONLY) Usage = \"/econ set <player> <amount>\"."));
            } else if (command.equals("give")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: (OP ONLY) Usage = \"/econ give <player> <amount>\"."));
            } else if (command.equals("take")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: (OP ONLY) Usage = \"/econ take <player> <amount>\"."));
            } else if (command.equals("help")) {
                if ((help == "bank") || (help == "bal") || (help == "balance")) {
                    sender.addChatMessage(new TextComponentString("[Commercium]: Shows currency balance in you bank."));
                } else if (command.equals("pay")) {
                    sender.addChatMessage(new TextComponentString("[Commercium]: Pays a player a given amount from your balance."));
                } else if (command.equals("gift")) {
                    sender.addChatMessage(new TextComponentString("[Commercium]: Gifts a player a given amount from your balance."));
                } else if (command.equals("set")) {
                    sender.addChatMessage(new TextComponentString("[Commercium]: (OP ONLY) Sets a player's bank balance to a given amount."));
                } else if (command.equals("give")) {
                    sender.addChatMessage(new TextComponentString("[Commercium]: (OP ONLY) Adds a given amount to a player's bank balance."));
                } else if (command.equals("take")) {
                    sender.addChatMessage(new TextComponentString("[Commercium]: (OP ONLY) Removes a given amount to a player's bank balance."));
                } else if (command.equals("help")) {
                    sender.addChatMessage(new TextComponentString("[Commercium]: Shows help about a given command."));
                } else if (command.equals("commands")) {
                    sender.addChatMessage(new TextComponentString("[Commercium]: Shows available commands for Commercium."));
                }
            } else if (command.equals("commands")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: Usage = \"/econ commands\"."));
            }
        }
        if (args.length == 3) {
            player2 = world.getPlayerEntityByName(args[1]);
            player2Name = player2.getDisplayNameString();
            System.out.println("legth of 4");
            String command = args[0];
            System.out.println(command);
            String editie = args[1];
            Double amount = Double.parseDouble(args[2]);
            if (command.equals("bank") || command.equals("bal") || command.equals("balance")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: Usage = \"/econ balance {player}\".(Player Optional)"));
            } else if (command.equals("pay")) {
                Bank.sendBalance(sender.getDisplayNameString(), editie, amount);
                sender.addChatMessage(new TextComponentString("[Commercium]: Paid " + world.getPlayerEntityByName(editie).getDisplayName() + " " + Double.toString(amount)));
                world.getPlayerEntityByName(editie).addChatMessage(new TextComponentString("[Commercium]: Received payment from " + sender.getDisplayName() + " of " + Double.toString(amount)));
            } else if (command.equals("gift")) {
                Bank.sendBalance(sender.getDisplayNameString(), editie, amount);
                sender.addChatMessage(new TextComponentString("[Commercium]: Gifted " + editie + " " + Double.toString(amount)));
                world.getPlayerEntityByName(editie).addChatMessage(new TextComponentString("[Commercium]: Received gift from " + sender.getDisplayName() + " of " + Double.toString(amount)));
            } else if (command.equals("set")) {
                Bank.setBalance(editie, amount);
                sender.addChatMessage(new TextComponentString("[Commercium]: Set " + editie + "'s balance to " + Double.toString(amount)));
                world.getPlayerEntityByName(editie).addChatMessage(new TextComponentString("[Commercium]: A server operator changed your bank's balance to " + Double.toString(amount)));
            } else if (command.equals("give")) {
                Bank.addBalance(editie, amount);
                sender.addChatMessage(new TextComponentString("[Commercium]: " + editie + "'s balance was increased by " + Double.toString(amount)));
                world.getPlayerEntityByName(editie).addChatMessage(new TextComponentString("[Commercium]: A server operator added " + Double.toString(amount) + " to your bank's balance"));
            } else if (command.equals("take")) {
                Bank.removeBalance(editie, amount);
                sender.addChatMessage(new TextComponentString("[Commercium]: " + editie + "'s balance was decreased by " + Double.toString(amount)));
                world.getPlayerEntityByName(editie).addChatMessage(new TextComponentString("[Commercium]: A server operator removed " + Double.toString(amount) + " from your bank's balance"));
            } else if (command.equals("help")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: Usage = \"/econ help <command>\"."));
            } else if (command.equals("commands")) {
                sender.addChatMessage(new TextComponentString("[Commercium]: Usage = \"/econ commands\"."));
            }
        }
        if (args.length > 3) {
            player2 = world.getPlayerEntityByName(args[1]);
            player2Name = player2.getDisplayNameString();
            sender.addChatMessage(new TextComponentString("[Commercium]: Usage = \"/econ <command> <arguments>\"."));
        }
    }
}
