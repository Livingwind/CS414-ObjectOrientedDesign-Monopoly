package com.cs414.monopoly.spaces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TestTax extends TestGame {

  private Tax tax1;
  private Tax tax2;

  @Before
  public void setUp() {
    tax1 = new Tax("assets/board_original/%s/04.png", 4, config.get(4), TaxType.INCOME);
    tax2 = new Tax("assets/board_original/%s/38.png", 38, config.get(38), TaxType.LUXURY);
    tax1.setPlayer(testPlayer1);
    tax2.setPlayer(testPlayer2);
  }

  @Test
  public void testPlacePlayer(){
    assertEquals(testPlayer1.space, tax1);
    tax2.placePlayer(testPlayer1);
    assertEquals(testPlayer1.space, tax2);
  }

  @Test
  public void testSetPlayer() {
    assertEquals(tax1, testPlayer1.space);
    tax2.setPlayer(testPlayer1);
    assertEquals(tax2, testPlayer1.space);
  }

  @Test
  public void testOnLand() {

  }
}
