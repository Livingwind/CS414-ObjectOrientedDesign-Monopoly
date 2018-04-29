package com.cs414.monopoly.ui.dialog;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.cs414.monopoly.ui.MonopolySkin;

public class DebugDialog extends BlankDialog {

  public DebugDialog() {
    super("Console commands");
    text("> move playerName int"
        + "\n    Moves the player forwards/backwards on the board."
        + "\n\n> set playerName int"
        + "\n    Moves the player to an exact location."
        + "\n\n> money playerName int"
        + "\n    Adds/Removes money from the player."
    );
    Button btn = new TextButton("OK", new MonopolySkin());
    button(btn);
    show(state.getStage());
  }
}
