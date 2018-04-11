package com.cs414.monopoly.entities;

import com.badlogic.gdx.graphics.Color;

import java.util.ArrayList;

public class Player {

  public final String name;
  public final Color color;
  public boolean inJail;

  private int money;
  private int netWorth;
  private GetOutOfJailFree getOutOfJail = GetOutOfJailFree.NONE;

  public int location;
  public int numRoads;
  public int numUtilities;

  public ArrayList<Property> properties = new ArrayList<Property>();

  public Player(String name, Color color, int startingMoney){
    this.name = name;
    this.color = color;
    this.money = startingMoney;
    updateNetWorth(money);
  }

  /**
   * Modifies the player's money by the given amount using addition.
   * @param amount amount of money to add or remove from the player.
   */
  public void modifyMoney(int amount){
    this.money += amount;
    updateNetWorth(amount);
  }

  public void addProperty(Property property) {
     properties.add(property);
     updateNetWorth(property.value);
  }

  public boolean removeProperty(Property property) {
    if(!properties.remove(property)) {
      return false;
    }
    updateNetWorth(-1 * property.value);
    return true;
  }

  public GetOutOfJailFree getGetOutOfJail() {
    return getOutOfJail;
  }

  /**
   * Adds the given card to the player. If the player has both cards, the internal of GetOutOfJail
   *  keeps the value at BOTH.
   * @param card type of card to give to the player
   */
  public void addGetOutOfJail(GetOutOfJailFree card) {
    getOutOfJail = getOutOfJail.addCard(card);
  }

  /**
   * Removes the card from the player. Will keep the value at NONE or the owned if called with a card the player
   *  doesn't have the specified card.
   * @param card type of card to remove from the player
   */
  public void removeGetOutOfJail(GetOutOfJailFree card) {
    getOutOfJail = getOutOfJail.removeCard(card);
  }

  /**
   * Called each time the player earns money or property.
   * @param amount amount to modify their net worth by.
   */
  private void updateNetWorth(int amount){
    netWorth += amount;
  }
}
