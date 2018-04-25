package com.cs414.monopoly.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.cs414.monopoly.spaces.TaxType;

public class TaxDialog extends BlankDialog {

  private final TaxType type;
  private final String name;

  public TaxDialog(String name, TaxType type) {
    super(name);
    this.name = name;
    this.type = type;
    drawTaxDialog();
    show(state.getStage());
  }

  private void drawTaxDialog() {
    getTitleLabel().setText("You landed on " + titleFormat(name));
    if(type == TaxType.INCOME) {
      getContentTable().row().padTop(15);
      text("PAY %10");
      getContentTable().row();
      text("OR");
      getContentTable().row();
      text("$200");
    } else if(type ==TaxType.LUXURY) {
      getContentTable().row().padTop(15);
      text("PAY $75");
    }
    drawPaymentButtons();
  }

  private void drawPaymentButtons(){
    final int flatCost;
    if(type == TaxType.INCOME) {
      flatCost = 200;
      Button payPercent = new TextButton("Pay 10%", getSkin());
      payPercent.padRight(10).padLeft(10);
      payPercent.addListener(new ChangeListener(){
        @Override
        public void changed(ChangeEvent event, Actor actor){
          state.getCurrentPlayer().modifyMoney((int)Math.round(-0.1 * state.getCurrentPlayer().getNetWorth()));
          remove();
        }
      });
      button(payPercent);
    } else {
      flatCost = 75;
    }
    Button payFlat = new TextButton("Pay $" + flatCost, getSkin());
    payFlat.padRight(10).padLeft(10);
    payFlat.addListener(new ChangeListener(){
      @Override
      public void changed(ChangeEvent event, Actor actor){
        state.getCurrentPlayer().modifyMoney(-flatCost);
        remove();
      }
    });
    button(payFlat);
  }
}
