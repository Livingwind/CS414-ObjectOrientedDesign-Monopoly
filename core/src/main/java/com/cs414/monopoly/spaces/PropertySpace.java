package com.cs414.monopoly.spaces;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.ui.DialogueContext;
import com.cs414.monopoly.ui.LotDialog;

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
        sprite.setColor(Color.WHITE);
      }
    });
  }

  private void hover() {
    if(property.ownedBy != null) {
      sprite.setColor(property.ownedBy.color);
    } else {
      Color color = new Color(232/255f, 232/255f, 232/255f, 1);
      sprite.setColor(color);
    }
  }

  @Override
  public void onLand(Player player) {
    new LotDialog(property, DialogueContext.LAND);
  }
}
