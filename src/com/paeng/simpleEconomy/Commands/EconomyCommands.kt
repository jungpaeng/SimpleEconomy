package com.paeng.simpleEconomy.Commands

import com.paeng.simpleEconomy.API.EconomyManager
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class EconomyCommands: CommandExecutor {
  fun chkEconomyAccount(player: String): Boolean {
    return EconomyManager.hasAccount(player)
  }

  override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
    if (args.size != 3) {
      sender.sendMessage("${ChatColor.RED}You cannot use this command like that!")
      sender.sendMessage("${ChatColor.GREEN}Usage: /secon <add/remove/set> <player> <amount>")
      return false;
    } else if (args[0] == "add") {
      if (chkEconomyAccount(args[1])) {
        try {
          EconomyManager.setBalance(args[1], EconomyManager.getBalance(args[1]) + args[2].toDouble())
        } catch (e: Exception) {
          sender.sendMessage("${ChatColor.RED}You gotta enter in a number")
          return false
        }
      } else {
        sender.sendMessage("${ChatColor.RED}Error: Player doesn't have an account")
      }
    } else if (args[0] == "remove") {
      if (chkEconomyAccount(args[1])) {
        try {
          EconomyManager.setBalance(args[1], EconomyManager.getBalance(args[1]) - args[2].toDouble())
        } catch (e: Exception) {
          sender.sendMessage("${ChatColor.RED}You gotta enter in a number")
          return false
        }
      } else {
        sender.sendMessage("${ChatColor.RED}Error: Player doesn't have an account")
      }
    } else if (args[0] == "set") {
      if (chkEconomyAccount(args[1])) {
        try {
          EconomyManager.setBalance(args[1], args[2].toDouble())
        } catch (e: Exception) {
          sender.sendMessage("${ChatColor.RED}You gotta enter in a number")
          return false
        }
      } else {
        sender.sendMessage("${ChatColor.RED}Error: Player doesn't have an account")
      }
    } else {
      sender.sendMessage("Incorrect argument!")
    }
    return true
  }
}