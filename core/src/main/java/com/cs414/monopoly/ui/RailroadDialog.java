package com.cs414.monopoly.ui;
import com.cs414.monopoly.entities.Property;

public class RailroadDialog extends PropertyDialog {

  public RailroadDialog(Property property, DialogueContext context) {
    super(property, context);
    show(state.getStage());
  }
}
