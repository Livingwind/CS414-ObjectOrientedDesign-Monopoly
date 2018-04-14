package com.cs414.monopoly.spaces;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Scaling;
import com.cs414.monopoly.entities.LotProperty;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.ui.LotDialog;
import com.cs414.monopoly.ui.MonopolySkin;
import com.cs414.monopoly.ui.PropertyDialog;
import com.cs414.monopoly.ui.PropertyLandDialog;

class Lot extends PropertySpace {
  Lot(final String filename, int location, JsonValue props) {
    super(filename, location, props);
    property = new LotProperty(filename, props);

    addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        new LotDialog(property);
      }
    });
  }
}
