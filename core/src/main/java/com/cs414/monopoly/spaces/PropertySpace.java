package com.cs414.monopoly.spaces;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.ui.dialog.DialogContext;
import com.cs414.monopoly.ui.dialog.LotDialog;

public abstract class PropertySpace extends AbstractSpace {
  Property property;

  PropertySpace(String filename, int location, JsonValue props) {
    super(filename, location, props, Size.STANDARD);
    addListener(new ClickListener() {
      @Override
      public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        hover();
      }

      @Override
      public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        setSpriteColor(Color.WHITE);
      }
    });
  }

  private void hover() {
    if(property.ownedBy != null) {
      setSpriteColor(property.ownedBy.color);
    } else {
      Color color = new Color(232/255f, 232/255f, 232/255f, 1);
      setSpriteColor(color);
    }
  }

  @Override
  public void onLand(Player player) {
    new LotDialog(property, DialogContext.LAND);
  }
}
