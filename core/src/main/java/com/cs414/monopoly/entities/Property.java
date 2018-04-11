package com.cs414.monopoly.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.JsonValue;

public abstract class Property {
  public final Texture texture;
  public final String name;
  public final int value;
  final int[] rents;

  public boolean mortgaged;

  public Player ownedBy;

  Property(String filename, JsonValue props) {
    texture = new Texture(Gdx.files.internal(filename));

    name = props.get("name").asString();
    value = props.get("value").asInt();
    rents = props.get("rent").asIntArray();
  }

  public abstract int getRent();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Property property = (Property) o;
    return name.equals(property.name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }
}
