package com.cs414.monopoly.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.groups.Board;

import java.util.ArrayList;

public class Monopoly extends ApplicationAdapter {
	private GameState state;

	@Override
	public void create () {
	  Stage stage = new Stage(new ScreenViewport());
		Board board = new Board();
		ArrayList<Player> players = new ArrayList<Player>();
		String path = "assets/board_original/players/";
		Player chris = new Player(path+"boat.png","chris", Color.CYAN, 1500);
		Player chris2 = new Player(path+"car.png","ian", Color.CYAN, 1500);
		Player chris3 = new Player(path+"dog.png","brandon", Color.CYAN, 1500);
		players.add(chris);
		players.add(chris2);
		players.add(chris3);
		stage.addActor(board);
	  state = GameState.getInstance();
    state.setStage(stage);
    state.setBoard(board);
		state.addPlayers(players);

    state.startGame(100000);
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
