package com.cs414.monopoly.ui.dialog;

import com.cs414.monopoly.entities.Property;

public class RailroadDialog extends PropertyDialog {

  public RailroadDialog(Property property, DialogContext context) {
    super(property, context);
    show(state.getStage());
  }
}
