package com.cs414.monopoly.stages;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.game.Monopoly;
import org.junit.Test;
import org.mockito.Mockito;

public class TestSetupScreen extends TestGame {

  @Test
  public void testBuild() {
    SpriteBatch batch = Mockito.mock(SpriteBatch.class);

    SetupScreen game = new SetupScreen(batch);
    game.build();
  }
}
