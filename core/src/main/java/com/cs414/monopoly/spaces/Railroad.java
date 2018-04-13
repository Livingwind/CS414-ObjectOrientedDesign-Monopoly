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

class Railroad extends PropertySpace {
  Railroad(final String filename, int location, JsonValue props) {
    super(filename, location, props);
    property = new RailroadProperty(filename, props);

    addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        GameState state = GameState.getInstance();
        Skin skin = new Skin(
            new FileHandle("assets/uiskin.json"),
            new TextureAtlas(Gdx.files.internal("assets/uiskin.atlas"))
        );

        // texture
        String lotNumber = filename.substring(filename.length() - 6, filename.length() - 4);
        String lotDeed = "assets/board_original/deeds/" + lotNumber + ".png";
        Texture texture = new Texture(lotDeed);

        // image Table
        Table imageTable = new Table();
        Image image = new Image(texture);
        image.setScaling(Scaling.fit);
        imageTable.add(image).width(300).height(300);

        // dialog
        Dialog lotDialog = new Dialog(property.name, skin);
        lotDialog.getContentTable().padTop(20);
        lotDialog.getContentTable().add(imageTable);
        // put text under image
        lotDialog.getContentTable().row();
        lotDialog.button("close window", true);
        lotDialog.show(state.getStage());
      }
    });
  }
}
