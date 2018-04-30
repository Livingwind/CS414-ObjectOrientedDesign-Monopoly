package com.cs414.monopoly.ui.dialog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.cs414.monopoly.entities.GetOutOfJailFree;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.game.PreRollState;
import com.cs414.monopoly.ui.MonopolySkin;

public class JailDialog extends BlankDialog {
  Player current = GameState.getInstance().getCurrentPlayer();

  public JailDialog() {
    super("You're in Jail! Select an option...");
    show(GameState.getInstance().getStage());

    TextButton close = new TextButton("Roll", new MonopolySkin());
    close.addListener(new ClickListener() {

      @Override
      public void clicked(InputEvent event, float x, float y) {
        remove();
      }
    });

    TextButton pay_$50 = new TextButton("Pay $50", new MonopolySkin());
    pay_$50.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        pay();
        remove();
      }
    });

    TextButton chance = new TextButton("Chest\nGet out of Jail", new MonopolySkin());
    TextButton chest = new TextButton("Chance\nGet out of Jail", new MonopolySkin());

    if(current.getMoney() < 50) {
      disable(pay_$50);
    }
    GetOutOfJailFree cards = current.getGetOutOfJail();
    if(!cards.hasCard(GetOutOfJailFree.CHANCE)) {
      disable(chance);
    }
    if(!cards.hasCard(GetOutOfJailFree.CHEST)) {
      disable(chest);
    }

    defaults().width(getWidth()/4.1f);
    add(chance);
    add(chest);
    add(pay_$50);
    add(close);
  }

  private void disable(TextButton btn) {
    btn.setColor(Color.RED);
    btn.setTouchable(Touchable.disabled);
  }

  private void pay() {
    current.modifyMoney(-50);
    releasePlayer();
  }

  private void useCard(GetOutOfJailFree card) {
    current.getGetOutOfJail().removeCard(card);
  }

  private void releasePlayer() {
    current.inJail = 0;
    current.space.placePlayer(current);
    GameState.getInstance().getCurrentContext().currentState = new PreRollState();
  }

  /**
   * Called by the framework when an actor is added to or removed from a group.
   *
   * @param parent May be null if the actor has been removed from the parent.
   */
  @Override
  protected void setParent(Group parent) {
    super.setParent(parent);
    setSize(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/5);
  }
}
