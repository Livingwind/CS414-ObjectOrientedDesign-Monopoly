package com.cs414.monopoly.ui.trade;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.entities.LotProperty;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.ui.MonopolySkin;
import org.junit.Test;

import java.util.ArrayList;

public class TestTradePropertyButton extends TestGame {

  public TradePropertyButton tradePropertyButton1;
  public TradePropertyButton tradePropertyButton2;
  public LotProperty lotProperty;

  @Test
  public void setUp() {
    lotProperty = new LotProperty("assets/board_original/%s/01.png", config.get(1));
    tradePropertyButton1 = new TradePropertyButton(lotProperty, new Label("Hello", new MonopolySkin()), new ArrayList<Property>(), new NetWorthLabel());
    tradePropertyButton2 = new TradePropertyButton(new Label("Hello", new MonopolySkin()));
  }

}
