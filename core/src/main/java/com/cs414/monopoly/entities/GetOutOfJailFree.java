package com.cs414.monopoly.entities;

public enum GetOutOfJailFree {
  NONE(0), CHEST(1), CHANCE(2), BOTH(3);

  private int value;
  GetOutOfJailFree(int value) {
    this.value = value;
  }

  public GetOutOfJailFree removeCard(GetOutOfJailFree toRemove) {
    if(this == NONE) {
      return this;
    }
    return getJailCardType(toRemove);
  }

  public GetOutOfJailFree addCard(GetOutOfJailFree toAdd) {
    if((this.value ^ toAdd.value) == BOTH.value) {
      return BOTH;
    }
    return getJailCardType(toAdd);
  }

  public GetOutOfJailFree getJailCardType(GetOutOfJailFree card){
    switch(this.value ^ card.value) {
      case 1: return CHEST;
      case 2: return CHANCE;
      default: return this;
    }
  }
}
