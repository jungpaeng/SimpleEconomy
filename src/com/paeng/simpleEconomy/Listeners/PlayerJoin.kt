package com.paeng.simpleEconomy.Listeners

import com.paeng.simpleEconomy.API.EconomyManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoin: Listener {
  @EventHandler
  fun onJoin(event: PlayerJoinEvent) {
    if (EconomyManager.hasAccount(event.player.name)) return
    EconomyManager.setBalance(event.player.name, 200.0);
  }
}