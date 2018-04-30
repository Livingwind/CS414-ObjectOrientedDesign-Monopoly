package com.cs414.monopoly.game;

public class PostRollState extends TurnState {
  @Override
  public void doAction(RollContext ctx) {
    global.nextTurn();
    if(global.getCurrentPlayer().inJail < 1) {
      ctx.currentState = new PreRollState();
    } else {
      ctx.currentState = new InJail();
    }
    ctx.rdg.toggleDice(false);
  }
}
