package ru.schepin.chess.objectFromJsonFile;

import java.util.Objects;

public class FinishPoint {
    private int x;
    private int y;

    public FinishPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public FinishPoint() {
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
        FinishPoint that = (FinishPoint) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "FinishPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
