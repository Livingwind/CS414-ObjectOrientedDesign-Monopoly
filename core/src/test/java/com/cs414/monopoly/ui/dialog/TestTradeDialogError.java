package com.cs414.monopoly.ui.dialog;

import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.ui.trade.TradeTable;
import org.junit.Test;

public class TestTradeDialogError extends TestGame {

  private TradeDialogError tradeDialogError;


  @Test
  public void setUp() {
    tradeDialogError = new TradeDialogError("Test", testPlayer1, testPlayer2, new TradeTable(testPlayer1, true), new TradeTable(testPlayer2, true));
  }

}
