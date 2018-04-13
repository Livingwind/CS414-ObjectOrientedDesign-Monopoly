package com.cs414.monopoly.game;

import com.badlogic.gdx.Gdx;
import com.cs414.monopoly.entities.Player;

import java.util.Random;

import static com.cs414.monopoly.game.Helpers.rollDice;

public class PreRollState extends TurnState {
  private static Random rng = new Random();

  private int doubles = 1;
  public void doAction(RollContext ctx) {
    int[] dice = rollDice();
    if(dice[0] == dice[1]) {
      doubles++;
      if(doubles == 3) {
        // Send to jail
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
