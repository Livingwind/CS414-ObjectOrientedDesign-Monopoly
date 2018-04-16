package com.cs414.monopoly.spaces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.groups.Board;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestLot extends TestGame {

  private Lot lot1;
  private Lot lot2;
  private Player testPlayer1;
  private Player testPlayer2;

  @Before
  public void setUp() {
    JsonValue root = new JsonReader().parse(Gdx.files.internal("assets/board_original/config.json"));
    lot1 = new Lot("assets/board_original/%s/01.png", 1, root.get(1));
    lot2 = new Lot("assets/board_original/%s/03.png", 3, root.get(3));
    testPlayer1 = new Player("assets/board_original/players/car.png","test1", Color.GREEN, 1500);
    testPlayer2 = new Player("assets/board_original/players/boat.png","test2", Color.RED, 1500);
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(testPlayer1);
    players.add(testPlayer2);

    GameState.getInstance().setStage(Mockito.mock(Stage.class));
    GameState.getInstance().setBoard(new Board());
    GameState.getInstance().addPlayers(players);
    GameState.getInstance().startGame(1000);

  }

  @Test
  public void testPlacePlayer(){
    lot2.placePlayer(testPlayer1);
    assertEquals(testPlayer1.space, lot2);
  }

  @Test
  public void testSetPlayer() {
    lot2.setPlayer(testPlayer1);
    assertEquals(lot2, testPlayer1.space);
  }

  @Test
  public void testOnLand() {

  }
}
