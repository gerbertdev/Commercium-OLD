package com.gerbshert.commercium.commands;

import com.gerbshert.commercium.Bank;
import com.gerbshert.commercium.bankdata.DataHandler;
import net.minecraft.command.ICommandSender;
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
    static Boolean isPlayer = false;

    public static void executeEconCommand(String[] args, World world, ICommandSender senderMain) {
        if (senderMain instanceof EntityPlayer) {
            EntityPlayer player1 = world.getPlayerEntityByName(senderMain.getName());
            isPlayer = true;

            player1Name = player1.getDisplayNameString();
        }

        if (args.length == 0) {
            System.out.println("legth of 1");
            if (isPlayer) {
                player1.addChatMessage(new TextComponentString("[Commercium]: Usage = \"/econ <command> <arguments>\"."));
            }
        }
        if (args.length > 0) {
            String command = args[0];
            if (command.toUpperCase().equals("SET")) {
                if (args.length == 3) {
                    player2 = world.getPlayerEntityByName(args[1]);
                    player2Name = player2.getDisplayNameString();
                    Double amount = 0.00;
                    Boolean commandRan = true;
                    try {
                        amount = Double.parseDouble(args[2]);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        commandRan = false;
                    } finally {
                        if (commandRan = true) {
                            if (amount < 0 && isPlayer) {
                                player1.addChatMessage(new TextComponentString("[Commercium]: Number must be greater than 0."));
                            } else {
                                if (isPlayer) {
                                    player1.addChatMessage(new TextComponentString("[Commercium]: " + player2Name + " balance was set to " + amount));
                                }
                                player2.addChatMessage(new TextComponentString("[Commercium]: Your balance was set to " + amount + " by an administrator"));
                                Bank.setBalance(player2Name, amount);
                            }

                        } else {
                            if (isPlayer) {
                                player1.addChatMessage(new TextComponentString("[Commercium]: " + args[2] + " is not a number. Use '/econ help set' for more info."));
                            }
                        }

                    }
                } else {
                    if (isPlayer) {
                        player1.addChatMessage(new TextComponentString("[Commercium]: Use '/econ help set' for more info on this command"));
                    }
                }

            }
            if (command.toUpperCase().equals("ADD")) {
                if (args.length == 3) {
                    player2 = world.getPlayerEntityByName(args[1]);
                    player2Name = player2.getDisplayNameString();
                    Double amount = 0.00;
                    Boolean commandRan = true;
                    try {
                        amount = Double.parseDouble(args[2]);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        commandRan = false;
                    } finally {
                        if (commandRan = true) {
                            if (amount < 0 && isPlayer) {
                                player1.addChatMessage(new TextComponentString("[Commercium]: Number must be greater than 0."));
                            } else {
                                if (isPlayer) {
                                    player1.addChatMessage(new TextComponentString("[Commercium]: " + player2Name + " balance was increased " + amount));
                                }
                                player2.addChatMessage(new TextComponentString("[Commercium]: Your balance was increased to " + amount + " by an administrator"));
                                Bank.addBalance(player2Name, amount);
                            }

                        } else {
                            if (isPlayer) {
                                player1.addChatMessage(new TextComponentString("[Commercium]: " + args[2] + " is not a number. Use '/econ help add' for more info."));
                            }
                        }

                    }
                } else {
                    player1.addChatMessage(new TextComponentString("[Commercium]: Use '/econ help add' for more info on this command"));
                }
            }
            if (command.toUpperCase().equals("TAKE")) {
                if (args.length == 3) {
                    player2 = world.getPlayerEntityByName(args[1]);
                    player2Name = args[1];
                    Double amount = 0.00;
                    Boolean commandRan = true;
                    try {
                        amount = Double.parseDouble(args[2]);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        commandRan = false;
                    } finally {
                        if (commandRan = true) {
                            if (amount > 0 && isPlayer) {
                                player1.addChatMessage(new TextComponentString("[Commercium]: Number must be less than 0."));
                            } else {
                                if (isPlayer) {
                                    player1.addChatMessage(new TextComponentString("[Commercium]: " + player2Name + " balance was deceased by " + amount));
                                }
                                player2.addChatMessage(new TextComponentString("[Commercium]: Your balance was deceased by " + amount + " by an administrator"));
                                Bank.removeBalance(player2Name, amount);
                            }

                        } else {
                            if (isPlayer) {
                                player1.addChatMessage(new TextComponentString("[Commercium]: " + args[2] + " is not a number. Use '/econ help take' for more info."));
                            }
                        }

                    }
                } else {
                    if (isPlayer) {

                        player1.addChatMessage(new TextComponentString("[Commercium]: Use '/econ help take' for more info on this command"));
                    }
                }
            }
            if (command.toUpperCase().equals("BALANCE")) {
                if (args.length == 3) {
                    player2 = world.getPlayerEntityByName(args[1]);
                    player2Name = player2.getDisplayNameString();
                    if (DataHandler.getPlayerExist(player2Name)) {
                        if (isPlayer) {
                            player1.addChatMessage(new TextComponentString("[Commercium]: " + player2Name + " balance is " + Bank.getBalance(player2Name)));
                        }
                    } else {
                        if (isPlayer) {

                            player1.addChatMessage(new TextComponentString("[Commercium]: That player has yet to join the server."));
                        }
                    }
                } else if (args.length == 2) {
                    if (isPlayer) {

                        player1.addChatMessage(new TextComponentString("[Commercium]: Your balance is " + Bank.getBalance(player1Name)));
                    }
                } else {
                    if (isPlayer) {

                        player1.addChatMessage(new TextComponentString("[Commercium]: Use '/econ help balance' for more info on this command"));
                    }
                }
            }
            if (command.toUpperCase().equals("PAY")) {
                if (args.length == 3) {
                    player2 = world.getPlayerEntityByName(args[1]);
                    player2Name = player2.getDisplayNameString();
                    Double amount = 0.00;
                    Boolean commandRan = true;
                    try {
                        amount = Double.parseDouble(args[2]);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        commandRan = false;
                    } finally {
                        if (commandRan = true) {
                            if (amount < 0) {
                                if (isPlayer) {
                                    player1.addChatMessage(new TextComponentString("[Commercium]: Number must be greater than 0."));
                                }
                            } else {
                                if (isPlayer) {

                                    player1.addChatMessage(new TextComponentString("[Commercium]: " + player2Name + " was paid " + amount));
                                }
                                player2.addChatMessage(new TextComponentString("[Commercium]: You were paid " + amount + " by " + player1Name));
                                Bank.sendBalance(player1Name, player2Name, amount);
                            }

                        } else {
                            if (isPlayer) {
                                player1.addChatMessage(new TextComponentString("[Commercium]: " + args[2] + " is not a number. Use '/econ help pay' for more info."));
                            }
                        }

                    }
                } else {
                    if (isPlayer) {

                        player1.addChatMessage(new TextComponentString("[Commercium]: Use '/econ help pay' for more info on this command"));
                    }
                }
            }
            if (command.toUpperCase().equals("HELP")) {
                if (args.length != 2) {
                    if (isPlayer) {
                        player1.addChatMessage(new TextComponentString("[Commercium]: Use '/econ help <command>' for more info on a command"));
                    }
                } else {
                    if (isPlayer) {
                        String command2 = args[1].toLowerCase();
                        if (command2.equals("pay")) {
                            player1.addChatMessage(new TextComponentString("[Commercium]: Used to send currency from your balance to another player || '/econ pay <player> <amount>'"));
                        } else if (command2.equals("balance")) {
                            player1.addChatMessage(new TextComponentString("[Commercium]: Use to check yours or another players balance || '/econ balance [player]'"));
                        } else if (command2.equals("help")) {
                            player1.addChatMessage(new TextComponentString("[Commercium]: Used to get in-game information on each command. || '/econ help <command>'"));
                        } else if (command2.equals("set")) {
                            player1.addChatMessage(new TextComponentString("[Commercium]: Used to set a players balance to a given amount || '/econ set <player> <amount>'"));
                        } else if (command2.equals("take")) {
                            player1.addChatMessage(new TextComponentString("[Commercium]: Used to remove a given amount from a players balance || '/econ take <player> <amount>'"));
                        } else if (command2.equals("add")) {
                            player1.addChatMessage(new TextComponentString("[Commercium]: Used to add a given amount to a players balance || '/econ add <player> <amount>'"));
                        } else if (command2.equals("commands")) {
                            player1.addChatMessage(new TextComponentString("[Commercium]: Shows all available commands. || '/econ commands'"));
                        }
                    }
                }
            }
            if (command.toUpperCase().equals("COMMANDS")) {
                if (isPlayer) {

                    player1.addChatMessage(new TextComponentString("[Commercium]: pay, balance, help, set(op), take(op), add(op)"));
                }
            }
        }
    }
}
