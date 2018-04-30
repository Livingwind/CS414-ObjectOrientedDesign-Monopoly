package com.cs414.monopoly.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.game.GameState;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestUtilityProperty extends TestGame {
  private UtilityProperty utilityProperty1;
  private UtilityProperty utilityProperty2;

  @Before
  public void setUp() {
    utilityProperty1 = new UtilityProperty("assets/board_original/%s/12.png",config.get(12));
    utilityProperty2 = new UtilityProperty("assets/board_original/%s/28.png",config.get(28));
  }

  @Test
  public void testEquals(){
    assertEquals(utilityProperty1, utilityProperty1);
    assertNotEquals(utilityProperty1, utilityProperty2);
  }

  @Test
  public void testHashCode() {
    assertEquals(utilityProperty1.hashCode(), utilityProperty1.name.hashCode());
  }

  @Test
  public void testGetRent() {
    state.lastRoll = 12;
    testPlayer1.purchaseProperty(utilityProperty1);
    assertEquals(48, utilityProperty1.getRent());
    testPlayer1.purchaseProperty(utilityProperty2);
    assertEquals(120, utilityProperty1.getRent());
  }

}
