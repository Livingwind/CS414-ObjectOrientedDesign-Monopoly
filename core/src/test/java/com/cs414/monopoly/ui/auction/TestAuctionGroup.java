package com.cs414.monopoly.ui.auction;

import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.entities.LotProperty;
import org.junit.Test;

public class TestAuctionGroup extends TestGame {

  private AuctionGroup auctionGroup;
  private LotProperty lotProperty;

  @Test
  public void setUp() {
    lotProperty = new LotProperty("assets/board_original/%s/01.png", config.get(1));
    auctionGroup = new AuctionGroup(lotProperty);
  }

}
