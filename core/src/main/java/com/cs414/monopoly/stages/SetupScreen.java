package com.cs414.monopoly.stages;

import com.cs414.monopoly.ui.setup.SetupDialog;

public class SetupScreen extends AbstractScreen {
  /**
   * Builds the stage according to the instructions delegated
   * by the subclass.
   */
  @Override
  public void build() {
    addActor(new SetupDialog());

  }
}
