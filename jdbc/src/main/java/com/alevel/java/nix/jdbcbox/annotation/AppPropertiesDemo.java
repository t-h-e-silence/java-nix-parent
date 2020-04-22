package com.alevel.java.nix.jdbcbox.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

import static com.alevel.java.nix.jdbcbox.annotation.ReadFromFile.getPropertyFromFile;

public class AppPropertiesDemo {
    static void inspect(Object o, Class<?> classOfInstance) throws NoSuchFieldException, IllegalAccessException {
        Field[] fields = classOfInstance.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(PropertyKey.class)) {
                classOfInstance.getField(f.getName()).set(o, getPropertyFromFile(f));
            }
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        AppProperties inctance = new AppProperties();
        Class<? extends AppProperties> classOfInctance = inctance.getClass();
        inspect(inctance, classOfInctance);
        System.out.println(inctance.name);
        System.out.println(inctance.limit);
        System.out.println(inctance.users);
    }
}