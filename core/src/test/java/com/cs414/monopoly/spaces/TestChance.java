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

public class TestChance extends TestGame {

  private Chance chance1;
  private Chance chance2;
  private Player testPlayer1;
  private Player testPlayer2;

  @Before
  public void setUp() {
    JsonValue root = new JsonReader().parse(Gdx.files.internal("assets/board_original/config.json"));
    chance1 = new Chance("assets/board_original/%s/07.png", 7, root.get(7));
    chance2 = new Chance("assets/board_original/%s/07.png", 7, root.get(7));
    testPlayer1 = new Player("assets/board_original/players/car.png","test1", Color.GREEN, 1500);
    testPlayer2 = new Player("assets/board_original/players/boat.png","test2", Color.RED, 1500);
    chance1.setPlayer(testPlayer1);
    chance1.setPlayer(testPlayer2);
  }

  @Test
  public void testPlacePlayer(){
    assertEquals(testPlayer1.space, chance1);
    chance2.placePlayer(testPlayer1);
    assertEquals(testPlayer1.space, chance2);
  }

  @Test
  public void testSetPlayer() {
    assertEquals(chance1, testPlayer1.space);
    chance2.setPlayer(testPlayer1);
    assertEquals(chance2, testPlayer1.space);
  }

  @Test
  public void testOnLand() {

  }
}
