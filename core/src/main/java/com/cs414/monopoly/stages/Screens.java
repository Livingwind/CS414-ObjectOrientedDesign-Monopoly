package com.cs414.monopoly.stages;

public enum Screens {
  SETUP {
    // The Object... is called Varargs
    // more info can be found here https://docs.oracle.com/javase/1.5.0/docs/guide/language/varargs.html
    public AbstractScreen getScreen(Object... params) {
      return new SetupScreen();
    }
  },
  GAME {
    public AbstractScreen getScreen(Object... params) {
      return new GameScreen();
    }
  };

  public abstract AbstractScreen getScreen(Object... params);
}
