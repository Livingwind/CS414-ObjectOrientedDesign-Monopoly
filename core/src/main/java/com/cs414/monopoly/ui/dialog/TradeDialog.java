package com.cs414.monopoly.ui.dialog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.ui.MonopolySkin;
import com.cs414.monopoly.ui.trade.TradeTable;

public class TradeDialog extends BlankDialog {
  private Player currentPlayer;
  private Player otherPlayer;

  private ClickListener tradeListener(TradeTable current, TradeTable other) {
    return new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        if(!current.getTradedProperties().isEmpty()) {
          System.out.println(currentPlayer.name + " traded these properties to " + otherPlayer.name + ":");
        }
        for (Property p : current.getTradedProperties()){
          System.out.println("\t" + p.name);
          p.ownedBy = otherPlayer;
          currentPlayer.properties.remove(p);
          otherPlayer.properties.add(p);
        }
        if(!other.getTradedProperties().isEmpty()){
          System.out.println(otherPlayer.name + " traded these properties to " + currentPlayer.name);
        }
        for (Property p : other.getTradedProperties()){
          System.out.println("\t" + p.name);
          p.ownedBy = currentPlayer;
          otherPlayer.properties.remove(p);
          currentPlayer.properties.add(p);
        }
        currentPlayer.hud.update();
        otherPlayer.hud.update();
      }
    };
  }

  public TradeDialog(Player currentPlayer, Player otherPlayer){
    super(currentPlayer.name + " Trading With " + otherPlayer.name + " ");
    this.currentPlayer = currentPlayer;
    this.otherPlayer = otherPlayer;
    addCloseButton();

    TradeTable currentTable = new TradeTable(currentPlayer, true);
    float sizeCurrent = currentTable.getWidth();
    TradeTable otherTable = new TradeTable(otherPlayer, false);
    float sizeOther = otherTable.getWidth();

    if(sizeCurrent > sizeOther){
      otherTable.setWidth(currentTable.getWidth());
    } else {
      currentTable.setWidth(otherTable.getWidth());
    }
    getContentTable().add(currentTable).align(Align.bottom);
    getContentTable().add(otherTable).align(Align.bottom);
    getContentTable().row();

    Button tradeButton = new TextButton("TRADE", new MonopolySkin());
      tradeButton.setColor(Color.RED);
    tradeButton.addListener(tradeListener(currentTable, otherTable));
    button(tradeButton);

    show(state.getStage());
    setSize(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
    setPosition(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f, Align.center);
  }
}
