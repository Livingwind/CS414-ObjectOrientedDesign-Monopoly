package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.ui.dialog.TaxDialog;

public class Tax extends AbstractSpace {
  private String name;
  private TaxType type;

  public Tax(String filename, int location, JsonValue props, final TaxType type) {
    super(filename, location, props, Size.STANDARD);
    name = props.get("name").asString();
    this.type = type;
  }

  @Override
  protected void onLand(Player player) {
    new TaxDialog(name, type);
  }
}
