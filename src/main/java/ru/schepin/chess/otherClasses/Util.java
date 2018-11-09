package ru.schepin.chess.otherClasses;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
    public Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("figures.properties")) {
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
