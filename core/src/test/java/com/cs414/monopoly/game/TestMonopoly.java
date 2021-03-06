package com.cs414.monopoly.game;

import com.cs414.monopoly.TestGame;
import org.junit.Before;
import org.junit.Test;

public class TestMonopoly extends TestGame {

  private Monopoly monopoly;

  @Before
  public void setUp() {
    monopoly = new Monopoly(false);
  }

  @Test
  public void testCreate() {
    monopoly = new Monopoly(false);
  }

  @Test
  public void testDebug() {
    monopoly = new Monopoly(true);
  }

}
