package com.cs414.monopoly.ui.trade;

import com.cs414.monopoly.TestGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTradeTable extends TestGame {

  private TradeTable tradeTable;

  @Before
  public void setUp() {
    tradeTable = new TradeTable(testPlayer2, true);
  }

  @Test
  public void testGetOffer() {
    assertEquals(0, tradeTable.getOffer());
  }

}
