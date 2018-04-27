package com.cs414.monopoly.ui.playerhud;

import com.cs414.monopoly.entities.Player;

import java.util.Comparator;

public class PlayerNameComparator implements Comparator<Player> {
  @Override
  public int compare(Player p1, Player p2) {
    return p1.name.compareTo(p2.name);
  }
}