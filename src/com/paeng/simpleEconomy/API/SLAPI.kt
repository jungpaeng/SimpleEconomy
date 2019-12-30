package com.paeng.simpleEconomy.API

import com.paeng.simpleEconomy.SimpleEconomy

object SLAPI {
  var plugin: SimpleEconomy = EconomyManager.plugin!!;

  fun saveBalances() {
    for (p in EconomyManager.getBalanceMap().keys) {
      plugin.config.set("config$p", EconomyManager.balance.get(p))
    }

    plugin.saveConfig()
  }

  fun loadBalances() {
    if (plugin.config.contains("balance")) return

    for (s in plugin.config.getConfigurationSection("balance")!!.getKeys(false)) {
      EconomyManager.setBalance(s, plugin.config.getDouble("balance$s"))
    }
  }
}