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
  private Player testPlayer1;
  private Player testPlayer2;

  @Before
  public void setUp() {
    JsonValue root = new JsonReader().parse(Gdx.files.internal("assets/board_original/config.json"));
    tax1 = new Tax("assets/board_original/%s/04.png", 4, root.get(4), TaxType.INCOME);
    tax2 = new Tax("assets/board_original/%s/38.png", 38, root.get(38), TaxType.LUXURY);
    testPlayer1 = new Player("assets/board_original/players/car.png","test1", Color.GREEN, 1500);
    testPlayer2 = new Player("assets/board_original/players/boat.png","test2", Color.RED, 1500);
    tax1.setPlayer(testPlayer1);
    tax2.setPlayer(testPlayer2);
    GameState.getInstance().setStage(Mockito.mock(Stage.class));
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
