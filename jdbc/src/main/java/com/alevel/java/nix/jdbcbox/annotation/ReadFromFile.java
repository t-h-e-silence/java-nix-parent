package com.alevel.java.nix.jdbcbox.annotation;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class ReadFromFile {
    private static FileInputStream fis;
    private static Properties properties = new Properties();
    private static String nameOfFile = "C://alevel-java-nix//jdbc//src//main//java//com//alevel//java//nix//jdbcbox//annotation//app.properties";

    public static Object getPropertyFromFile(Field nameOfField) {
        Object prop = null;
        try {
            fis = new FileInputStream(nameOfFile);
            properties.load(fis);
            if (nameOfField.getType() == String.class) {
                return properties.getProperty(nameOfField.getName());
            }
            if (nameOfField.getType() == int.class) {
                return Integer.parseInt(properties.getProperty(nameOfField.getName()));
            }
            if (nameOfField.getType() == double.class) {
                return Double.parseDouble(properties.getProperty(nameOfField.getName()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

}
