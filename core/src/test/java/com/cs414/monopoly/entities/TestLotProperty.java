package com.cs414.monopoly.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.TestGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestLotProperty extends TestGame {
  private LotProperty lotProperty1;
  private LotProperty lotProperty2;
  private LotProperty lotProperty3;

  @Before
  public void setUp() {
    JsonValue root = new JsonReader().parse(Gdx.files.internal("assets/board_original/config.json"));
    lotProperty1 = new LotProperty("assets/board_original/%s/09.png",root.get(9));
    lotProperty2 = new LotProperty("assets/board_original/%s/09.png",root.get(9));
    lotProperty3 = new LotProperty("assets/board_original/%s/01.png",root.get(1));
  }

  @Test
  public void testEquals(){
    assertEquals(lotProperty1, lotProperty2);
    assertNotEquals(lotProperty1, lotProperty3);
  }

  @Test
  public void testHashCode() {
    assertEquals(lotProperty1.hashCode(), lotProperty1.name.hashCode());
  }

  @Test
  public void testRentsAndHouses() {
    assertEquals(lotProperty1.getRent(), 8);
    lotProperty1.buyHouse();
    assertEquals(lotProperty1.getRent(), 40);
    lotProperty1.sellHouse();
    assertEquals(lotProperty1.getRent(), 8);
  }


}
