package com.cs414.monopoly.ui.playerhud;

import com.cs414.monopoly.entities.Player;
import java.util.Comparator;

public class PlayerMoneyComparator implements Comparator<Player> {
  @Override
  public int compare(Player p1, Player p2) {
    return p1.getNetWorth() - p2.getNetWorth();
  }
}
