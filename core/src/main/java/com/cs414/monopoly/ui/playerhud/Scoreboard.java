package com.cs414.monopoly.ui.playerhud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.ui.Buttons;
import com.cs414.monopoly.ui.Listeners;
import com.cs414.monopoly.ui.MonopolySkin;

import java.util.ArrayList;
import java.util.Collections;

public class Scoreboard extends Window {
  // todo spacing between columns
  private Player currentPlayer;
  private Buttons buttons = new Buttons();
  private Listeners listeners = new Listeners();
  private Skin skin = new MonopolySkin();
  private ArrayList<Player> clonedPlayerList = GameState.getInstance().playerList;

  public Scoreboard(float width, Player currentPlayer) {
    super("", new MonopolySkin());
    this.currentPlayer = currentPlayer;
    setSize(Gdx.graphics.getWidth()/4f, Gdx.graphics.getWidth()/8f);
    setVisible(false);
    setMovable(false);

    Texture backgroundTexture = new Texture(Gdx.files.internal("assets/table-background.png"));
    Drawable backgroundTRD = new TextureRegionDrawable(new TextureRegion(backgroundTexture));
    setBackground(backgroundTRD);
    update();
  }

  public void update() {
    super.layout();
    clear();
    Label playerName = new Label("Player", skin);
    Label playerNetWorth = new Label("Net Worth", skin);
    Button tradeInvis = buttons.textButton("Trade");
    tradeInvis.setVisible(false);
    add(playerName).align(Align.left);
    add(playerNetWorth).align(Align.left);
    add(tradeInvis).align(Align.left);
    row();

    ArrayList<Player> sortedPlayers = new ArrayList<>(clonedPlayerList);
    Collections.sort(sortedPlayers, new PlayerNetWorthComparator());

    for (Player player : sortedPlayers){
      Label pName = new Label(player.name, skin);
      Label pNetWorth = new Label(String.format("$%d ", player.getNetWorth()), skin);
      add(pName).align(Align.left);
      add(pNetWorth).align(Align.left);
      if (!currentPlayer.name.equals(player.name)) {
        Button trade = buttons.textButton("Trade");
        trade.addListener(listeners.textListener("Boop"));
        trade.addListener(listeners.toggleListener(player));
        add(trade);
      }
      row();
    }
  }
}

