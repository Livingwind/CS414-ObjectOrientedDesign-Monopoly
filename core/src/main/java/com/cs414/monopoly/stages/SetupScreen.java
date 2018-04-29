package com.cs414.monopoly.stages;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.cs414.monopoly.ui.setup.SetupDialog;

public class SetupScreen extends AbstractScreen {
  SetupScreen() {
    super();
  }
  SetupScreen(Batch batch) {
    super(batch);
  }
  /**
   * Builds the stage according to the instructions delegated
   * by the subclass.
   */
  @Override
  public void build() {
    addActor(new SetupDialog());

  }
}
