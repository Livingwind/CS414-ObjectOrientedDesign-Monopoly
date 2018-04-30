package com.cs414.monopoly.ui.dialog;

import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.entities.RailroadProperty;
import com.cs414.monopoly.ui.DialogContext;
import org.junit.Before;
import org.junit.Test;

public class TestRailroadDialog extends TestGame {

  private RailroadDialog railroadDialog;
  private RailroadProperty railroadProperty;

  @Before
  public void setUp() {
    railroadProperty = new RailroadProperty("assets/board_original/%s/05.png", config.get(5));
    railroadProperty.ownedBy = testPlayer1;
  }

  @Test
  public void testClickedDialog(){
    railroadDialog = new RailroadDialog(railroadProperty, DialogContext.CLICK);
  }

  @Test
  public void testLandedDialog(){
    railroadDialog = new RailroadDialog(railroadProperty, DialogContext.LAND);
  }

}
