package com.cs414.monopoly.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.TestGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestUtilityProperty extends TestGame {
  private UtilityProperty utilityProperty1;
  private UtilityProperty utilityProperty2;
  private UtilityProperty utilityProperty3;
  private Player testPlayer;

  @Before
  public void setUp() {
    JsonValue root = new JsonReader().parse(Gdx.files.internal("assets/board_original/config.json"));
    utilityProperty1 = new UtilityProperty("assets/board_original/%s/12.png",root.get(12));
    utilityProperty2 = new UtilityProperty("assets/board_original/%s/12.png",root.get(12));
    utilityProperty3 = new UtilityProperty("assets/board_original/%s/28.png",root.get(28));
    testPlayer = new Player("assets/board_original/players/car.png","test", Color.GREEN, 1500);
  }

  @Test
  public void testEquals(){
    assertTrue(utilityProperty1.equals(utilityProperty2));
    assertFalse(utilityProperty1.equals(utilityProperty3));
  }

  @Test
  public void testHashCode() {
    assertTrue(utilityProperty1.hashCode() == utilityProperty1.name.hashCode());
  }

  @Test
  public void testGetRent() {
    testPlayer.purchaseProperty(utilityProperty1);
    assertEquals(12, utilityProperty1.getRent());
    testPlayer.purchaseProperty(utilityProperty3);
    assertEquals(30, utilityProperty1.getRent());
  }

}
