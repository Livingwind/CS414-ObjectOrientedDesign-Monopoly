package com.cs414.monopoly.ui.dialog;

import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.ui.DialogContext;

public class UtilityDialog extends PropertyDialog {

  public UtilityDialog(Property property, DialogContext context) {
    super(property, context);
    show(state.getStage());
  }
}
