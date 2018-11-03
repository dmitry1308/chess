package ru.schepin.chess;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            new App(args[0]).run();
        } else {
            System.out.println("Path not found");
        }
    }
}
