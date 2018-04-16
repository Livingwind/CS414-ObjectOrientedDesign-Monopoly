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

public class TestToJail extends TestGame {

  private ToJail toJail1;
  private ToJail toJail2;
  private Player testPlayer1;
  private Player testPlayer2;

  @Before
  public void setUp() {
    JsonValue root = new JsonReader().parse(Gdx.files.internal("assets/board_original/config.json"));
    toJail1 = new ToJail("assets/board_original/%s/00.png", 0, root.get(0));
    toJail2 = new ToJail("assets/board_original/%s/00.png", 0, root.get(0));
    testPlayer1 = new Player("assets/board_original/players/car.png","test1", Color.GREEN, 1500);
    testPlayer2 = new Player("assets/board_original/players/boat.png","test2", Color.RED, 1500);
    toJail1.setPlayer(testPlayer1);
    toJail1.setPlayer(testPlayer2);
  }

  @Test
  public void testPlacePlayer(){
    assertEquals(testPlayer1.space, toJail1);
    toJail2.placePlayer(testPlayer1);
    assertEquals(testPlayer1.space, toJail2);
  }

  @Test
  public void testSetPlayer() {
    assertEquals(toJail1, testPlayer1.space);
    toJail2.setPlayer(testPlayer1);
    assertEquals(toJail2, testPlayer1.space);
  }

  @Test
  public void testOnLand() {

  }
}
