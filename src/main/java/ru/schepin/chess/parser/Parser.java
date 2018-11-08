package ru.schepin.chess.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ru.schepin.chess.models.Node;

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

    public Node getField() {
        JsonObject objectOfField = jsonObject.getAsJsonObject("field").getAsJsonObject("size");

        Node field = new Node();
        int width = objectOfField.get("width").getAsInt();
        field.setX(width);
        int height = objectOfField.get("height").getAsInt();
        field.setY(height);
        return field;
    }


    public Node getStartPoint() {
        JsonObject objectOfCoordinate = jsonObject.getAsJsonObject("start").getAsJsonObject("coordinates");

        Node startPoint = new Node();
        int x = objectOfCoordinate.get("x").getAsInt();
        startPoint.setX(x);
        int y = objectOfCoordinate.get("y").getAsInt();
        startPoint.setY(y);
        return startPoint;
    }

    public Node getFinishPoint() {
        JsonObject objectOfCoordinate = jsonObject.getAsJsonObject("finish").getAsJsonObject("coordinates");

        Node finishPoint = new Node();
        int x = objectOfCoordinate.get("x").getAsInt();
        finishPoint.setX(x);
        int y = objectOfCoordinate.get("y").getAsInt();
        finishPoint.setY(y);
        return finishPoint;
    }

    public String getNameFigure() {
        JsonObject objectOfCoordinate = jsonObject.getAsJsonObject("figure");
        JsonElement nameFigure = objectOfCoordinate.get("type");
        String name = nameFigure.toString().replace("\"", "");
        return name;
    }

    public List<Node> getObstacles() {
        ArrayList<Node> listOfObstacles = new ArrayList<>();

        JsonArray obstacles = jsonObject.getAsJsonObject("field").getAsJsonArray("obstacles");
        for (int i = 0; i < obstacles.size(); i++) {
            JsonObject obstacleObject = (JsonObject) obstacles.get(i);
            JsonObject obstacleCoordinate = obstacleObject.getAsJsonObject("coordinates");
            int x = obstacleCoordinate.get("x").getAsInt();
            int y = obstacleCoordinate.get("y").getAsInt();
            listOfObstacles.add(new Node(x,y));
        }

        return listOfObstacles;
    }
}
