package com.cs414.monopoly.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MonopolySkin extends Skin {

  public MonopolySkin(){
    super(
        Gdx.files.internal("assets/uiskin.json"),
        new TextureAtlas(Gdx.files.internal("assets/uiskin.atlas"))
    );
  }
}
