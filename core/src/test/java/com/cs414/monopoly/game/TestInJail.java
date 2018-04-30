package com.cs414.monopoly.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.cs414.monopoly.TestGame;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestInJail extends TestGame {

  private InJail inJail;

  @Before
  public void setUp() {
    inJail = new InJail();
  }

  @Test
  public void testDoAction() {
    assertTrue(state.getCurrentContext().currentState instanceof PreRollState);
    inJail.doAction(state.getCurrentContext());
    assertTrue(state.getCurrentContext().currentState instanceof PostRollState);
  }

}
