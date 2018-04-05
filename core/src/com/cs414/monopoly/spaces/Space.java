package com.cs414.monopoly.spaces;

public class Space {
  public enum Direction {
    DOWN(0), LEFT(90), UP(180), RIGHT(270);

    private float rotation;
    Direction(float rotation) {
      this.rotation = rotation;
    }

    public float value() {
      return rotation;
    }
  }
}
