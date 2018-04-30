package com.cs414.monopoly.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.spaces.Lot;

import java.util.HashMap;

public class LotProperty extends Property {
  private static HashMap<Color, Integer> colorMap = new HashMap<>();
  public final Color color;
  public int houseCost;
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

  public static int getColorGroupSize(Color color){
    return colorMap.get(color);
  }

  public static void resetColorMap() {
    colorMap.clear();
  }

  /**
   * Increases the number of houses on this lot and increases the rent by one
   */
  public void buyHouse() {
    GameState state = GameState.getInstance();
    if (numHouses < 4) {
      state.numHouses--;
      System.out.println("Bought a house for " + name + "!");
    } else if (numHouses == 4) {
      state.numHotels--;
      state.numHouses += 4;
      System.out.println("Bought a hotel for " + name + "!");
    } else {
      System.out.println("WARNING: Unable to buy house.");
      return;
    }
    numHouses++;
    rentIndex++;
    state.getCurrentPlayer().modifyMoney(-houseCost);
    ownedBy.hud.update();
    ((Lot)GameState.getInstance().getBoard().spaces.get(location)).updateProperties();
  }

  /**
   * Decreases the number of houses on this lot and decreases the rent by one
   */
  public void sellHouse() {
    GameState state = GameState.getInstance();
    if(numHouses == 5) {
      state.numHotels++;
      numHouses = 0;
      rentIndex = 0;
      System.out.println("Sold a hotel for " + name + "!");
    } else if (numHouses > 0) {
      state.numHouses++;
      numHouses--;
      rentIndex--;
      System.out.println("Sold a house for " + name + "!");
    } else {
      System.out.println("WARNING: Unable to sell house.");
      return;
    }
    state.getCurrentPlayer().modifyMoney((int)(0.5 * houseCost));
    ownedBy.hud.update();
    ((Lot)GameState.getInstance().getBoard().spaces.get(location)).updateProperties();
  }

  public int getHousingValue(){
    return numHouses < 5 ? numHouses * houseCost : houseCost;
  }

  @Override
  public int getRent() {
    if(ownedBy.hasMonopoly(color) && rentIndex == 0)
      return rents[rentIndex] * 2;
    else
      return rents[rentIndex];
  }
}
