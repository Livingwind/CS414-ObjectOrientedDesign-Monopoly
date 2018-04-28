package com.cs414.monopoly.ui.trade;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.ui.MonopolySkin;

import java.util.ArrayList;

public class TradePropertyButton extends TextButton {
  private Label propertyLabel;
  private boolean pressed = false;
  public Property property;
  private ArrayList<Property> selectedProperties;

  public TradePropertyButton(Property property, Label propertyLabel, ArrayList<Property> selectedProperties) {
    super(property.name, new MonopolySkin());
    this.property = property;
    this.propertyLabel = propertyLabel;
    this.selectedProperties = selectedProperties;
    initToggle();
  }

  public TradePropertyButton(Label propertyLabel) {
    super(propertyLabel.getText().toString(), new MonopolySkin());
    setColor(Color.SCARLET);
  }

  private void toggleColor() {
    Color color = (pressed)? Color.DARK_GRAY : propertyLabel.getColor();
    setColor(color);
  }

  private void toggleLabel(){
    pressed = !pressed;
    if (!pressed) {
      propertyLabel.setVisible(false);
      selectedProperties.remove(property);
    }
    else {
      propertyLabel.setVisible(true);
      selectedProperties.add(property);
    }
  }

  private ChangeListener toggleListener = new ChangeListener() {
    @Override
    public void changed(ChangeListener.ChangeEvent event, Actor actor) {
      toggleLabel();
      toggleColor();
    }
  };

  private void initToggle() {
    setColor(propertyLabel.getColor());
    addListener(toggleListener);
  }
}
