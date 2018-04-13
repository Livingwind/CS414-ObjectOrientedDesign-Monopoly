package com.cs414.monopoly.game;

import com.badlogic.gdx.Gdx;

import java.util.Random;

public abstract class Helpers {
  private static Random rng = new Random();
  public static int[] rollDice(){
    int dice1 = rng.nextInt(6) + 1;
    int dice2 = rng.nextInt(6) + 1;
    Gdx.app.debug("PlayerRoll", String.format("%s rolled a %d and a %d \n",
        GameState.getInstance().getCurrentPlayer().name, dice1, dice2));
    return new int[]{dice1, dice2};
  }
}
