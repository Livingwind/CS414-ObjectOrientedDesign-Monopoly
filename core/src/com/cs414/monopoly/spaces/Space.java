package com.cs414.monopoly.spaces;

public class Space {
  public enum Size {
    STANDARD(81, 133), CORNER(133, 133);

    private int width;
    private int height;

    Size(int width, int height) {
      this.width = width;
      this.height = height;
    }

    public int getWidth() {
      return width;
    }
    public int getHeight() {
      return height;
    }
  }

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

  public Space(String textureFilename, Size size, Direction direction) {

  }
}
