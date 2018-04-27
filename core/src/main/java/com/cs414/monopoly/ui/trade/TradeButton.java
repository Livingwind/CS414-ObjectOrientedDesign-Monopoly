package com.cs414.monopoly.ui.trade;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.cs414.monopoly.ui.MonopolySkin;

public class TradeButton extends TextButton {
  private Label propertyLabel;
  private Table tradeTable;
  private boolean pressed = false;

  public TradeButton(String propertyName, Label propertyLabel, Table tradeTable) {
    super(propertyName, new MonopolySkin());
    this.propertyLabel = propertyLabel;
    this.tradeTable = tradeTable;
    initToggle();
  }

  private void toggleColor() {
    Color color = (pressed)? Color.DARK_GRAY : propertyLabel.getColor();
    setColor(color);
  }

  private void toggleLabel(){
    pressed = !pressed;
    if (!pressed) {
      propertyLabel.setVisible(false);
    }
    else {
      propertyLabel.setVisible(true);
    }
  }

  private ChangeListener toggleListener = new ChangeListener() {
    @Override
    public void changed(ChangeListener.ChangeEvent event, Actor actor) {
      toggleLabel();
      toggleColor();
    }
  };

  private void initToggle() {
    setColor(propertyLabel.getColor());
    addListener(toggleListener);
  }
}
