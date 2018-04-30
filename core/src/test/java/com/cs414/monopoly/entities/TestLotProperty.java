package com.cs414.monopoly.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.TestGame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestLotProperty extends TestGame {
  private LotProperty lotProperty1;
  private LotProperty lotProperty2;

  @Before
  public void setUp() {
    lotProperty1 = new LotProperty("assets/board_original/%s/01.png",config.get(1));
    lotProperty2 = new LotProperty("assets/board_original/%s/03.png",config.get(3));
  }

  @Test
  public void testEquals(){
    assertEquals(lotProperty1, lotProperty1);
    assertNotEquals(lotProperty1, lotProperty2);
  }

  @Test
  public void testHashCode() {
    assertEquals(lotProperty1.hashCode(), lotProperty1.name.hashCode());
  }

  @Test
  public void testRentsAndHouses() {
    // test base rent
    lotProperty1.ownedBy = testPlayer1;
    testPlayer1.addProperty(lotProperty1);
    assertEquals(2, lotProperty1.getRent());

    //
    lotProperty2.ownedBy = testPlayer2;
    testPlayer2.addProperty(lotProperty2);
    assertEquals(2, lotProperty1.getRent());

    testPlayer2.removeProperty(lotProperty2);
    testPlayer1.addProperty(lotProperty2);
    lotProperty2.ownedBy = testPlayer1;
    assertEquals(4, lotProperty1.getRent());

    lotProperty1.buyHouse();
    assertEquals(10, lotProperty1.getRent());

    lotProperty1.buyHouse();
    lotProperty1.buyHouse();
    lotProperty1.buyHouse();
    lotProperty1.buyHouse();
    assertEquals(250, lotProperty1.getRent());

    lotProperty1.sellHouse();
    assertEquals(4, lotProperty1.getRent());
  }

  @After
  public void tearDown() {
    LotProperty.resetColorMap();
  }


}
