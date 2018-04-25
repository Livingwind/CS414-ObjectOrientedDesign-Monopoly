package com.cs414.monopoly.spaces;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.UtilityProperty;
import com.cs414.monopoly.ui.DialogueContext;
import com.cs414.monopoly.ui.UtilityDialog;

class Utility extends PropertySpace {
  Utility(final String filename, int location, JsonValue props) {
    super(filename, location, props);
    property = new UtilityProperty(filename, props);

    addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        new UtilityDialog(property, DialogueContext.CLICK);
      }
    });
  }
}
