package ru.schepin.chess;


import ru.schepin.chess.otherClasses.Controller;
import ru.schepin.chess.parser.Parser;

import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            new Solution().run(args[0]);
        }
    }


    public void run(String jsonFile) {
        try {
            Parser parser = new Parser(jsonFile);
            Controller controller = new Controller(parser);
            controller.start();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
        }
    }
}