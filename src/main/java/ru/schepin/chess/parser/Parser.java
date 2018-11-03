package ru.schepin.chess.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ru.schepin.chess.objectFromJsonFile.Field;
import ru.schepin.chess.objectFromJsonFile.FinishPoint;
import ru.schepin.chess.barriers.Obstacle;
import ru.schepin.chess.objectFromJsonFile.StartPoint;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private JsonObject jsonObject;

    public Parser(String sourcePath) throws FileNotFoundException {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(new FileReader(sourcePath));
        jsonObject = element.getAsJsonObject();
    }

    public Field getField() {
        JsonObject objectOfField = jsonObject.getAsJsonObject("field").getAsJsonObject("size");

        Field field = new Field();
        int width = objectOfField.get("width").getAsInt();
        field.setWidth(width);
        int height = objectOfField.get("height").getAsInt();
        field.setHeight(height);

        System.out.println("Field receipt check " + field);
        return field;
    }


    public StartPoint getStartPoint() {
        JsonObject objectOfCoordinate = jsonObject.getAsJsonObject("start").getAsJsonObject("coordinates");

        StartPoint startPoint = new StartPoint();
        int x = objectOfCoordinate.get("x").getAsInt();
        startPoint.setX(x);
        int y = objectOfCoordinate.get("y").getAsInt();
        startPoint.setY(y);

        System.out.println("StartPoint receipt check " + startPoint);
        return startPoint;
    }

    public FinishPoint getFinishPoint() {
        JsonObject objectOfCoordinate = jsonObject.getAsJsonObject("finish").getAsJsonObject("coordinates");

        FinishPoint finishPoint = new FinishPoint();
        int x = objectOfCoordinate.get("x").getAsInt();
        finishPoint.setX(x);
        int y = objectOfCoordinate.get("y").getAsInt();
        finishPoint.setY(y);

        System.out.println("FinishPoint receipt check " + finishPoint);
        return finishPoint;
    }

    public String getNameFigure() {
        JsonObject objectOfCoordinate = jsonObject.getAsJsonObject("figure");
        JsonElement nameFigure = objectOfCoordinate.get("type");
        String name = nameFigure.toString().replace("\"", "");

        System.out.println("Name Of Figure receipt check " + nameFigure.toString());
        return name;
    }

    public List<Obstacle> getObstacles() {
        ArrayList<Obstacle> listOfObstacles = new ArrayList<>();

        JsonArray obstacles = jsonObject.getAsJsonObject("field").getAsJsonArray("obstacles");
        for (int i = 0; i < obstacles.size(); i++) {
            JsonObject obstacleObject = (JsonObject) obstacles.get(i);
            JsonObject obstacleCoordinate = obstacleObject.getAsJsonObject("coordinates");
            int x = obstacleCoordinate.get("x").getAsInt();
            int y = obstacleCoordinate.get("y").getAsInt();
            listOfObstacles.add(new Obstacle(x,y));
        }

        return listOfObstacles;
    }
}
