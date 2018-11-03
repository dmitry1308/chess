package ru.schepin.chess.objectFromJsonFile;

public class Field {
    private int width;
    private int height;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Field() {
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String   toString() {
        return "Field{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
