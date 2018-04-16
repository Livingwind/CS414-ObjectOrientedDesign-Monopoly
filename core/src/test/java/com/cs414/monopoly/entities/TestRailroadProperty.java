package com.cs414.monopoly.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestRailroadProperty extends TestGame {
  private RailroadProperty railroadProperty1;
  private RailroadProperty railroadProperty2;
  private RailroadProperty railroadProperty3;
  private Player testPlayer;

  @Before
  public void setUp() {
    JsonValue root = new JsonReader().parse(Gdx.files.internal("assets/board_original/config.json"));
    railroadProperty1 = new RailroadProperty("assets/board_original/%s/05.png",root.get(5));
    railroadProperty2 = new RailroadProperty("assets/board_original/%s/05.png",root.get(5));
    railroadProperty3 = new RailroadProperty("assets/board_original/%s/15.png",root.get(15));
    testPlayer = new Player("assets/board_original/players/car.png","test", Color.GREEN, 1500);
  }

  @Test
  public void testEquals(){
    assertTrue(railroadProperty1.equals(railroadProperty2));
    assertFalse(railroadProperty1.equals(railroadProperty3));
  }

  @Test
  public void testHashCode() {
    assertTrue(railroadProperty1.hashCode() == railroadProperty1.name.hashCode());
  }

  @Test
  public void testGetRent() {
    testPlayer.purchaseProperty(railroadProperty1);
    assertEquals(25, railroadProperty1.getRent());
    testPlayer.purchaseProperty(railroadProperty3);
    assertEquals(50, railroadProperty1.getRent());
  }
}
