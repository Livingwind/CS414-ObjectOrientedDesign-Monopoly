package com.cs414.monopoly.ui.playerhud;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.ui.MonopolySkin;

public class PropertyTable extends Table {
  @Override
  public void layout() {
    Player player = GameState.getInstance().getCurrentPlayer();
    clear();
    setSize(200,0);
    for (int i = 0; i < player.properties.size(); ++i) {
      Property p = player.properties.get(i);
      Label label = new Label(p.name, new MonopolySkin());
      setSize(getWidth(), getHeight() + label.getHeight());
      add(label);
      row();
    }

    super.layout();
  }

  PropertyTable() {
    setVisible(false);
  }
}
