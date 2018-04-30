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
import static org.junit.Assert.assertNotEquals;

public class TestToJail extends TestGame {

  private ToJail toJail1;
  private ToJail toJail2;

  @Before
  public void setUp() {
    toJail1 = new ToJail("assets/board_original/%s/00.png", 0, config.get(0));
    toJail2 = new ToJail("assets/board_original/%s/00.png", 0, config.get(0));
    toJail1.setPlayer(testPlayer1);
    toJail1.setPlayer(testPlayer2);
  }

  @Test
  public void testPlacePlayer(){
    assertEquals(testPlayer1.space, toJail1);
    toJail2.placePlayer(testPlayer1);
    assertNotEquals(testPlayer1.space, toJail2);
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
