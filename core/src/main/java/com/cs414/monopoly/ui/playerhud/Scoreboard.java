package com.cs414.monopoly.ui.playerhud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.ui.Buttons;
import com.cs414.monopoly.ui.Listeners;
import com.cs414.monopoly.ui.MonopolySkin;

import java.util.ArrayList;
import java.util.Collections;

public class Scoreboard extends Window {
  private Player currentPlayer;
  private Buttons buttons = new Buttons();
  private Listeners listeners = new Listeners();
  private Skin skin = new MonopolySkin();
  private ArrayList<Player> clonedPlayerList = GameState.getInstance().playerList;

  public Scoreboard(float width, Player currentPlayer) {
    super("Scoreboard", new MonopolySkin());
    this.currentPlayer = currentPlayer;
    setSize(Gdx.graphics.getWidth()/4f, Gdx.graphics.getWidth()/8f);
    setVisible(false);
    setMovable(false);

    update();
  }

  private static ArrayList<Player> clonePlayers(ArrayList<Player> list) {
    ArrayList<Player> clone = new ArrayList<>(list.size());
    for (Player p : list){
      clone.add(p.clone());
    }
    return clone;
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

    ArrayList<Player> sortedPlayers = clonePlayers(clonedPlayerList);
    Collections.sort(sortedPlayers, new PlayerComparator());

    for (int i = 0; i < sortedPlayers.size(); ++i){
      Player player = sortedPlayers.get(i);
      System.out.println(i + ") " + player.name);
    }

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

