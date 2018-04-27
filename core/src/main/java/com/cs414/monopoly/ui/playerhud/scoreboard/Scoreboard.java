package com.cs414.monopoly.ui.playerhud.scoreboard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.ui.Buttons;
import com.cs414.monopoly.ui.Listeners;
import com.cs414.monopoly.ui.MonopolySkin;
import com.cs414.monopoly.ui.playerhud.PlayerMoneyComparator;
import com.cs414.monopoly.ui.playerhud.PlayerNameComparator;
import com.cs414.monopoly.ui.playerhud.PlayerNetWorthComparator;

import java.util.ArrayList;
import java.util.Comparator;

public class Scoreboard extends Window {
  // todo spacing between columns
  private Player currentPlayer;
  private Buttons buttons = new Buttons();
  private Listeners listeners = new Listeners();
  private Skin skin = new MonopolySkin();
  private ArrayList<Player> sortedPlayers = new ArrayList<>(GameState.getInstance().playerList);
  private int comparator = 1; // 1) NetWorth 2) Money 3)Name

  public Scoreboard(Player currentPlayer) {
    super("", new MonopolySkin());
    this.currentPlayer = currentPlayer;
    setSize(Gdx.graphics.getWidth()/4f, Gdx.graphics.getWidth()/6f);
    setVisible(false);
    setMovable(false);
    Texture backgroundTexture = new Texture(Gdx.files.internal("assets/table-background.png"));
    Drawable backgroundTRD = new TextureRegionDrawable(new TextureRegion(backgroundTexture));
    setBackground(backgroundTRD);
    update();
  }

  private Comparator<Player> getComparator(){
    switch(comparator) {
      case 1: return new PlayerNetWorthComparator();
      case 2: return new PlayerMoneyComparator();
      case 3: return new PlayerNameComparator();
      default: return new PlayerNetWorthComparator();
    }
  }

  private ChangeListener setNetWorthComparator = new ChangeListener() {
    @Override
    public void changed(ChangeEvent event, Actor actor) {
      comparator = 1;
      update();
    }
  };

  private ChangeListener setMoneyComparator = new ChangeListener() {
    @Override
    public void changed(ChangeEvent event, Actor actor) {
      comparator = 2;
      update();
    }
  };

  private ChangeListener setNameComparator = new ChangeListener() {
    @Override
    public void changed(ChangeEvent event, Actor actor) {
      comparator = 3;
      update();
    }
  };

  public void update() {
    super.layout();
    clear();
    Button playerName = buttons.textButton("Player");
    playerName.addListener(setNameComparator);
    if (comparator == 3) playerName.setColor(Color.GRAY);
    Button playerMoney = buttons.textButton("Money");
    playerMoney.addListener(setMoneyComparator);
    if (comparator == 2) playerMoney.setColor(Color.GRAY);
    Button playerNetWorth = buttons.textButton("Net Worth");
    playerNetWorth.addListener(setNetWorthComparator);
    if (comparator == 1) playerNetWorth.setColor(Color.GRAY);
    Button tradeInvis = buttons.textButton("Trade");
    tradeInvis.setVisible(false);
    add(playerName).align(Align.left);
    add(playerMoney).align(Align.left);
    add(playerNetWorth).align(Align.left);
    add(tradeInvis).align(Align.left);
    row();

    sortedPlayers = new ArrayList<>(GameState.getInstance().playerList);
    sortedPlayers.sort(getComparator());

    for (Player player : sortedPlayers){
      Label pName = new Label(player.name, skin);
      pName.setWrap(true);
      Label pMoney = new Label(String.format("$%d ", player.getMoney()), skin);
      Label pNetWorth = new Label(String.format("$%d ", player.getNetWorth()), skin);
      add(pName).width(100).align(Align.left);
      add(pMoney);
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

