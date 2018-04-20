package com.cs414.monopoly.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.groups.Board;
import com.cs414.monopoly.ui.debug.DebugGroup;
import com.cs414.monopoly.ui.playerhud.CurrentPlayerInfo;

import java.util.ArrayList;

public class GameState {
  private static GameState instance;
  private ArrayList<Player> playerList;
  private Player currentPlayer;

  private long timeremaining;
  private RollContext rollContext;

  private Stage stage;
  private Board board;
  private DebugGroup debug;
  private CurrentPlayerInfo info;

  public static GameState getInstance() {
    if(instance == null) {
      instance = new GameState();
    }
    return instance;
  }

  // SETUP ------------------------------------------------------------------------
  public void initDebug() {
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
      if(player.name.equals(name)) {
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
    }
    currentPlayer = playerList.get(0);

    info = new CurrentPlayerInfo();
    stage.addActor(info);
  }

  // STATE ------------------------------------------------------------------------
  public void log(String line) {
    if(debug != null) {
      debug.logCommand(line);
    } else {
      System.out.println(line);
    }
  }

  public void update() {
    if(info != null) {
      info.invalidate();
    }
  }
  public void nextTurn() {
    int index = playerList.indexOf(currentPlayer);
    currentPlayer = playerList.get((index+1) % playerList.size());
    info.invalidate();
    info.toggleProperties(false);
  }

  public Player getCurrentPlayer() {
    return currentPlayer;
  }

  public RollContext getCurrentContext() {
    return rollContext;
  }
}
