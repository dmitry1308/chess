package ru.schepin.chess.objectFromJsonFile;

import java.util.Objects;

public class StartPoint {
    private int x;
    private int y;

    public StartPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public StartPoint() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StartPoint that = (StartPoint) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "StartPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}