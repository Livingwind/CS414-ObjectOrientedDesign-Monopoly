package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;

public class SpaceFactory {
  public enum SpaceType {
    LOT("lot"), RAILROAD("railroad"), UTILITY("utility"), GO("go"),
    CHEST("chest"), INCOME("income"), CHANCE("chance"), JAIL("jail"),
    FREEPARKING("free"), TO_JAIL("gtj"), LUXURY("luxury");

    private String text;
    SpaceType(String text) {
      this.text = text;
    }

    public static SpaceType fromString(String value) {
      for(SpaceType type: SpaceType.values()) {
        if(type.text.equals(value)) {
          return type;
        }
      }
      return null;
    }
  }

  public static AbstractSpace createSpace(String dir, JsonValue props) {
    SpaceType type = SpaceType.fromString(props.get("type").asString());
    if(type == null) {
      return null;
    }
    String path = dir + String.format("%02d.png", props.get("position").asInt());

    switch(type) {
      case LOT:
        return new Lot(path, props);
      case RAILROAD:
        return new Railroad(path, props);
      case UTILITY:
        return new Utility(path, props);
      case CHEST:
        return new Chest(path, props);
      case CHANCE:
        return new Chance(path, props);
      case INCOME:
        return new IncomeTax(path, props);
      case LUXURY:
        return new LuxuryTax(path, props);
      case JAIL:
        return new Jail(path, props);
      case TO_JAIL:
        return new ToJail(path, props);
      case GO:
        return new Go(path, props);
      case FREEPARKING:
        return new FreeParking(path, props);
      default:
        return null;
    }
  }
}
