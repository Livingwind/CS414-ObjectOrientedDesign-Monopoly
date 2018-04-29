package com.cs414.monopoly.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PopupDialog extends BlankDialog {

  public PopupDialog(ClickListener listener, String message) {
    super("Confirm");
    confirmationButtons(listener, message);
    getContentTable().pad(20, 20, 20, 20);
    show(state.getStage());
  }
  public PopupDialog(String message) {
    super(" ");
    popUp(message);
    getContentTable().pad(20, 20, 20, 20);
    show(state.getStage());
  }

  private void confirmationButtons(ClickListener listener, final String message) {
    String question = "Are you sure you want to " + message + "?";
    Label outMessage = new Label(question, getSkin());
    text(outMessage);
    Button yesButton = new TextButton("Yes", getSkin());
    yesButton.padRight(10).padLeft(10);
    yesButton.setColor(Color.GREEN);
    yesButton.addListener(listener);

    Button noButton = new TextButton("No", getSkin());
    noButton.padRight(10).padLeft(10);
    noButton.setColor(Color.RED);
    noButton.addListener(new ChangeListener() {
      @Override
      public void changed (ChangeEvent event, Actor actor){
      }
    });
    button(yesButton);
    button(noButton);
  }

  private void popUp(String message){
    Label outMessage = new Label(message, getSkin());
    text(outMessage).center();
    addOKButton();
  }
 }
