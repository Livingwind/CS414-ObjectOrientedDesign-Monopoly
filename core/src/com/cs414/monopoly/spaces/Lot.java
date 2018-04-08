package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;

import java.util.ArrayList;

public class Lot extends Space {
  int rent;
  ArrayList<Integer> rentValues;
  int buildingCost;
  int numberHouses;

  public Lot(String filename, JsonValue props) {
    super(filename, Size.STANDARD, SpaceFactory.SpaceType.LOT);
    setName(props.get("name").asString());
  }
}
