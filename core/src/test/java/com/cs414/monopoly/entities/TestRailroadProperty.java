package com.cs414.monopoly.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.TestGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRailroadProperty extends TestGame {
  private RailroadProperty railroadProperty1;
  private RailroadProperty railroadProperty2;

  @Before
  public void setUp() {
    railroadProperty1 = new RailroadProperty("assets/board_original/%s/05.png",config.get(5));
    railroadProperty2 = new RailroadProperty("assets/board_original/%s/15.png",config.get(15));
  }

  @Test
  public void testEquals(){
    assertEquals(railroadProperty1, railroadProperty1);
    assertNotEquals(railroadProperty1, railroadProperty2);
  }

  @Test
  public void testHashCode() {
    assertEquals(railroadProperty1.hashCode(), railroadProperty1.name.hashCode());
  }

  @Test
  public void testGetRent() {
    testPlayer1.addProperty(railroadProperty1);
    railroadProperty1.ownedBy = testPlayer1;
    testPlayer1.numRoads++;
    assertEquals(25, railroadProperty1.getRent());

    testPlayer1.addProperty(railroadProperty2);
    railroadProperty2.ownedBy = testPlayer1;
    testPlayer1.numRoads++;
    assertEquals(50, railroadProperty1.getRent());
  }
}
