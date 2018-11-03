package ru.schepin.chess.figures;

public interface Figure {
    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    void makeStepOnCoordinate(int x, int y);

    void makeStep();
}
