package com.cs414.monopoly.ui.dice;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.game.PostRollState;
import com.cs414.monopoly.game.PreRollState;
import com.cs414.monopoly.game.TurnState;
import com.cs414.monopoly.ui.MonopolySkin;

public class RollDiceButton extends TextButton{
  private GameState state = GameState.getInstance();

  public RollDiceButton() {
    super("ROLL DICE", new MonopolySkin());
    padRight(10).padLeft(10);
    addListener(new ChangeListener() {
      @Override
      public void changed(ChangeListener.ChangeEvent event, Actor actor) {
        handleClick();
      }
    });
  }

  private void handleClick() {
    state.getCurrentContext().doAction();
  }

  @Override
  public void draw(Batch batch, float parentAlpha) {
    String msg = "";
    TurnState rollState = state.getCurrentContext().currentState;
    if(rollState instanceof PreRollState) {
      setColor(Color.GREEN);
      msg = "ROLL DICE";
    }
    else if(rollState instanceof PostRollState) {
      setColor(Color.RED);
      msg = "END TURN";
    }

    setText(msg);
    super.draw(batch, parentAlpha);
  }
}
