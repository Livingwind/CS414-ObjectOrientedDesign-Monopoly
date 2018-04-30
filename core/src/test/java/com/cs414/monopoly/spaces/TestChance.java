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

  @Before
  public void setUp() {
    chance1 = new Chance("assets/board_original/%s/07.png", 7, config.get(7));
    chance2 = new Chance("assets/board_original/%s/07.png", 7, config.get(7));
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
