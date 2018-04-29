package com.cs414.monopoly.ui.dice;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.cs414.monopoly.ui.RollDiceButton;

public class RollDiceGroup extends Group {
  private Die die1 = new Die();
  private Die die2 = new Die();
  private RollDiceButton roll = new RollDiceButton();

  public RollDiceGroup() {
    addActor(die1);
    addActor(die2);
    addActor(roll);
    toggleDice(false);
  }

  public void updateDice(int d1, int d2) {
    die1.changeFace(d1-1);
    die2.changeFace(d2-1);
  }

  public void toggleDice(boolean status) {
    die1.setVisible(status);
    die2.setVisible(status);
  }

  @Override
  protected void sizeChanged() {
    roll.setBounds(0, 0, getWidth(), getHeight()/2);
    die1.setBounds(0, roll.getHeight(), getWidth()/2, getHeight()/2);
    die2.setBounds(die1.getWidth(), roll.getHeight(), getWidth()/2, getHeight()/2);
    super.sizeChanged();
  }
}
