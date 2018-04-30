package com.cs414.monopoly.ui.setup;

import com.cs414.monopoly.TestGame;
import org.junit.Before;
import org.junit.Test;

public class TestSetupDialog extends TestGame {

  public SetupDialog setupDialog;

  @Before
  public void setUp() {
    setupDialog = new SetupDialog();
  }

  @Test
  public void testUpdateNumPlayers() {
    setupDialog.updateNumPlayers();
  }

}
