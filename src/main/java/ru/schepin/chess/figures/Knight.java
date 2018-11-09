package ru.schepin.chess.figures;

import ru.schepin.chess.models.Node;

import java.util.ArrayList;
import java.util.Collections;

public class Knight implements Figure {
    @Override
    public ArrayList<Node> possibleSteps(Node node) {
        ArrayList<Node> possibleSteps = new ArrayList<>();
        int x = node.getX();
        int y = node.getY();

        Collections.addAll(possibleSteps,
                new Node(x + 1, y + 2),
                new Node(x + 2, y + 1),
                new Node(x + 2, y - 1),
                new Node(x + 1, y - 2),

                new Node(x - 1, y - 2),
                new Node(x - 2, y - 1),
                new Node(x - 2, y + 1),
                new Node(x - 1, y + 2)
        );
        return possibleSteps;
    }
}
