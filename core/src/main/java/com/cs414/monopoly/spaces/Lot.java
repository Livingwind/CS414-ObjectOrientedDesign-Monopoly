package com.cs414.monopoly.spaces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.LotProperty;
import com.cs414.monopoly.ui.DialogContext;
import com.cs414.monopoly.ui.dialog.LotDialog;

public class Lot extends PropertySpace {
  private HouseGroup houses;

  public void updateProperties() {
    houses.update();
  }

  Lot(final String filename, int location, JsonValue props) {
    super(filename, location, props);
    LotProperty lotProperty = new LotProperty(filename, props);
    property = lotProperty;
    houses = new HouseGroup(lotProperty);

    addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        new LotDialog(property, DialogContext.CLICK);
      }
    });

    houses.setSize(getWidth(), getHeight()/4.5f);
    addActor(houses);
    updateProperties();
  }
}
