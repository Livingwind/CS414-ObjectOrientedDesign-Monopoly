package com.cs414.monopoly.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.groups.Board;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;


public class TestGameState extends TestGame {

  private GameState game = GameState.getInstance();
  private String path = "assets/board_original/players/";
  private ArrayList<Player> players = new ArrayList<>();

  @Before public void setUp(){
    Player p0 = new Player(path+"boat.png","chris", Color.CYAN, 0);
    Player p1 = new Player(path+"car.png","ian", Color.GREEN, 1500);
    Player p2 = new Player(path+"dog.png","brandon", Color.BROWN, 1500);
    players.add(p0);
    players.add(p1);
    players.add(p2);
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
  public void testGameSetup() {
    game.setStage(Mockito.mock(Stage.class));
    game.setBoard(new Board());
    game.addPlayers(players);
    game.startGame(100);
    assertNotNull(game.getCurrentPlayer());
  }


}