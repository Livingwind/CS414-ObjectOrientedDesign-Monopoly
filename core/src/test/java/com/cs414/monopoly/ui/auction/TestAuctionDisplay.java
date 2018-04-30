package com.cs414.monopoly.ui.auction;

import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.entities.LotProperty;
import org.junit.Before;
import org.junit.Test;

public class TestAuctionDisplay extends TestGame {

  private AuctionDisplay auctionDisplay;
  private LotProperty lotProperty;

  @Before
  public void setUp() {
    lotProperty = new LotProperty("assets/board_original/%s/01.png", config.get(1));
    auctionDisplay = new AuctionDisplay(lotProperty);
  }

  @Test
  public void testAuctionWindow() {
    auctionDisplay.auctionWindow();
  }

}
