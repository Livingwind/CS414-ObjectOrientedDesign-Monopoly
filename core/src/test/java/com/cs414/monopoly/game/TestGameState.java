package com.cs414.monopoly.game;

import com.badlogic.gdx.graphics.Color;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.TestGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;


public class TestGameState extends TestGame {

  private GameState game = new GameState();
  private String path = "assets/board_original/players/";
  private ArrayList<Player> players = new ArrayList<Player>();

  @Before public void setUp(){
    Player p0 = new Player(path+"boat.png","chris", Color.CYAN, 0);
    Player p1 = new Player(path+"car.png","ian", Color.GREEN, 1500);
    Player p2 = new Player(path+"dog.png","brandon", Color.BROWN, 1500);
    players.add(p0);
    players.add(p1);
    players.add(p2);
  }

  @Test
  public void testAddPlayers() {
    game.addPlayers(players);

    game.nextTurn();
    Assert.assertEquals("chris", game.getCurrentPlayer().name);
    Assert.assertEquals(0, game.getCurrentPlayer().getMoney());

    game.nextTurn();
    Assert.assertEquals("ian", game.getCurrentPlayer().name);
    Assert.assertEquals(1500, game.getCurrentPlayer().getMoney());

    game.nextTurn();
    Assert.assertEquals("brandon", game.getCurrentPlayer().name);
    Assert.assertEquals(1500, game.getCurrentPlayer().getMoney());
  }

  @Test
  public void testStartGameFail () {
    boolean fail = false;
    try {
      game.startGame(-1);
    } catch (IllegalStateException e) {
      fail = true;
    }
    assert(fail);
  }

  @Test
  public void testNextTurn(){
    game.addPlayers(players);
    game.nextTurn();
    Assert.assertEquals("chris", game.getCurrentPlayer().name);
    game.nextTurn();
    Assert.assertEquals("ian", game.getCurrentPlayer().name);
    game.nextTurn();
    Assert.assertEquals("brandon", game.getCurrentPlayer().name);
    game.nextTurn();
    Assert.assertEquals("chris", game.getCurrentPlayer().name);
  }
}