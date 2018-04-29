package com.cs414.monopoly.stages;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cs414.monopoly.TestGame;
import com.cs414.monopoly.game.Monopoly;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;

public class TestScreenManager extends TestGame {

  @Test
  public void testBuild() {
    SpriteBatch batch = Mockito.mock(SpriteBatch.class);
    ScreenManager manager = ScreenManager.getInstance();
    manager.init(new Monopoly(false));
    manager.showScreen(Screens.SETUP, batch);
    assertTrue(manager.getScreen() instanceof SetupScreen);

    manager.showScreen(Screens.GAME, batch);
    assertTrue(manager.getScreen() instanceof GameScreen);
  }
}
