package ru.schepin.chess;

import ru.schepin.chess.figures.Figure;

import java.util.Properties;

public class FigureFactory {
    public Figure createFigure(String figure) {
        Util util = new Util();
        try {
            Properties properties = util.getProperties();
            String pathToClassForFigure = properties.getProperty(figure);
            Class<?> aClass = Class.forName(pathToClassForFigure);
            Object o = aClass.newInstance();
            return (Figure) o;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException();
        }
    }
}
