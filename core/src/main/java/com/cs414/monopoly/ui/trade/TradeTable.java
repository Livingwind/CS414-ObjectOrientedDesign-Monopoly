package com.cs414.monopoly.ui.trade;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.ui.MonopolySkin;
import com.cs414.monopoly.ui.dialog.TradeDialog;
import com.cs414.monopoly.ui.setup.SetupDialog;

public class TradeTable extends TradePropertyTable {
  private Label offer = new Label("Offer: ", new MonopolySkin());
  private final TextField moneyOffer = new TextField("", new MonopolySkin());

  public TradeTable(Player player, boolean swap){
    super(player, swap);
    moneyOffer.setTextFieldListener((TextField textField, char c) -> ((TradeDialog) getParent()).setOffer(Integer.parseInt(Character.toString(c))));

    add(offer);
  }
}
