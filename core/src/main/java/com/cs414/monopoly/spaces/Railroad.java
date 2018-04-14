package com.cs414.monopoly.spaces;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.RailroadProperty;
import com.cs414.monopoly.ui.PropertyDialog;

class Railroad extends PropertySpace {
  Railroad(final String filename, int location, JsonValue props) {
    super(filename, location, props);
    property = new RailroadProperty(filename, props);

    addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        new PropertyDialog(property);
      }
    });
  }
}
