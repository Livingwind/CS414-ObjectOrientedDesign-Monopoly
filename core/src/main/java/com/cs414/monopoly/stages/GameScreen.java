package com.cs414.monopoly.stages;

import com.badlogic.gdx.graphics.Color;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.groups.Board;

import java.util.ArrayList;

public class GameScreen extends AbstractScreen {
  /**
   * Builds the stage according to the instructions delegated
   * by the subclass.
   */
  @Override
  public void build() {
    Board board = new Board();
    ArrayList<Player> players = new ArrayList<>();
    String path = "assets/board_original/players/";
    Player chris = new Player(path+"boat.png","Chris", Color.CYAN, 1500);
    Player chris2 = new Player(path+"car.png","Ian", Color.GREEN, 1500);
    Player chris3 = new Player(path+"dog.png","Brandon", Color.BLUE, 1500);
    Player chris4 = new Player(path + "hat.png", "Christian", Color.RED, 1500);

    players.add(chris);
    players.add(chris2);
    players.add(chris3);
    players.add(chris4);
    addActor(board);

    GameState state = GameState.getInstance();
    state.setStage(this);
    state.setBoard(board);
    state.addPlayers(players);

    state.startGame(100000);
  }
}
