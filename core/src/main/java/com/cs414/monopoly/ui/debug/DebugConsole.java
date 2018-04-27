package com.cs414.monopoly.ui.debug;

import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.spaces.PropertySpace;
import com.cs414.monopoly.ui.MonopolySkin;
import com.cs414.monopoly.ui.dialog.DebugDialog;

public class DebugConsole extends TextField {
  private GameState state = GameState.getInstance();
  private DebugGroup group;

  public DebugConsole(DebugGroup group) {
    super("", new MonopolySkin());
    this.group = group;
    setTextFieldListener(new TextFieldListener() {
      @Override
      public void keyTyped(TextField textField, char c) {
        if(c == '\n' || c == '\r') {
          processCommand(getText());
          setText("");
        }
      }
    });
  }

  private void processCommand(String cmd) {
    String[] parsed = cmd.split(" ");
    switch(parsed[0].toLowerCase()) {
      case "help":
        helpCommand();
        break;
      case "move":
        moveCommand(parsed);
        break;
      case "set":
        setCommand(parsed);
        break;
      case "money":
        moneyCommand(parsed);
        break;
      case "property":
      case "prop":
        propertyCommand(parsed);
    }
    group.logCommand(cmd);
  }

  // Commands are added to DebugDialog
  private void helpCommand(){
    new DebugDialog();
  }

  /**
   * Command: move playerName intAmount
   *
   * Move player forwards a given amount.   *
   * @param cmds commands
   */
  private void moveCommand(String[] cmds) {
    try {
      Player player = state.getPlayer(cmds[1]);
      int amount = Integer.parseInt(cmds[2]);
      state.setTurn(player);
      state.getBoard().movePlayer(player, amount);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Command: set playerName intPosition
   *
   * Set player at board position.
   * @param cmds commands
   */
  private void setCommand(String[] cmds) {
    try {
      Player player = state.getPlayer(cmds[1]);
      state.setTurn(player);
      state.getBoard().setPlayer(player, Integer.parseInt(cmds[2]));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Command: money playerName intAmount
   *
   * Add/Remove money from player.
   * @param cmds commands
   */
  private void moneyCommand(String[] cmds) {
    try {
      Player player = state.getPlayer(cmds[1]);
      int amount = Integer.parseInt(cmds[2]);
      player.modifyMoney(amount);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Command: property playerName intLocation
   * Command: prop playerName intLocation
   *
   * Player buys given property.
   * (Even if owned by another player)
   * @param cmds commands
   */
  private void propertyCommand(String[] cmds) {
    try {
      Player player = state.getPlayer(cmds[1]);
      int propertyIndex = Integer.parseInt(cmds[2]);
      Property property = ((PropertySpace)GameState.getInstance().getBoard().spaces.get(propertyIndex)).property;
      player.purchaseProperty(property);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
