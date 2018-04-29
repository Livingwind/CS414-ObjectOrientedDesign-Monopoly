package com.cs414.monopoly.stages;

import com.badlogic.gdx.graphics.g2d.Batch;

public enum Screens {
  SETUP {
    // The Object... is called Varargs
    // more info can be found here https://docs.oracle.com/javase/1.5.0/docs/guide/language/varargs.html
    public AbstractScreen getScreen(Object... params) {
      return new SetupScreen();
    }
    public AbstractScreen getScreen(Batch batch, Object... params){
      return new SetupScreen(batch);
    }
  },
  GAME {
    public AbstractScreen getScreen(Object... params) {
      return new GameScreen();
    }
    public AbstractScreen getScreen(Batch batch, Object... params){
      return new GameScreen(batch);
    }
  };

  public abstract AbstractScreen getScreen(Object... params);
  public abstract AbstractScreen getScreen(Batch batch, Object... params);
}
