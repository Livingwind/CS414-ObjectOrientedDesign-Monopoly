package com.cs414.monopoly.game;

import com.cs414.monopoly.entities.TestGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestHelpers extends TestGame {

  @Test
  public void testRollDice(){
    int[] dice = Helpers.rollDice();
    for(int i = 0; i<dice.length; i++) {
      Assert.assertTrue(dice[i] > 0);
      Assert.assertTrue(dice[i] < 6);

    }
  }
}