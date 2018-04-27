package com.cs414.monopoly.ui.dialog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.ui.Listeners;
import com.cs414.monopoly.ui.MonopolySkin;
import com.cs414.monopoly.ui.trade.TradePropertyTable;

public class TradeDialog extends BlankDialog {
  private Listeners listeners = new Listeners();
  private int offer = 0;

  public TradeDialog(Player currentPlayer, Player otherPlayer){
    super(" ");
    addCloseButton();
    setSize(Gdx.graphics.getWidth()/8f, Gdx.graphics.getHeight()/8f);
    getTitleLabel().setText(currentPlayer.name + " Trading With " + otherPlayer.name + " ");

    TradePropertyTable currentTable = new TradePropertyTable(currentPlayer, true);
    TradePropertyTable otherTable = new TradePropertyTable(otherPlayer, false);
    getContentTable().add(currentTable);
    getContentTable().add(otherTable);
    getContentTable().row();

    Button tradeButton = new TextButton("TRADE", new MonopolySkin());
      tradeButton.setColor(Color.RED);
      tradeButton.addListener(listeners.textListener("Traded!"));
    button(tradeButton);
    show(GameState.getInstance().getStage());
  }

  public void setOffer(int offer){
    this.offer = offer;
  }


}
