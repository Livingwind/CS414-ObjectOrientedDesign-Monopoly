package com.cs414.monopoly.ui.dialog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.ui.MonopolySkin;
import com.cs414.monopoly.ui.trade.TradeTable;

public class TradeDialog extends BlankDialog {
  private Player currentPlayer;
  private Player otherPlayer;
  private TradeTable currentTable;
  private TradeTable otherTable;

  /**
   * Used for first time creation
   * @param currentPlayer the player initiating the trade
   * @param otherPlayer the player being traded with
   */
  public TradeDialog(Player currentPlayer, Player otherPlayer){
    super(currentPlayer.name + " Trading With " + otherPlayer.name + " ");
    this.currentPlayer = currentPlayer;
    this.otherPlayer = otherPlayer;
    addCloseButton();

    currentTable = new TradeTable(currentPlayer, true);
    float sizeCurrent = currentTable.getWidth();
    otherTable = new TradeTable(otherPlayer, false);
    float sizeOther = otherTable.getWidth();

    if(sizeCurrent > sizeOther){
      otherTable.setWidth(currentTable.getWidth());
    } else {
      currentTable.setWidth(otherTable.getWidth());
    }
    populate();
  }

  /**
   * Used to restore table after calling new TradeDialogError
   * @param currentPlayer the player initiating the trade
   * @param otherPlayer the player being traded with
   * @param currentTable currentPlayer's clicked buttons
   * @param otherTable otherPlayer's clicked buttons
   */
  public TradeDialog(Player currentPlayer, Player otherPlayer, TradeTable currentTable, TradeTable otherTable) {
    super(currentPlayer.name + " Trading With " + otherPlayer.name + " ");
    this.currentPlayer = currentPlayer;
    this.otherPlayer = otherPlayer;
    this.currentTable = currentTable;
    this.otherTable = otherTable;
    addCloseButton();
    populate();
  }

  private ClickListener tradeListener(TradeTable current, TradeTable other, TradeDialog returnTo) {
    return new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        // Other player tries to trade more money than they have
        if (other.getOffer() > otherPlayer.getMoney()){
          new TradeDialogError(otherPlayer.name + " doesn't have that much money.",
              currentPlayer, otherPlayer, currentTable, otherTable);
          event.cancel();
          return;
        }
        // Current player tries to trade more money than they have
        if (current.getOffer() > currentPlayer.getMoney()){
          new TradeDialogError(currentPlayer.name + " doesn't have that much money.",
              currentPlayer, otherPlayer, currentTable, otherTable);
          event.cancel();
          return;
        }

        // Trade properties: currentPlayer -> otherPlayer
        tradeProperties(currentPlayer, otherPlayer, current);
        // Trade properties: otherPlayer -> currentPlayer
        tradeProperties(otherPlayer, currentPlayer, other);

        tradeMoney(current, other);

        currentPlayer.hud.update();
        otherPlayer.hud.update();
      }
    };
  }

  /**
   * Trades properties between two players
   * @param oldOwner the old owner
   * @param newOwner the new owner
   * @param oldTT contains the properties to be traded
]   */
  private void tradeProperties(Player oldOwner, Player newOwner, TradeTable oldTT){
    // Trade properties: otherPlayer -> currentPlayer
    if(!oldTT.getTradedProperties().isEmpty()){
      System.out.println(otherPlayer.name + " traded these properties to " + currentPlayer.name);
    }
    for (Property p : oldTT.getTradedProperties()){
      System.out.println("\t" + p.name);
      p.ownedBy = newOwner;
      oldOwner.properties.remove(p);
      newOwner.properties.add(p);
    }
  }

  /**
   * Trades money between two players
   * @param current currentPlayer's TradeTable
   * @param other otherPlayer's TradeTable
   */
  private void tradeMoney(TradeTable current, TradeTable other) {
    currentPlayer.modifyMoney(other.getOffer());
    currentPlayer.modifyMoney(-current.getOffer());
    otherPlayer.modifyMoney(current.getOffer());
    otherPlayer.modifyMoney(-other.getOffer());
  }

  /**
   * Adds the TradeTables to the TradeDialog
   */
  private void populate(){
    Label invisCol = new Label("    ", new MonopolySkin());

    getContentTable().add(currentTable).align(Align.bottom);
    getContentTable().add(invisCol);
    getContentTable().add(otherTable).align(Align.bottom);
    getContentTable().row();

    Button tradeButton = new TextButton("TRADE", new MonopolySkin());
    tradeButton.setColor(Color.RED);
    tradeButton.addListener(tradeListener(currentTable, otherTable, this));
    button(tradeButton);

    show(state.getStage());
    setSize(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
    setPosition(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f, Align.center);
  }
}
