package com.cs414.monopoly.ui.trade;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.ui.MonopolySkin;

import java.util.ArrayList;

public class TradeTable extends Table {
  private TradeContentManager propertyContent;

  private Label offerLabel = new Label("$", new MonopolySkin());
  private final TextField offerTextField = new TextField("", new MonopolySkin());

  public TradeTable(Player player, Boolean swap){
    propertyContent = new TradeContentManager(player, swap);
    add(propertyContent);//.align(Align.center);
    row();
    Table offer = new Table();
    offer.add(offerLabel).align(Align.right);
    offer.add(offerTextField).align(Align.left);
    add(offer);
  }

  public ArrayList<Property> getTradedProperties(){
    return propertyContent.selectedProperties;
  }

  @Override
  protected void setParent(Group parent) {
    super.setParent(parent);
  }
}
