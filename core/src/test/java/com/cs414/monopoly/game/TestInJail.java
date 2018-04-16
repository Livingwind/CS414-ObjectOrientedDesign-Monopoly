package com.cs414.monopoly.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.cs414.monopoly.TestGame;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class TestInJail extends TestGame {

  private GameState game = GameState.getInstance();
  private String path = "assets/board_original/players/";
  InJail inJail;


  @Before
  public void setUp() {

    inJail = new InJail();
    game.setStage(Mockito.mock(Stage.class));
  }

  @Test
  public void testDoAction() {

  }

}
