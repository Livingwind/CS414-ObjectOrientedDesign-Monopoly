package com.cs414.monopoly.ui.playerhud;

import com.cs414.monopoly.entities.Player;

import java.util.Comparator;

public class PlayerNetWorthComparator implements Comparator<Player> {
  @Override
  public int compare(Player p1, Player p2) {
    return p2.getNetWorth() - p1.getNetWorth();
  }
}
