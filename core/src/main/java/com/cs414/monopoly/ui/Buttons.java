package com.cs414.monopoly.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.cs414.monopoly.entities.Property;

public class Buttons {

  // Generic Buttons____________________________________________________________________________
  public Button getTextButton(String text) {
    return new TextButton(text, new MonopolySkin());
  }

  public Button getCloseButton(){
    Button exit = new TextButton("X", new MonopolySkin());
    exit.padRight(15).padLeft(15);
    exit.setColor(Color.RED);
    return exit;
  }

  public Button getGreyButton(String text){
    Button btn = new TextButton(text, new MonopolySkin());
    btn.setColor(Color.LIGHT_GRAY);
    return btn;
  }

  // UI Buttons___________________________________________________________________________________
  // todo: this button doesn't do anything
  public Button getSettingsButton(){
    Texture settingsIcon = new Texture(Gdx.files.internal("assets/settings_icon.png"));
    Drawable drawable = new TextureRegionDrawable(new TextureRegion(settingsIcon));
    ImageButton btn = new ImageButton(drawable);
    btn.setSize(Gdx.graphics.getWidth()/32f, Gdx.graphics.getWidth()/32f);
    return btn;
  }

  // Property Buttons_____________________________________________________________________________

  public Button getBuyButton(Property property){
    // todo: find a bitmap font that supports 🏠
    Button btn = new TextButton("Buy \uD83C\uDFE0", new MonopolySkin());
    btn.setColor(Color.GREEN);
    return btn;
  }

  public Button getSellButton(Property property){
    // todo: find a bitmap font that supports 🏠
    Button btn = new TextButton("Sell \uD83C\uDFE0", new MonopolySkin());
    btn.setColor(Color.RED);
    return btn;
  }
}
