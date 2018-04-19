package com.cs414.monopoly.ui;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.cs414.monopoly.game.GameState;

public abstract class BlankDialog extends Dialog {

  protected final GameState state = GameState.getInstance();

  BlankDialog(String title) {
    super(titleFormat(title), new MonopolySkin());
  }

  void addCloseButton() {
    Button exit = new TextButton("X", getSkin());
    exit.padRight(15).padLeft(15);
    exit.setColor(Color.RED);
    exit.addListener(new ChangeListener(){
      @Override
      public void changed(ChangeEvent event, Actor actor){
        remove();
      }
    });
    getTitleTable().add(exit);
  }

  void addOKButton() {
    Button confirm = new TextButton("Ok", getSkin());
    confirm.padLeft(20).padRight(20);
    button(confirm);
  }


  static String titleFormat(String string){
    String formattedTitle = "";
    for (String word : string.split(" ")) {
      formattedTitle += word.substring(0,1).toUpperCase() + word.substring(1, word.length()) + " ";
    }
    return formattedTitle;
  }

}
