package ru.schepin.chess;

import ru.schepin.chess.figures.Figure;
import ru.schepin.chess.objectFromJsonFile.Field;
import ru.schepin.chess.objectFromJsonFile.FinishPoint;
import ru.schepin.chess.barriers.Obstacle;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Util {
    public Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream=this.getClass().getClassLoader().getResourceAsStream("figures.properties")) {
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public void displayAllOnBoard(Figure figure, List<Obstacle> obstacles, Field field, FinishPoint finishPoint) {
        int[][] matrixOfField = new int[field.getHeight()][field.getWidth()];
        String[] symbols = {" . ", "fig", "fin", " x "};

        for (int i = 0; i < obstacles.size(); i++) {
            Obstacle obstacle = obstacles.get(i);
            matrixOfField[obstacle.getY()][obstacle.getX()] = 3;
        }

        matrixOfField[figure.getY()][figure.getX()] = 1;
        matrixOfField[finishPoint.getY()][finishPoint.getX()] = 2;
        for (int y = 0; y < field.getHeight(); y++) {
            for (int x = 0; x < field.getWidth(); x++) {
                System.out.print(symbols[matrixOfField[y][x]]);
            }
            System.out.println();
        }
    }
}
