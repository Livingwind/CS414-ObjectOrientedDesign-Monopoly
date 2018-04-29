package com.cs414.monopoly.stages;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public abstract class AbstractScreen extends Stage implements Screen {
  AbstractScreen() {
    super(new ScreenViewport());
  }
  AbstractScreen(Batch batch) {
    super(new ScreenViewport(), batch);
  }

  /**
   * Builds the stage according to the instructions delegated
   * by the subclass.
   */
  public abstract void build();

  /**
   * Called when this screen becomes the current screen for a {@link Game}.
   */
  @Override
  public void show() {
    Gdx.input.setInputProcessor(this);
  }

  /**
   * Called when the screen should render itself.
   *
   * @param delta The time in seconds since the last render.
   */
  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(255f/255,230f/255,255f/255,1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    super.act(delta);
    super.draw();
  }

  /**
   * @param width New width
   * @param height New height
   * @see ApplicationListener#resize(int, int)
   */
  @Override
  public void resize(int width, int height) {
    getViewport().update(width, height, true);
  }

  /**
   * @see ApplicationListener#pause()
   */
  @Override
  public void pause() {

  }

  /**
   * @see ApplicationListener#resume()
   */
  @Override
  public void resume() {

  }

  /**
   * Called when this screen is no longer the current screen for a {@link Game}.
   */
  @Override
  public void hide() {

  }
}
