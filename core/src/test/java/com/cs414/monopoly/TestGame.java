package com.cs414.monopoly;

import com.badlogic.gdx.*;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.groups.Board;
import com.cs414.monopoly.ui.playerhud.PlayerHUD;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestGame {
  private static Application application;
  protected static JsonValue config;
  protected static GameState state;
  protected static Player testPlayer1;
  protected static Player testPlayer2;

  @BeforeClass
  public static void setUP() {
    application = new HeadlessApplication(new ApplicationListener() {
      @Override
      public void create() {}
      @Override
      public void resize(int width, int height) {}
      @Override
      public void render() { }
      @Override
      public void pause() {}
      @Override
      public void resume() {}
      @Override
      public void dispose() {}
    });

    Gdx.graphics = mock(Graphics.class);
    Gdx.gl20 = mock(GL20.class);
    Gdx.gl = Gdx.gl20;
    state = GameState.getInstance();
    Board board = new Board();
    state.setBoard(board);
    state.setStage(mock(Stage.class));
    config = new JsonReader().parse(Gdx.files.internal("assets/board_original/config.json")).get(1);
    testPlayer1 = new Player("assets/board_original/players/car.png","test1", Color.GREEN, 1500);
    testPlayer2 = new Player("assets/board_original/players/boat.png","test2", Color.RED, 1500);
    ArrayList<Player> players = new ArrayList<>();
    players.add(testPlayer1);
    players.add(testPlayer2);
    state.addPlayers(players);
    testPlayer1.hud = mock(PlayerHUD.class);
    doNothing().when(testPlayer1.hud).update();
    testPlayer2.hud = mock(PlayerHUD.class);
    doNothing().when(testPlayer2.hud).update();
    state.startGame(100);
    board.setPlayer(testPlayer1, 0);
  }

  @AfterClass
  public static void cleanUp() {
    application.exit();
    application = null;
  }

}
