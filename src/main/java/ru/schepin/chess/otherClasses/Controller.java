package ru.schepin.chess.otherClasses;

import ru.schepin.chess.figures.Figure;
import ru.schepin.chess.handlers.MarkHandler;
import ru.schepin.chess.handlers.PathHandler;
import ru.schepin.chess.handlers.StepHandler;
import ru.schepin.chess.models.Node;
import ru.schepin.chess.parser.Parser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Controller {
    private static Node field;
    private static List<Node> obstacles;
    private static String nameFigure;

    private static List<Node> visited = new ArrayList<>();

    private static Queue<Node> queue = new LinkedList<>();
    private static Node startNode;
    private static Node finishNode;

    private static Printer printer = new Printer();

    private static boolean finished = false;

    public Controller(Parser parser) {
        field = parser.getField();
        startNode = parser.getStartPoint();
        finishNode = parser.getFinishPoint();
        obstacles = parser.getObstacles();
        nameFigure = parser.getNameFigure();
    }

    public void start() {
        int[][] marked = new int[field.getY()][field.getX()];
        Figure figure = initFigure();

        printer.printEntityIdentification();
        printer.displayStartAllOnBoard(field, obstacles, startNode, finishNode);

        queue.add(startNode);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode != null) {
                visited.add(currentNode);
                if (currentNode.equals(finishNode)) {
                    finished = true;
                    break;
                }
                StepHandler stepHandler = new StepHandler(currentNode, queue, visited, obstacles, field, figure);
                ArrayList<Node> nearestNodes = stepHandler.identifyPossibleSteps();

                currentNode.setNear(nearestNodes);

                MarkHandler markHandler = new MarkHandler(nearestNodes, currentNode, marked);
                marked = markHandler.mark();
            }
        }
        if (finished) {
            PathHandler pathHandler = new PathHandler();
            ArrayList<Node> path = pathHandler.buildPath(finishNode, visited, marked);

            WriterInJSonFile writerInJSonFile = new WriterInJSonFile();
            writerInJSonFile.write(path);

            printer.printPathInCoordinates(path, field);
            printer.printResultDisplay(path, field, obstacles, startNode, finishNode);
        } else {
            System.out.println("Пути до финишной точки не существует");
        }


    }

    private Figure initFigure() {
        FigureFactory figureFactory = new FigureFactory();
        return figureFactory.createFigure(nameFigure);
    }
}
