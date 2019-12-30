package com.paeng.simpleEconomy.API

import com.paeng.simpleEconomy.SimpleEconomy

object EconomyManager {
  val balance = HashMap<String, Double>();
  var plugin: SimpleEconomy? = null

  fun setBalance(player: String, amount: Double) {
    balance.put(player, amount)
  }

  fun getBalance(player: String): Double {
    return balance.get(player)!!
  }

  fun hasAccount(player: String): Boolean {
    return balance.containsKey(player)
  }

  fun getBalanceMap(): HashMap<String, Double> {
    return balance
  }
}