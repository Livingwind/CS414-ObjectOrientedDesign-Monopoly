package com.cs414.monopoly.game;

import com.cs414.monopoly.entities.Player;

import static com.cs414.monopoly.game.Helpers.rollDice;

public class PreRollState extends TurnState {

  private int doubles = 0;
  public void doAction(RollContext ctx) {
    Player current = global.getCurrentPlayer();
    int[] dice = rollDice();
    ctx.rdg.toggleDice(true);
    ctx.rdg.updateDice(dice[0], dice[1]);
    System.out.println(dice[0] + " " + dice[1]);
    if(dice[0] == dice[1]) {
      doubles++;
      if(doubles == 3) {
        global.getBoard().sendToJail(current);
        ctx.currentState = new PostRollState();
        return;
      }
    }

    global.lastRoll = dice[0] + dice[1];
    global.getBoard().movePlayer(current, dice[0] + dice[1]);

    if(dice[0] != dice[1]) {
      ctx.currentState = new PostRollState();
    }
  }
}
