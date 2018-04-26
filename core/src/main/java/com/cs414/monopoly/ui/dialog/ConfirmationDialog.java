package com.cs414.monopoly.ui.dialog;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.cs414.monopoly.entities.Property;

public class ConfirmationDialog extends BlankDialog {
  public Property property;

  ConfirmationDialog(ClickListener yesAction, ClickListener noAction, String message, Property property) {
    super("Confirm");
    this.property = property;
    confirmationButtons(yesAction, noAction, message);
    show(state.getStage());
  }

  private void confirmationButtons(ClickListener yesAction, ClickListener noAction, final String message) {
    String question = "Are you sure you want to " + message + "?";
    Label outMessage = new Label(question, getSkin());
    text(outMessage);

    Button yesButton = new TextButton("Yes", getSkin());
      yesButton.padRight(10).padLeft(10);
      yesButton.setColor(Color.GREEN);
      yesButton.addListener(yesAction);
    Button noButton = new TextButton("No", getSkin());
      noButton.padRight(10).padLeft(10);
      noButton.setColor(Color.RED);
      noButton.addListener(noAction);
    button(yesButton);
    button(noButton);
  }
 }
