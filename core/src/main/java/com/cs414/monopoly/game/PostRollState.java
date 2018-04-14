package com.cs414.monopoly.game;

public class PostRollState extends TurnState {
  @Override
  public void doAction(RollContext ctx) {
    global.nextTurn();
    ctx.rdg.toggleDice(false);
    ctx.currentState = new PreRollState();
  }
}
