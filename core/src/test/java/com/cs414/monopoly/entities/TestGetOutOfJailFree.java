package com.cs414.monopoly.entities;

import com.cs414.monopoly.TestGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGetOutOfJailFree extends TestGame {

  private GetOutOfJailFree getOutOfJailFree1;
  private GetOutOfJailFree getOutOfJailFree2;
  private GetOutOfJailFree getOutOfJailFree3;
  private GetOutOfJailFree getOutOfJailFree4;

  @Before
  public void setUp() {
    getOutOfJailFree1 = GetOutOfJailFree.CHEST;
    getOutOfJailFree2 = GetOutOfJailFree.CHANCE;
    getOutOfJailFree3 = GetOutOfJailFree.BOTH;
    getOutOfJailFree4 = GetOutOfJailFree.NONE;
  }

  @Test
  public void testRemoveCard() {
    assertEquals(getOutOfJailFree2, getOutOfJailFree2.removeCard(getOutOfJailFree2));
    assertEquals(getOutOfJailFree4, getOutOfJailFree4.removeCard(getOutOfJailFree4));
  }

  @Test
  public void testAddCard() {
    assertEquals(getOutOfJailFree1, getOutOfJailFree1.addCard(getOutOfJailFree1));
    assertEquals(getOutOfJailFree3, getOutOfJailFree3.addCard(getOutOfJailFree3));

  }

}
