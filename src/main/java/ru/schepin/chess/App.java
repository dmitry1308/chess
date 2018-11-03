package ru.schepin.chess;


import ru.schepin.chess.parser.Parser;

import java.io.FileNotFoundException;

public class App {
    private String jsonFile;

    public App(String jsonFile) {
        this.jsonFile = jsonFile;
    }

    public void run() throws FileNotFoundException {
        Parser parser = new Parser(jsonFile);
        Game game = new Game(parser);
        game.start();
    }
}
