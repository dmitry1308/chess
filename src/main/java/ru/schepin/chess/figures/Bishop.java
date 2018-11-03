package ru.schepin.chess.figures;

import java.util.Objects;

public class Bishop implements Figure {
    private int x;
    private int y;

    public Bishop(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Bishop() {
    }

    @Override
    public void makeStepOnCoordinate(int x, int y) {
        System.out.println("Bishop пошел!!! Ура!!!");
    }

    @Override
    public void makeStep() {

    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bishop bishop = (Bishop) o;
        return x == bishop.x &&
                y == bishop.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Bishop{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
