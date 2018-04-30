package com.cs414.monopoly.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.groups.Board;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;


public class TestGameState extends TestGame {

  @Test
  public void testStartGameFail () {
    boolean fail = false;
    try {
      state.startGame(-1);
    } catch (IllegalStateException e) {
      fail = true;
    }
    assert(fail);
  }

  @Test
  public void testGameSetup() {
    assertNotNull(state.getCurrentPlayer());
  }


}