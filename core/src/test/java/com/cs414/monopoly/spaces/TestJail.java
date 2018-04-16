package com.cs414.monopoly.spaces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.entities.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestJail extends TestGame {

  private Jail jail1;
  private Jail jail2;
  private Player testPlayer1;
  private Player testPlayer2;

  @Before
  public void setUp() {
    JsonValue root = new JsonReader().parse(Gdx.files.internal("assets/board_original/config.json"));
    jail1 = new Jail("assets/board_original/%s/10.png", 10, root.get(10));
    jail2 = new Jail("assets/board_original/%s/10.png", 10, root.get(10));
    testPlayer1 = new Player("assets/board_original/players/car.png","test1", Color.GREEN, 1500);
    testPlayer2 = new Player("assets/board_original/players/boat.png","test2", Color.RED, 1500);
    jail1.setPlayer(testPlayer1);
    jail1.setPlayer(testPlayer2);
  }

  @Test
  public void testPlacePlayer(){
    assertEquals(testPlayer1.space, jail1);
    jail2.placePlayer(testPlayer1);
    assertEquals(testPlayer1.space, jail2);
  }

  @Test
  public void testSetPlayer() {
    assertEquals(jail1, testPlayer1.space);
    jail2.setPlayer(testPlayer1);
    assertEquals(jail2, testPlayer1.space);
  }

  @Test
  public void testOnLand() {

  }
}
