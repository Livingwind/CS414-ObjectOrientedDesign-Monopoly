package com.cs414.monopoly.spaces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Scaling;
import com.cs414.monopoly.entities.RailroadProperty;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.groups.PropertyDialog;

class Railroad extends PropertySpace {
  Railroad(final String filename, int location, JsonValue props) {
    super(filename, location, props);
    property = new RailroadProperty(filename, props);

    addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        PropertyDialog dialog = new PropertyDialog(property, filename);
      }
    });
  }
}
