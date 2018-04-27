package com.cs414.monopoly.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.cs414.monopoly.stages.ScreenManager;
import com.cs414.monopoly.stages.Screens;

public class Monopoly extends Game {
	private GameState state;
	private boolean debug;

	public Monopoly(boolean debug) {
		this.debug = debug;
	}

	@Override
	public void create () {
    ScreenManager.getInstance().init(this);
		if(debug) {
			Gdx.app.setLogLevel(Application.LOG_DEBUG);
      ScreenManager.getInstance().showScreen(Screens.GAME);
		} else {
      ScreenManager.getInstance().showScreen(Screens.SETUP);
    }
	}
}
