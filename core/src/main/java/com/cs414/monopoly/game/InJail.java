package com.cs414.monopoly.game;

import com.cs414.monopoly.entities.Player;

import static com.cs414.monopoly.game.Helpers.rollDice;

public class InJail extends TurnState {
  @Override
  public void doAction(RollContext ctx) {
    Player current = global.getCurrentPlayer();
    int[] dice = rollDice();
    ctx.rdg.toggleDice(true);
    ctx.rdg.updateDice(dice[0], dice[1]);
    if(dice[0] == dice[1]) {
      current.inJail = 0;
      global.getBoard().movePlayer(current, dice[0]+dice[1]);
    }

    ctx.currentState = new PostRollState();
  }
}
