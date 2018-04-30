package com.cs414.monopoly.ui.trade;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.cs414.monopoly.ui.MonopolySkin;

public class NetWorthLabel extends Label {
  private int netWorth = 0;

  public NetWorthLabel(){
    super("Total Value: $", new MonopolySkin());
    setColor(Color.GREEN);
  }

  public void updateText(int value){
    netWorth += value;
    setText("Total Value: $" + netWorth);
  }
}

