package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.PooledLinkedList;
import com.cs414.monopoly.entities.Player;

public class Jail extends AbstractSpace {
  Jail(String filename, int location, JsonValue props) {
    super(filename, location, props, Size.CORNER);
  }

  @Override
  public void onLand(Player player) {

  }

  @Override
  protected void repositionPlayers() {
    int inJail = 0;
    int outJail = 0;
    for(Player player: players) {
      if(player.inJail) {
        // Position the players in a square starting from top to bottom
        player.setPosition((getWidth()-player.getWidth())-(player.getWidth()*(inJail%2)),
            player.getHeight()*(inJail/2));
        inJail++;
      } else {
        player.setPosition(0, (player.getHeight() * outJail));
        outJail++;
      }
    }
  }


  @Override
  public void setPlayer(Player player) {
    super.setPlayer(player);
  }
}
