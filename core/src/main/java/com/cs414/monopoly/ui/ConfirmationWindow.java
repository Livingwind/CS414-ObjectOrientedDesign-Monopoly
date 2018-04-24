package com.cs414.monopoly.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ConfirmationWindow extends BlankDialog {

  ConfirmationWindow(ClickListener listener, String message) {
    super("Confirm");
    confirmationButtons(listener, message);
    show(state.getStage());
  }

  void confirmationButtons(ClickListener listener, final String message) {
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
 }
