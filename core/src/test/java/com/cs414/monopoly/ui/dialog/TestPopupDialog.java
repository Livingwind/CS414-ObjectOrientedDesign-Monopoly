package com.cs414.monopoly.ui.dialog;

import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.cs414.monopoly.TestGame;
import org.junit.Test;

public class TestPopupDialog extends TestGame {

  private PopupDialog popupDialog1;
  private PopupDialog popupDialog2;

  @Test
  public void testPopUp() {
    popupDialog1 = new PopupDialog("Hello");
    popupDialog2 = new PopupDialog(new ClickListener(), "world");
  }

}
