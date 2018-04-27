package com.cs414.monopoly.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.stages.ScreenManager;
import com.cs414.monopoly.stages.Screens;

import java.util.ArrayList;

public class Monopoly extends Game {
	private boolean debug;

	public Monopoly(boolean debug) {
		this.debug = debug;
	}

	@Override
	public void create () {
    ScreenManager.getInstance().init(this);
		if(debug) {
			Gdx.app.setLogLevel(Application.LOG_DEBUG);

			String path = "assets/board_original/players/";
			Player p1 = new Player(path+"hat.png","Grace Hopper", Color.SCARLET, 1500);
      Player p2 = new Player(path+"boat.png","Christopher Westerman", Color.CYAN, 1500);
      ArrayList<Player> testers = new ArrayList<>();
      testers.add(p1);
      testers.add(p2);
			GameState.getInstance().addPlayers(testers);

			ScreenManager.getInstance().showScreen(Screens.GAME);
		} else {
      ScreenManager.getInstance().showScreen(Screens.SETUP);
    }
	}
}
