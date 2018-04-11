package main.com.cs414.monopoly.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import main.com.cs414.monopoly.groups.Board;

public class Monopoly extends ApplicationAdapter {
	private GameState state;

	@Override
	public void create () {
	  Stage stage = new Stage(new ScreenViewport());

		stage.addActor(new Board());
	  state = GameState.getInstance();
    state.setStage(stage);
    Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(255f/255,230f/255,255f/255,1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    state.getStage().act(Gdx.graphics.getDeltaTime());
    state.getStage().draw();
	}
}
