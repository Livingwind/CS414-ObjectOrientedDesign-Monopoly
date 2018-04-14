package com.cs414.monopoly.game;

import com.cs414.monopoly.entities.Player;

import static com.cs414.monopoly.game.Helpers.rollDice;

public class PreRollState extends TurnState {

  private int doubles = 1;
  public void doAction(RollContext ctx) {
    int[] dice = rollDice();
    ctx.rdg.toggleDice(true);
    ctx.rdg.updateDice(dice[0], dice[1]);
    System.out.println(dice[0] + " " + dice[1]);
    if(dice[0] == dice[1]) {
      doubles++;
      if(doubles == 3) {
        // todo: send to jail
        ctx.currentState = new PostRollState();
      }
    }

    Player current = global.getCurrentPlayer();
    global.getBoard().movePlayer(current, dice[0] + dice[1]);

    if(dice[0] != dice[1]) {
      ctx.currentState = new PostRollState();
    }
  }
}
