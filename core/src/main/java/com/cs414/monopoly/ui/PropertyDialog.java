package com.cs414.monopoly.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Scaling;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.game.GameState;

public class PropertyDialog extends Dialog{
  protected final GameState state = GameState.getInstance();
  protected final Property property;

  public PropertyDialog(Property property){
    super(property.name, new MonopolySkin());
    this.property = property;

    // image Table
    Table imageTable = new Table();
    Image image = new Image(property.texture);
    image.setScaling(Scaling.fit);
    imageTable.add(image).width(300).height(300);

    getContentTable().padTop(20);
    getContentTable().add(imageTable);
    getContentTable().row(); // put text under image
    String owner = "Property " + ((property.ownedBy == null) ? "not owned" :
                                  "owned by: " + property.ownedBy.name);
    text(owner);
    fill();
    button("close window", true);
    show(state.getStage());
  }

  public void fill(){};
}
