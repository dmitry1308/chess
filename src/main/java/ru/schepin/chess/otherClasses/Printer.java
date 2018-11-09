package ru.schepin.chess.otherClasses;

import ru.schepin.chess.models.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Printer {
    private static final String[] symbols = {" . ", "sta", "fin", " x ", " 0 "};

    public void printEntityIdentification() {
        System.out.println("Расшифровка обозначений на поле: ");
        System.out.println(symbols[0] + " - Пустая клетка");
        System.out.println(symbols[1] + " - Старт");
        System.out.println(symbols[2] + " - Финиш");
        System.out.println(symbols[3] + " - Барьер");
        System.out.println(symbols[4] + " - Путь фигуры");
        System.out.println();
    }

    public void printPathInCoordinates(ArrayList<Node> path, Node field) {
        Collections.reverse(path);
        System.out.println("Координаты пути: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print("{" + path.get(i).getX() + ";" + path.get(i).getY() + "} ");
        }
        System.out.println("\n");
    }

    public void printResultDisplay(ArrayList<Node> path, Node field, List<Node> obstacles, Node startNode, Node finishNode) {
        System.out.println("Результат пути фигуры: ");
        int[][] fieldWithStartDates = assignFieldEntitiesInNumbers(field, obstacles, startNode, finishNode);
        int[][] fieldWithPathInNumber = assignFieldWithPathInNumber(fieldWithStartDates, path);

        for (int y = 0; y < field.getY(); y++) {
            for (int x = 0; x < field.getX(); x++) {
                System.out.print(symbols[fieldWithPathInNumber[y][x]]);
            }
            System.out.println();
        }
    }

    private int[][] assignFieldWithPathInNumber(int[][] fieldWithStartDates, ArrayList<Node> path) {
        for (int i = 0; i < path.size(); i++) {
            Node figure = path.get(i);
            fieldWithStartDates[figure.getY()][figure.getX()] = 4;
        }
        return fieldWithStartDates;
    }

    public void displayStartAllOnBoard(Node field, List<Node> obstacles, Node startNode, Node finishNode) {
        System.out.println("Стартовые данные: ");
        int[][] fieldWithStartDates = assignFieldEntitiesInNumbers(field, obstacles, startNode, finishNode);

        for (int i = 0; i < field.getX(); i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();

        for (int y = 0; y < field.getY(); y++) {
            for (int x = 0; x < field.getX(); x++) {
                System.out.print(symbols[fieldWithStartDates[y][x]]);
            }
            System.out.print(" " + y);
            System.out.println();
        }

        System.out.println();
    }

    private int[][] assignFieldEntitiesInNumbers(Node field, List<Node> obstacles, Node startNode, Node finishNode) {
        int[][] matrixOfField = new int[field.getY()][field.getX()];
        List<Node> barriers = obstacles;
        for (int i = 0; i < barriers.size(); i++) {
            Node obstacle = barriers.get(i);
            matrixOfField[obstacle.getY()][obstacle.getX()] = 3;
        }

        matrixOfField[startNode.getY()][startNode.getX()] = 1;
        matrixOfField[finishNode.getY()][finishNode.getX()] = 2;

        return matrixOfField;
    }
}
