package com.cs414.monopoly.game;

public abstract class TurnState {
  GameState global = GameState.getInstance();
  public abstract void doAction(RollContext ctx);
}
