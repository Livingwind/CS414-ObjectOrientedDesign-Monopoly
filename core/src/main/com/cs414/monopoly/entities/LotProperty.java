package main.com.cs414.monopoly.entities;

import com.badlogic.gdx.utils.JsonValue;

public class LotProperty extends Property {
  public int houseCost;
  private int numHouses;
  private int rentIndex;

  public LotProperty(String filename, JsonValue props) {
    super(filename, props);
    houseCost = props.get("houseCost").asInt();
  }

  /**
   * Increases the number of houses on this lot and increases the rent by one
   */
  public void buyHouse() {
    if(numHouses < 5) {
      numHouses++;
      rentIndex++;
    }
  }

  /**
   * Decreases the number of houses on this lot and decreases the rent by one
   */
  public void sellHouse() {
    if(numHouses > 0) {
      numHouses--;
      rentIndex--;
    }
  }

  @Override
  public int getRent() {
    return rents[rentIndex];
  }
}
