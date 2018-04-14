package com.cs414.monopoly.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Scaling;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.game.GameState;

public class PropertyDialog extends Dialog{
  protected final GameState state = GameState.getInstance();
  protected final Property property;

  public PropertyDialog(Property property) {
    this(property, true);
  }

  public PropertyDialog(Property property, boolean closable){
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

    fill();
    if(closable) {
      Button exit = new TextButton("X", getSkin());
      exit.padRight(15).padLeft(15);
      exit.setColor(Color.RED);
      exit.addListener(new ChangeListener(){
        @Override
        public void changed(ChangeEvent event, Actor actor){
          remove();
        }
      });
      getTitleTable().add(exit);
    }

    show(state.getStage());
  }

  public void fill(){};
}
