package com.cs414.monopoly.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.groups.Board;

import java.util.ArrayList;

public class GameState {
  private static GameState instance;
  private ArrayList<Player> playerList;
  private Player currentPlayer;

  private long timeremaining;
  private RollContext rollContext;

  private Stage stage;
  private Board board;

  public static GameState getInstance() {
    if(instance == null) {
      instance = new GameState();
    }
    return instance;
  }

  // SETUP ------------------------------------------------------------------------
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

  public void startGame(long timelimit) throws IllegalStateException {
    if(timelimit <= 0) {
      throw new IllegalStateException();
    }

    timeremaining = timelimit;
  }

  // STATE ------------------------------------------------------------------------
  public void nextTurn() {
    rollContext.doAction();
    int index = playerList.indexOf(currentPlayer);
    currentPlayer = playerList.get(index % playerList.size());
  }

  public Player getCurrentPlayer() {
    return currentPlayer;
  }

  public TurnState getCurrentState() {
    return rollContext.currentState;
  }
}
