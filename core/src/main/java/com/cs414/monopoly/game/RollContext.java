package com.cs414.monopoly.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.cs414.monopoly.ui.RollDiceGroup;

public class RollContext {
  public TurnState currentState;
  protected RollDiceGroup rdg = new RollDiceGroup();


  public RollContext() {
    currentState = new PreRollState();
    Stage stage = GameState.getInstance().getStage();

    rdg.setSize(150, 150);
    rdg.setPosition(stage.getWidth()-rdg.getWidth(), 0);
    stage.addActor(rdg);
  }

  public void doAction() {
    currentState.doAction(this);
  }

}
