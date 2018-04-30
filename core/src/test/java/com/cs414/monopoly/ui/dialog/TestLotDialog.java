package com.cs414.monopoly.ui.dialog;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.entities.LotProperty;
import com.cs414.monopoly.ui.DialogContext;
import org.junit.Before;
import org.junit.Test;

import javax.swing.event.ChangeEvent;

public class TestLotDialog extends TestGame {

  private LotDialog lotDialog;
  private LotProperty lotProperty;

  @Before
  public void setUp() {
    lotProperty = new LotProperty("assets/board_original/%s/01.png", config.get(1));
    lotProperty.ownedBy = testPlayer1;
  }

  @Test
  public void testClickedDialog(){
    lotDialog = new LotDialog(lotProperty, DialogContext.CLICK);
  }

  @Test
  public void testLandedDialog(){
    lotDialog = new LotDialog(lotProperty, DialogContext.LAND);
  }

}
