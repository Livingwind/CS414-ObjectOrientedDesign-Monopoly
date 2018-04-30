package com.cs414.monopoly.ui.debug;

import com.cs414.monopoly.TestGame;
import org.junit.Before;
import org.junit.Test;

public class TestDebugConsole extends TestGame {

  public DebugConsole debugConsole;

  @Before
  public void setUp() {
    debugConsole = new DebugConsole(new DebugGroup());
  }

  @Test
  public void testDebugConsole() {

  }

}
