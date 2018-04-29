package com.cs414.monopoly.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.cs414.monopoly.entities.Property;

public class Buttons {
  private Skin skin = new MonopolySkin();

  // Generic Buttons____________________________________________________________________________
  public Button textButton(String text) {
    return new TextButton(text, skin);
  }

  public Button textButton(String text, Color color){
    TextButton btn = new TextButton(text, skin);
    btn.setColor(color);
    return btn;
  }

  public Button textButton(String text, Color color, int padRight, int padLeft){
    TextButton btn = new TextButton(text, skin);
    btn.setColor(color);
    btn.padRight(padRight);
    btn.padLeft(padLeft);
    return btn;
  }

  // UI Buttons___________________________________________________________________________________
  // todo: this button doesn't do anything
  public Button settingsButton(){
    Texture settingsIcon = new Texture(Gdx.files.internal("assets/settings_icon.png"));
    Drawable drawable = new TextureRegionDrawable(new TextureRegion(settingsIcon));
    ImageButton btn = new ImageButton(drawable);
    btn.setSize(Gdx.graphics.getWidth()/48f, Gdx.graphics.getWidth()/48f);
    return btn;
  }

  // Property Buttons_____________________________________________________________________________
  public Button buyButton(Property property){
    // todo: find a bitmap font that supports 🏠
    Button btn = new TextButton("Buy \uD83C\uDFE0", skin);
    btn.setColor(Color.GREEN);
    return btn;
  }

  public Button sellButton(Property property){
    // todo: find a bitmap font that supports 🏠
    Button btn = new TextButton("Sell \uD83C\uDFE0", skin);
    btn.setColor(Color.RED);
    return btn;
  }
}
