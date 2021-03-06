package com.cs414.monopoly.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.groups.Board;
import com.cs414.monopoly.ui.debug.DebugGroup;

import java.util.ArrayList;

public class GameState {
  private static GameState instance;
  public ArrayList<Player> playerList;
  private Player currentPlayer;

  private long timeremaining;
  private RollContext rollContext;

  private Stage stage;
  private Board board;
  private DebugGroup debug;
  public static int numHouses;
  public static int numHotels;
  public int lastRoll;

  public static GameState getInstance() {
    if(instance == null) {
      instance = new GameState();
    }
    return instance;
  }

  // SETUP ------------------------------------------------------------------------
  private void initDebug() {
    stage.addActor(new DebugGroup());
    stage.setDebugAll(true);
    this.debug = new DebugGroup();
  }

  public void setStage(Stage stage) {
    if(this.stage == null) {
      this.stage = stage;
    } else {
      System.err.println("Stage already assigned.");
    }
  }

  public void setBoard(Board board) {
    if(this.board == null) {
      this.board = board;
    } else {
      System.err.println("Board already assigned.");
    }
  }

  public Stage getStage() {
    return stage;
  }

  public Board getBoard() {
    return board;
  }

  public void addPlayers(ArrayList<Player> players){
    playerList = players;
  }

  public Player getPlayer(String name) {
    for(Player player: playerList) {
      if(player.name.toLowerCase().equals(name.toLowerCase())) {
        return player;
      }
    }
    return null;
  }

  public void startGame(long timelimit) throws IllegalStateException {
    if(Gdx.app.getLogLevel() == Application.LOG_DEBUG) {
      System.out.println("Debug enabled");
      initDebug();
    }

    if(timelimit <= 0) {
      throw new IllegalStateException();
    }
    rollContext = new RollContext();

    timeremaining = timelimit;

    for(Player player: playerList) {
      board.initPlayer(player);
      player.initHUD();
    }
    currentPlayer = playerList.get(0);
    currentPlayer.hud.setVisible(true);

  }

  // STATE ------------------------------------------------------------------------
  public void log(String line) {
    if(debug != null) {
      debug.logCommand(line);
    } else {
      System.out.println(line);
    }
  }

  public void setTurn(Player player) {
    currentPlayer.hud.setVisible(false);
    int index = playerList.indexOf(player);
    currentPlayer = playerList.get(index);
    currentPlayer.hud.setVisible(true);
  }

  public void nextTurn() {
    currentPlayer.hud.setVisible(false);
    int index = playerList.indexOf(currentPlayer);
    currentPlayer = playerList.get((index+1) % playerList.size());
    currentPlayer.hud.setVisible(true);
  }

  public Player getCurrentPlayer() {
    return currentPlayer;
  }

  public RollContext getCurrentContext() {
    return rollContext;
  }

  public static void setHousing(int numHouses, int numHotels) {
    instance.numHouses = numHouses;
    instance.numHotels = numHotels;
  }
}
