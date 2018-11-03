package ru.schepin.chess.figures;

import java.util.Objects;

public class Pawn implements Figure {
    private int x;
    private int y;

    public Pawn(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pawn() {
    }

    @Override
    public void makeStepOnCoordinate(int x, int y) {

    }

    @Override
    public void makeStep() {
        this.y++;
        String format = String.format("Pawn сделал шаг! x=%s, y=%s;", x, y);
        System.out.println(format);
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
    public String toString() {
        return "Pawn{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pawn pawn = (Pawn) o;
        return x == pawn.x &&
                y == pawn.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}
