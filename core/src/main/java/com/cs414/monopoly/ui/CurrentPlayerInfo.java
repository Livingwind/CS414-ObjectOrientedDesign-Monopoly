package com.cs414.monopoly.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.game.GameState;

public class CurrentPlayerInfo extends Window {
  private Label text = new Label("", getSkin());
  Table test = playerProperties(GameState.getInstance().getCurrentPlayer());

  boolean showTable = false;

  public CurrentPlayerInfo() {
    super("Current Player", new MonopolySkin());
    toggleSize();
    setMovable(false);
    align(Align.left);

    add(text);
    row();
    add(getPropertyButton());
    row();
    add(test).expand();
    //GameState.getInstance().getStage().setDebugAll(true);
    changePlayer(GameState.getInstance().getCurrentPlayer());
  }

  private void toggleSize(){
    if(!showTable) {
      setSize(Gdx.graphics.getWidth()/4f, Gdx.graphics.getHeight()/10f);
      setPosition(Gdx.graphics.getWidth()-getWidth(), Gdx.graphics.getHeight()-getHeight());
      test.setVisible(false);
      test.validate();
    } else {
      setSize(Gdx.graphics.getWidth()/4f, Gdx.graphics.getHeight()/10f + test.getHeight());
      test.setVisible(true);
      test.validate();
    }
    showTable = !showTable;
  }

  public void changePlayer(Player player) {
    String name = String.format("Current Player: %s", player.name);
    String money = String.format("Money: $%d", player.getMoney());
    getTitleLabel().setText(name);
    text.setText(money);

    test.clear();
    showTable = false;
    toggleSize();
  }

  private Table playerProperties(Player player){
    Table playerPropertyTable = new Table();

    playerPropertyTable.setSize(200,0);
    for (int i = 0; i < player.properties.size(); ++i) {
      Property p = player.properties.get(i);
      Label tf = new Label(p.name, new MonopolySkin());
      tf.setSize(200,50);
      playerPropertyTable.setSize(playerPropertyTable.getWidth(), playerPropertyTable.getHeight() + tf.getHeight());
      playerPropertyTable.add(tf);
      playerPropertyTable.row();
    }
    return playerPropertyTable;
  }

  private TextButton getPropertyButton(){
    TextButton btn = new TextButton("Display Properties", new MonopolySkin());
    btn.setColor(Color.DARK_GRAY);
    btn.addListener(new ChangeListener() {
      @Override
      public void changed(ChangeListener.ChangeEvent event, Actor actor) {
        test.clear();
        test.setSize(200,0);
        for (int i = 0; i < GameState.getInstance().getCurrentPlayer().properties.size(); ++i) {
          Property p = GameState.getInstance().getCurrentPlayer().properties.get(i);
          Label label = new Label(p.name, new MonopolySkin());
          label.setSize(200,30);
          test.setSize(test.getWidth(), test.getHeight() + label.getHeight());
          test.add(label);
          test.row();
        }
        toggleSize();
      }
    });
    return btn;
  }
}
