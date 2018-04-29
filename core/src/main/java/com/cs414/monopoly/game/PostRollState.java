package com.cs414.monopoly.game;

public class PostRollState extends TurnState {
  @Override
  public void doAction(RollContext ctx) {
    global.nextTurn();
    if(!GameState.getInstance().getCurrentPlayer().inJail) {
      ctx.currentState = new PreRollState();
    } else {
      ctx.currentState = new InJail();
    }
    ctx.rdg.toggleDice(false);
  }
}
