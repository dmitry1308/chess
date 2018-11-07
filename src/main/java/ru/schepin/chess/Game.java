package ru.schepin.chess;

import ru.schepin.chess.barriers.Obstacle;
import ru.schepin.chess.figures.Figure;
import ru.schepin.chess.objectFromJsonFile.Field;
import ru.schepin.chess.objectFromJsonFile.FinishPoint;
import ru.schepin.chess.objectFromJsonFile.StartPoint;
import ru.schepin.chess.parser.Parser;

import java.util.List;

public class Game {
    private Field field;
    private StartPoint startPoint;
    private FinishPoint finishPoint;
    private List<Obstacle> obstacles;
    private String nameFigure;

    private Figure figure;

    private int steps = 0;

    private GameState gameState;

    public Game(Parser parser) {
        field = parser.getField();
        startPoint = parser.getStartPoint();
        finishPoint = parser.getFinishPoint();
        obstacles = parser.getObstacles();
        nameFigure = parser.getNameFigure();
    }

    void start() {
        figure = initFigure();
        figure.setX(startPoint.getX());
        figure.setY(startPoint.getY());
        new Util().displayAllOnBoard(figure, obstacles, field, finishPoint);

        while (true) {
            figure.makeStep();
            steps++;
            if (!checkInsideBorder()) {
                gameState = GameState.CanNotFinished;
                break;
            } else if (hittingBarrier()) {
                gameState = GameState.HitedBarrier;
                break;
            } else if (isFinish()) {
                gameState = GameState.Finished;
                break;
            }
        }

        System.out.println(gameState.getResult() + " на шаге " + steps);
    }

    private Figure initFigure() {
        FigureFactory figureFactory = new FigureFactory();
        return figureFactory.createFigure(nameFigure);
    }


    public boolean checkInsideBorder() {
        return figure.getX() >= 0 && figure.getY() >= 0 &&
                figure.getX() < field.getWidth() && figure.getY() < field.getHeight();
    }

    private boolean hittingBarrier() {
        Obstacle objectForEquals = new Obstacle(figure.getX(), figure.getY());
        return obstacles.contains(objectForEquals);
    }

    private boolean isFinish() {
        return figure.getX() == finishPoint.getX() && figure.getY() == finishPoint.getY();
    }
}
