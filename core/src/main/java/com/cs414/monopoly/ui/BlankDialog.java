package com.cs414.monopoly.ui;


import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.cs414.monopoly.game.GameState;

public abstract class BlankDialog extends Dialog {
  private final Buttons buttons = new Buttons();
  private final Listeners listeners = new Listeners();
  protected final GameState state = GameState.getInstance();

  BlankDialog(String title) {
    super(titleFormat(title), new MonopolySkin());
  }

  void addCloseButton() {
    Button closeButton = buttons.getCloseButton();
    closeButton.addListener(listeners.getCloseListener(this));
    getTitleTable().add(closeButton);
  }

  void addOKButton() {
    Button confirm = new TextButton("OK", getSkin());
    confirm.padLeft(20).padRight(20);
    button(confirm);
  }

  static String titleFormat(String string){
    StringBuilder formattedTitle = new StringBuilder();
    for (String word : string.split(" ")) {
      formattedTitle.append(word.substring(0,1).toUpperCase())
          .append(word.substring(1))
          .append(" ");
    }
    return formattedTitle.toString();
  }

}
