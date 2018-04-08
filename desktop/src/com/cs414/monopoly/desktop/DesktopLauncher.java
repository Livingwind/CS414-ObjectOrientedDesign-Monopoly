package com.cs414.monopoly.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cs414.monopoly.game.Monopoly;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1366;
		config.height = 768;
		config.resizable = false;
		config.addIcon("assets/icon_32.png", Files.FileType.Internal);
		new LwjglApplication(new Monopoly(), config);
	}
}
