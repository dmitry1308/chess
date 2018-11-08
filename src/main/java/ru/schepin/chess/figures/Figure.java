package ru.schepin.chess.figures;

import ru.schepin.chess.models.Node;

import java.util.ArrayList;

public interface Figure {
    ArrayList<Node> possibleSteps(Node node);
}
