package com.cs414.monopoly.spaces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.TestGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSpaceFactory extends TestGame {

  AbstractSpace space;

  @Test
  public void testCreateSpace() {
    space = SpaceFactory.createSpace("assets/board_original/%s/", 5, config.get(5));
    assertTrue(space instanceof Railroad);
  }

  @Test
  public void testFromString() {
    assertEquals(SpaceFactory.SpaceType.RAILROAD, SpaceFactory.SpaceType.fromString("railroad"));
  }

}
