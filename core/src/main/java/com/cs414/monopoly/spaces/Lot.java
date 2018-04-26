package com.cs414.monopoly.spaces;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.LotProperty;
import com.cs414.monopoly.ui.dialog.DialogContext;
import com.cs414.monopoly.ui.dialog.LotDialog;

class Lot extends PropertySpace {
  Lot(final String filename, int location, JsonValue props) {
    super(filename, location, props);
    property = new LotProperty(filename, props);

    addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        new LotDialog(property, DialogContext.CLICK);
      }
    });
  }
}
