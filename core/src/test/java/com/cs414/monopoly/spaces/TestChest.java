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

public class TestChest extends TestGame {

  private Chest chest1;
  private Chest chest2;
  private Player testPlayer1;
  private Player testPlayer2;

  @Before
  public void setUp() {
    JsonValue root = new JsonReader().parse(Gdx.files.internal("assets/board_original/config.json"));
    chest1 = new Chest("assets/board_original/%s/02.png", 2, root.get(2));
    chest2 = new Chest("assets/board_original/%s/02.png", 2, root.get(2));
    testPlayer1 = new Player("assets/board_original/players/car.png","test1", Color.GREEN, 1500);
    testPlayer2 = new Player("assets/board_original/players/boat.png","test2", Color.RED, 1500);
    chest1.setPlayer(testPlayer1);
    chest1.setPlayer(testPlayer2);
  }

  @Test
  public void testPlacePlayer(){
    assertEquals(testPlayer1.space, chest1);
    chest2.placePlayer(testPlayer1);
    assertEquals(testPlayer1.space, chest2);
  }

  @Test
  public void testSetPlayer() {
    assertEquals(chest1, testPlayer1.space);
    chest2.setPlayer(testPlayer1);
    assertEquals(chest2, testPlayer1.space);
  }

  @Test
  public void testOnLand() {

  }
}
