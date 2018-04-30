package com.cs414.monopoly.ui.dialog;

import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.entities.UtilityProperty;
import com.cs414.monopoly.ui.DialogContext;
import org.junit.Before;
import org.junit.Test;

public class TestUtilityDialog extends TestGame {

  private UtilityDialog utilityDialog;
  private UtilityProperty utilityProperty;

  @Before
  public void setUp() {
    utilityProperty = new UtilityProperty("assets/board_original/%s/12.png", config.get(12));
    utilityProperty.ownedBy = testPlayer1;
  }

  @Test
  public void testClickedDialog(){
    utilityDialog = new UtilityDialog(utilityProperty, DialogContext.CLICK);
  }

  @Test
  public void testLandedDialog(){
    utilityDialog = new UtilityDialog(utilityProperty, DialogContext.LAND);
  }

}
