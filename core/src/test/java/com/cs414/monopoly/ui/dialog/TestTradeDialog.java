package com.cs414.monopoly.ui.dialog;

import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.ui.trade.TradeTable;
import org.junit.Test;

public class TestTradeDialog extends TestGame {

  private TradeDialog tradeDialog1;
  private TradeDialog tradeDialog2;

  @Test
  public void setUp() {
    tradeDialog1 = new TradeDialog(testPlayer1, testPlayer2);
    tradeDialog2 = new TradeDialog(testPlayer1, testPlayer2, new TradeTable(testPlayer1, true), new TradeTable(testPlayer2, true));
  }

}
