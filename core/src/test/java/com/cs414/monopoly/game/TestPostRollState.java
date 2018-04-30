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

import static org.junit.Assert.assertTrue;

public class TestPostRollState extends TestGame {

  PostRollState postRollState;

  @Before
  public void setUp() {
    postRollState = new PostRollState();
  }

  @Test
  public void testDoAction() {
    assertTrue(state.getCurrentPlayer() == testPlayer1);
    postRollState.doAction(new RollContext());
    assertTrue(state.getCurrentPlayer() == testPlayer2);
  }

}
