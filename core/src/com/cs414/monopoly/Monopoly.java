package com.cs414.monopoly;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cs414.monopoly.entities.Entity;

public class Monopoly extends ApplicationAdapter {
  Stage stage;

	@Override
	public void create () {
	  stage = new Stage(new ScreenViewport());
	  Gdx.input.setInputProcessor(stage);
		stage.addActor(new Entity(new Vector2(0, 0), "monopoly_man.png"));
	}

	@Override
	public void render () {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    stage.act(Gdx.graphics.getDeltaTime());
    stage.draw();
	}
}
