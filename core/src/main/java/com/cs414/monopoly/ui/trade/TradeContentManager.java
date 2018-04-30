package com.cs414.monopoly.ui.trade;

import com.cs414.monopoly.entities.Player;

public class TradeContentManager extends TradeContent {

  public TradeContentManager(Player player, boolean swap, NetWorthLabel netWorth){
    super(player, netWorth);
    if(swap){
      add(buttonTable);
      add(labelTable);
    } else{
      add(labelTable);
      add(buttonTable);
    }
  }
}
