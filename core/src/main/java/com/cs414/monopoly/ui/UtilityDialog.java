package com.cs414.monopoly.ui;

import com.cs414.monopoly.entities.Property;

public class UtilityDialog extends PropertyDialog {

  public UtilityDialog(Property property, DialogueContext context) {
    super(property, context);
    show(state.getStage());
  }
}
