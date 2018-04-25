package com.cs414.monopoly.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.game.GameState;

import java.util.HashMap;

public class LotProperty extends Property {
  private static HashMap<Color, Integer> colorMap = new HashMap<>();
  public final Color color;
  private int houseCost;
  public int numHouses;
  private int rentIndex;

  public LotProperty(String filename, JsonValue props) {
    super(filename, props);
    houseCost = props.get("houseCost").asInt();
    color = nameToColor(props.getString("color"));
    colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
  }

  private Color nameToColor(String name) {
    switch (name) {
      case "brown":
        return Color.BROWN;
      case "cyan":
        return Color.CYAN;
      case "magenta":
        return Color.MAGENTA;
      case "orange":
        return Color.ORANGE;
      case "red":
        return Color.RED;
      case "yellow":
        return Color.YELLOW;
      case "green":
        return Color.GREEN;
      case "navy":
        return Color.NAVY;
    }
    return new Color();
  }

  public int getColorNumber(LotProperty property) {
    return colorMap.get(property.color);
  }

  /**
   * Increases the number of houses on this lot and increases the rent by one
   */
  public void buyHouse() {
    if(numHouses < 5) {
      System.out.println("Bought a house for " + name + "!");
      numHouses++;
      rentIndex++;
      ownedBy.hud.update();
    }
  }

  /**
   * Decreases the number of houses on this lot and decreases the rent by one
   */
  public void sellHouse() {
    if(numHouses > 0) {
      System.out.println("Sold a house for " + name + "!");
      numHouses--;
      rentIndex--;
      ownedBy.hud.update();
    }
  }

  @Override
  public int getRent() {
    return rents[rentIndex];
  }
}
