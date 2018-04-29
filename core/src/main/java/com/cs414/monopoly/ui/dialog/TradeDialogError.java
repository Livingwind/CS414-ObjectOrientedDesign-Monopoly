package com.cs414.monopoly.ui.dialog;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.ui.MonopolySkin;
import com.cs414.monopoly.ui.trade.TradeTable;

public class TradeDialogError extends BlankDialog {

  public TradeDialogError(String message,
                          Player currentPlayer, Player otherPlayer,
                          TradeTable currentTable, TradeTable otherTable){
    super(message);
    Button OKButton = new TextButton("OK", new MonopolySkin());
    OKButton.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        new TradeDialog(currentPlayer, otherPlayer, currentTable, otherTable);
      }
    });
    button(OKButton);
    show(GameState.getInstance().getStage());
  }
}
