package ru.schepin.chess.handlers;


import ru.schepin.chess.figures.Figure;
import ru.schepin.chess.models.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class StepHandler {
    private Node currentNode;
    private Queue<Node> queue;
    private List<Node> visited;
    private List<Node> obstacles;
    private Node field;
    private Figure figure;

    public StepHandler(Node currentNode, Queue<Node> queue, List<Node> visited, List<Node> obstacles, Node field, Figure figure) {
        this.currentNode = currentNode;
        this.queue = queue;
        this.visited = visited;
        this.obstacles = obstacles;
        this.field = field;
        this.figure = figure;
    }


    public ArrayList<Node> identifyPossibleSteps() {
        ArrayList<Node> nodeList = new ArrayList<>();

        ArrayList<Node> steps = figure.possibleSteps(currentNode);
        for (int i = 0; i < steps.size(); i++) {
            if (inRange(steps.get(i)) && isNotVisited(steps.get(i)) && !obstacles.contains(steps.get(i))) {
                nodeList.add(steps.get(i));
                queue.add(steps.get(i));
            }
        }
        return nodeList;
    }

    private boolean inRange(Node around) {
        return around.getX() < field.getX() && around.getY() < field.getY() && around.getX() >= 0 && around.getY() >= 0;
    }

    private boolean isNotVisited(Node around) {
        if (!visited.contains(around)) {
            return true;
        }
        return false;
    }
}
