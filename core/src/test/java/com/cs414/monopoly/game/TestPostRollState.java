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

import static org.junit.Assert.assertTrue;

public class TestPostRollState extends TestGame {

  private GameState game = GameState.getInstance();
  private String path = "assets/board_original/players/";
  private ArrayList<Player> players = new ArrayList<Player>();
  PostRollState postRollState;
  Player p0;
  Player p1;
  Player p2;

  @Before
  public void setUp() {
    p0 = new Player(path+"boat.png","chris", Color.CYAN, 0);
    p1 = new Player(path+"car.png","ian", Color.GREEN, 1500);
    p2 = new Player(path+"dog.png","brandon", Color.BROWN, 1500);
    players.add(p0);
    players.add(p1);
    players.add(p2);
    postRollState = new PostRollState();
    game.setStage(Mockito.mock(Stage.class));
    game.setBoard(new Board());
    game.addPlayers(players);
    game.startGame(100);
  }

  @Test
  public void testDoAction() {
    assertTrue(game.getCurrentPlayer() == p0);
    postRollState.doAction(new RollContext());
    assertTrue(game.getCurrentPlayer() == p1);
  }

}
