package com.cs414.monopoly.game;

import com.cs414.monopoly.TestGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestPreRollState extends TestGame {

  PreRollState preRollState;
  RollContext rollContext;

  @Before
  public void setUp() {
    preRollState = new PreRollState();
    rollContext = new RollContext();
  }

  @Test
  public void testDoAction() {
    assertTrue(rollContext.currentState instanceof PreRollState);
    preRollState.doAction(rollContext);
    assertTrue(rollContext.currentState instanceof PostRollState || rollContext.currentState instanceof PreRollState);
  }

}
