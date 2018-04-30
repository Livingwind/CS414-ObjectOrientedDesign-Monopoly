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

public class TestRailroad extends TestGame {

  private Railroad railroad;

  @Before
  public void setUp() {
    railroad = new Railroad("assets/board_original/%s/05.png", 5, config.get(5));
  }

  @Test
  public void testPlacePlayer(){
    railroad.placePlayer(testPlayer1);
    assertEquals(testPlayer1.space, railroad);
  }

  @Test
  public void testSetPlayer() {
    railroad.setPlayer(testPlayer1);
    assertEquals(railroad, testPlayer1.space);
  }

  @Test
  public void testOnLand() {

  }
}
