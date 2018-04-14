package com.cs414.monopoly.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.cs414.monopoly.entities.Property;

public class LotDialog extends PropertyDialog {
  public LotDialog(Property property) {
    super(property, true);
  }

  @Override
  public void fill() {
    String owner = "Property " + ((property.ownedBy == null) ? "not owned" :
        "owned by: " + property.ownedBy.name);
    text(owner);

    // buttons
    Button buyHouse = new TextButton("Buy House", getSkin());
    buyHouse.padRight(10).padLeft(10);
    buyHouse.setColor(Color.GREEN);
    buyHouse.addListener(new ChangeListener(){
      @Override
      public void changed(ChangeEvent event, Actor actor){
        System.out.println("Bought a house!");
        event.cancel();
      }
    });
    Button sellHouse = new TextButton("Sell House", getSkin());
    sellHouse.padRight(10).padLeft(10);
    sellHouse.setColor(Color.RED);
    sellHouse.addListener(new ChangeListener(){
      @Override
      public void changed(ChangeEvent event, Actor actor){
        System.out.println("Sold a house!");
        event.cancel();
      }
    });

    getContentTable().row(); // put text under image
    button(buyHouse);
    button(sellHouse);
  }
}
