package ru.schepin.chess.otherClasses;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ru.schepin.chess.models.Node;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriterInJSonFile {
    public void write(ArrayList<Node> path) {
        JsonArray listCoordinates = createListCoordinates(path);

        JsonObject coordinates = new JsonObject();
        coordinates.add("Координаты пути", listCoordinates);
        try {
            FileWriter file = new FileWriter("result.json");
            file.write(String.valueOf(coordinates));
            file.flush();
            file.close();

        } catch (IOException e) {
            System.out.println();
        }
    }

    private JsonArray createListCoordinates(ArrayList<Node> path) {
        JsonArray listCoordinates = new JsonArray();

        for (int i = path.size() - 1; i >= 0; i--) {
            JsonObject coordinate = createCoordinate(path.get(i));
            listCoordinates.add(coordinate);
        }
        return listCoordinates;
    }

    private JsonObject createCoordinate(Node node) {
        JsonObject coordinate = new JsonObject();

        coordinate.addProperty("x", node.getX());
        coordinate.addProperty("y", node.getY());
        return coordinate;
    }
}

