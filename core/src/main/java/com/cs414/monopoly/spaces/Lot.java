package com.cs414.monopoly.spaces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Scaling;
import com.cs414.monopoly.entities.LotProperty;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.groups.MonopolySkin;

class Lot extends PropertySpace {
  Lot(final String filename, int location, JsonValue props) {
    super(filename, location, props);
    property = new LotProperty(filename, props);

    addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        GameState state = GameState.getInstance();
        Skin skin = new MonopolySkin();

        // texture
        String lotNumber = filename.substring(filename.length() - 6, filename.length() - 4);
        String lotDeed = "assets/board_original/deeds/" + lotNumber + ".png";
        Texture texture = new Texture(lotDeed);

        // image Table
        Table imageTable = new Table();
        Image image = new Image(texture);
          image.setScaling(Scaling.fit);
          imageTable.add(image).width(300).height(300);

        // buttons
        Button buyHouse = new TextButton("Buy House", skin);
          buyHouse.padRight(10).padLeft(10);
          buyHouse.setColor(Color.GREEN);
          buyHouse.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent event, Actor actor){
              System.out.println("Bought a house!");
              event.cancel();
            }
          });
        Button sellHouse = new TextButton("Sell House", skin);
          sellHouse.padRight(10).padLeft(10);
          sellHouse.setColor(Color.RED);
          sellHouse.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent event, Actor actor){
              System.out.println("Sold a house!");
              event.cancel();
            }
          });

        // dialog
        Dialog lotDialog = new Dialog(property.name, skin){
          @Override
          public void draw(Batch batch, float parentAlpha) {
            setClip(true);
            super.draw(batch, parentAlpha);
            setClip(false);
          }
        };
        lotDialog.getContentTable().padTop(20);
        lotDialog.getContentTable().add(imageTable);
        lotDialog.getContentTable().row(); // put text under image
        String owner = "Property " + ((property.ownedBy == null) ? "not owned" :
            "owned by: " + property.ownedBy.name);
        lotDialog.text(owner);
        lotDialog.button(buyHouse);
        lotDialog.button(sellHouse);
        lotDialog.button("close", true);
        lotDialog.show(state.getStage());
      }
    });
  }
}
