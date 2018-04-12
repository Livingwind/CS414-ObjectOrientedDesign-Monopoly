package com.cs414.monopoly.spaces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Scaling;
import com.cs414.monopoly.entities.UtilityProperty;
import com.cs414.monopoly.game.GameState;

class Utility extends PropertySpace {
  Utility(final String filename, JsonValue props) {
    super(filename, props);
    property = new UtilityProperty(filename, props);

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
