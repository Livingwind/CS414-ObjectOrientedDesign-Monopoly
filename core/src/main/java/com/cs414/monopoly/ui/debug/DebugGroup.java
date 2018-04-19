package com.cs414.monopoly.ui.debug;

import com.badlogic.gdx.scenes.scene2d.Group;

public class DebugGroup extends Group {
  private DebugConsole console = new DebugConsole(this);
  private DebugLog log = new DebugLog();

  public DebugGroup() {
    setSize(300, 400);
    console.setSize(300, 20);
    log.setBounds(0, console.getHeight(),
        300, getHeight()-console.getHeight());
    addActor(console);
    addActor(log);
  }

  public void logCommand(String line) {
    System.out.println(line);
    log.appendText('\n' + line);
  }
}
