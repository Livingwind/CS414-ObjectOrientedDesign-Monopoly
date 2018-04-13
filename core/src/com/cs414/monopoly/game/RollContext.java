package com.cs414.monopoly.game;

public class RollContext {
  public TurnState currentState;

  public RollContext() {
    currentState = new PreRollState();
  }

  public void doAction() {
    currentState.doAction(this);
  }

}
