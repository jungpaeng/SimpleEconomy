package com.paeng.simpleEconomy

import com.paeng.simpleEconomy.API.EconomyManager
import com.paeng.simpleEconomy.API.SLAPI
import com.paeng.simpleEconomy.Commands.EconomyCommands
import com.paeng.simpleEconomy.Listeners.PlayerJoin
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class SimpleEconomy: JavaPlugin() {
  override fun onEnable() {
    getCommand("secon")?.setExecutor(EconomyCommands())
    EconomyManager.plugin = this
    SLAPI.loadBalances()
    Bukkit.getPluginManager().registerEvents(PlayerJoin(), this)
  }

  override fun onDisable() {
    SLAPI.saveBalances()
  }
}