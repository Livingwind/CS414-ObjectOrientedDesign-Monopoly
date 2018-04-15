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

  public static AbstractSpace createSpace(String dir, int location, JsonValue props) {
    SpaceType type = SpaceType.fromString(props.get("type").asString());
    if(type == null) {
      return null;
    }
    String path = dir + String.format("%02d.png", props.get("position").asInt());

    switch(type) {
      case LOT:
        return new Lot(path, location, props);
      case RAILROAD:
        return new Railroad(path, location, props);
      case UTILITY:
        return new Utility(path, location, props);
      case CHEST:
        return new Chest(path, location, props);
      case CHANCE:
        return new Chance(path, location, props);
      case INCOME:
        return new Tax(path, location, props, TaxType.INCOME);
      case LUXURY:
        return new Tax(path, location, props, TaxType.LUXURY);
      case JAIL:
        return new Jail(path, location, props);
      case TO_JAIL:
        return new ToJail(path, location, props);
      case GO:
        return new Go(path, location, props);
      case FREEPARKING:
        return new FreeParking(path, location, props);
      default:
        return null;
    }
  }
}
