package com.cs414.monopoly.entities;

import com.cs414.monopoly.TestGame;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestPlayer extends TestGame {

  @Test
  public void testAddGetOutOfJail() {
    testPlayer1.addGetOutOfJail(GetOutOfJailFree.BOTH);
    assertTrue(testPlayer1.getGetOutOfJail().equals(GetOutOfJailFree.BOTH));
  }
}
