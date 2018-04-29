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
    ScreenManager manager = ScreenManager.getInstance();
    manager.init(new Monopoly(false));
    manager.showScreen(Screens.SETUP, batch);

    SetupScreen game = (SetupScreen)manager.getScreen();
    game.pause();
    game.resume();
  }
}
