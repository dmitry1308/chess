package ru.schepin.chess.figures;

import ru.schepin.chess.models.Node;

import java.util.ArrayList;

public class King implements Figure {
    @Override
    public ArrayList<Node> possibleSteps(Node node) {
        ArrayList<Node> possibleSteps = new ArrayList<>();
        for (int x = node.getX() - 1; x <= node.getX() + 1; x++) {
            for (int y = node.getY() - 1; y <= node.getY() + 1; y++) {
                Node around = new Node(x, y);
                possibleSteps.add(around);

            }
        }
        return possibleSteps;
    }
}
