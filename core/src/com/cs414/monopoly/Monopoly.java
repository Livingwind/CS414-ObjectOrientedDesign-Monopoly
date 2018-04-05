package com.cs414.monopoly;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cs414.monopoly.groups.Board;

public class Monopoly extends ApplicationAdapter {
  private Stage stage;

	@Override
	public void create () {
	  stage = new Stage(new ScreenViewport());
	  Board b = new Board();
    stage.addActor(b);

    Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(255f/255,230f/255,255f/255,1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    stage.act(Gdx.graphics.getDeltaTime());
    stage.draw();
	}
}
