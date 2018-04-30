package com.cs414.monopoly.spaces;

import com.cs414.monopoly.TestGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLot extends TestGame {

  private Lot lot;

  @Before
  public void setUp() {
    lot = new Lot("assets/board_original/%s/01.png", 1, config.get(1));
  }

  @Test
  public void testPlacePlayer(){
    lot.placePlayer(testPlayer1);
    assertEquals(testPlayer1.space, lot);
  }

  @Test
  public void testSetPlayer() {
    lot.setPlayer(testPlayer1);
    assertEquals(lot, testPlayer1.space);
  }

  @Test
  public void testOnLand() {

  }
}
