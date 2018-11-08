package ru.schepin.chess.handlers;

import ru.schepin.chess.models.Node;

import java.util.ArrayList;

public class MarkHandler {
    private final ArrayList<Node> nearestNodes;
    private final Node currentNode;
    private final int[][] marked;

    public MarkHandler(ArrayList<Node> nearestNodes, Node currentNode, int[][] marked) {
        this.nearestNodes = nearestNodes;
        this.currentNode = currentNode;
        this.marked = marked;
    }

    public int[][] mark() {
        ArrayList<Node> selected = selectUnmarkedNodes();
        if (!selected.isEmpty()) {
            assignMarking(currentNode, selected, marked);
        }
        return marked;
    }

    private ArrayList<Node> selectUnmarkedNodes() {
        ArrayList<Node> unmarkedNodes = new ArrayList<>();
        for (int i = 0; i < nearestNodes.size(); i++) {
            int point = marked[nearestNodes.get(i).getY()][nearestNodes.get(i).getX()];

            if (point == 0) {
                unmarkedNodes.add(nearestNodes.get(i));
            }
        }
        return unmarkedNodes;
    }

    private void assignMarking(Node node, ArrayList<Node> selected, int[][] marked) {
        int markNumber = marked[node.getY()][node.getX()];
        int mark = markNumber + 1;
        for (int i = 0; i < selected.size(); i++) {
            marked[selected.get(i).getY()][selected.get(i).getX()] = mark;
        }
    }
}
