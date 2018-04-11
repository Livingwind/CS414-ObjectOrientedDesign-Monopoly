package main.com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;
import main.com.cs414.monopoly.entities.Player;

public class FreeParking extends AbstractSpace {
  FreeParking(String filename, JsonValue props) {
    super(filename, props, Size.CORNER);
  }

  @Override
  public void onLand(Player player) {

  }
}
