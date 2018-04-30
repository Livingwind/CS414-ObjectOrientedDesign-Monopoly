package com.cs414.monopoly.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.JsonValue;

public abstract class Property {
  public final Image image;
  public final String name;
  public final int value;

  final int[] rents;
  public boolean mortgaged;
  public Player ownedBy;
  public int location;

  Property(String formatPath, JsonValue props) {
    String path = String.format(formatPath, "deeds");
    image = new Image(new Texture(Gdx.files.internal(path)));
    name = props.get("name").asString();
    value = props.get("value").asInt();
    rents = props.get("rent").asIntArray();
    location = props.get("position").asInt();
  }

  public abstract int getRent();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Property property = (Property) o;
    return name.equals(property.name);
  }

  public void toggleMortgage() {
    int mortgageValue = value/2;
    int buyBack = (int) Math.round(mortgageValue * 1.10);
    int buyback = (int) Math.round(mortgageValue * 1.10);
    if(mortgaged && ownedBy.getMoney() >= buyback){
      ownedBy.modifyMoney(-buyBack);
    }else{
      ownedBy.modifyMoney(mortgageValue);
    }
    mortgaged = !mortgaged;
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }
}
