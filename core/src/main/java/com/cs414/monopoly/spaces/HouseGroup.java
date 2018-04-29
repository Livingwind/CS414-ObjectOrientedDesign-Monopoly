package com.cs414.monopoly.spaces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.LotProperty;
import com.cs414.monopoly.ui.MonopolySkin;

public class HouseGroup extends Table {
  private Sprite houseTexture;
  private Sprite hotelTexture;
  private LotProperty property;

  public HouseGroup(LotProperty property) {
    this.property = property;
    houseTexture = new Sprite(new Texture("assets/board_original/house.png"));
    houseTexture.flip(false, true);
    hotelTexture = new Sprite(new Texture("assets/board_original/hotel.png"));
    hotelTexture.flip(false, true);
  }

  /**
   * Sets the width and height.
   *
   * @param width Width
   * @param height Height
   */
  @Override
  public void setSize(float width, float height) {
    super.setSize(width, height);
  }


  public void update() {
    clear();
    int houses = property.numHouses;
    if(houses < 5) {
      align(Align.left);
      defaults().width(getWidth()/4);

      for(int i = 0; i < houses; i++) {
        Image house = new Image(houseTexture);
        add(house);
      }
    } else {
      align(Align.center);
      defaults().width(getWidth()/2);
      Image hotel = new Image(hotelTexture);
      add(hotel);
    }
  }
}
