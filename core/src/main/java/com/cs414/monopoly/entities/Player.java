package com.cs414.monopoly.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.spaces.AbstractSpace;
import com.cs414.monopoly.ui.playerhud.PlayerHUD;

import java.util.ArrayList;

public class Player extends Image {
  public final String name;
  public final Color color;
  public int inJail;
  public PlayerHUD hud;

  private int money;
  private GetOutOfJailFree getOutOfJail = GetOutOfJailFree.NONE;

  public AbstractSpace space;
  int numRoads;
  int numUtilities;

  public ArrayList<Property> properties = new ArrayList<>();

  public Player(String textureFile, String name, Color color, int startingMoney) {

    Sprite sprite = new Sprite(new Texture(Gdx.files.internal(textureFile)));
    setDrawable(new SpriteDrawable(sprite));
    setSize(AbstractSpace.Size.STANDARD.getWidth() / 2, AbstractSpace.Size.STANDARD.getHeight() / 4);

    this.name = name;
    this.color = color;
    this.money = startingMoney;
  }

  public void initHUD() {
    hud = new PlayerHUD(this);
    GameState.getInstance().getStage().addActor(hud);
  }

  public boolean purchaseProperty(Property property) {
    property.ownedBy = this;
    addProperty(property);
    modifyMoney(-property.value);
    System.out.println(String.format("%s bought %s for $%d.",
        name, property.name, property.value));
    if (property instanceof RailroadProperty)
      numRoads++;
    else if (property instanceof UtilityProperty)
      numUtilities++;
    return true;
  }

  /**
   * Modifies the player's money by the given amount using addition.
   *
   * @param amount amount of money to add or remove from the player.
   */
  public void modifyMoney(int amount) {
    this.money += amount;
    System.out.println(String.format("%s's money was modified by %d", name, amount));
    hud.update();
  }

  public int getMoney() {
    return money;
  }

  public int getNetWorth() {
    int netWorth = money;
    for (Property property : properties) {
      netWorth += property.mortgaged ? property.value / 2 : property.value;
      if (property instanceof LotProperty)
        netWorth += ((LotProperty) property).getHousingValue();
    }
    money += getOutOfJail == GetOutOfJailFree.BOTH ? 100 : (getOutOfJail == GetOutOfJailFree.NONE ? 0 : 50);
    return netWorth;
  }

  public void addProperty(Property property) {
    properties.add(property);
    hud.update();
  }

  public void removeProperty(Property property) {
    properties.remove(property);
    hud.update();
  }

  public boolean hasMonopoly(Color color) {
    int numNeeded = LotProperty.getColorGroupSize(color);
    for (Property ownedProperty: properties) {
      if(ownedProperty instanceof LotProperty)
        if(((LotProperty) ownedProperty).color.equals(color))
          numNeeded--;
    }
    return numNeeded == 0;
  }

  public GetOutOfJailFree getGetOutOfJail() {
    return getOutOfJail;
  }

  /**
   * Adds the given card to the player. If the player has both cards, the internal of GetOutOfJail
   * keeps the value at BOTH.
   *
   * @param card type of card to give to the player
   */
  public void addGetOutOfJail(GetOutOfJailFree card) {
    getOutOfJail = getOutOfJail.addCard(card);
  }

  /**
   * Removes the card from the player. Will keep the value at NONE or the owned if called with a card the player
   * doesn't have the specified card.
   *
   * @param card type of card to remove from the player
   */
  public void removeGetOutOfJail(GetOutOfJailFree card) {
    getOutOfJail = getOutOfJail.removeCard(card);
  }

  /**
   * Called each time the player earns money or property.
   * @param amount amount to modify their net worth by.
   */
}
