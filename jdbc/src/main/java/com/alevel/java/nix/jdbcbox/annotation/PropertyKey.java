package com.alevel.java.nix.jdbcbox.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Properties;

/*Реализовать класс AppProperties, хранящий в себе свойства программы
 (имена свойств придумать, это должны быть публичные поля.
  Те из полей, которые помечены аннотацией @PropertyKey (ее необходимо создать)
   - инициализировать из файла со свойствами app.properties, лежащего в текущей папке.
    Конкретное свойство выбрать из параметра value аннотации.
Пример:

@PropertyKey(“connections.limit”)
public int maxConnections;
В app.properties:
connections.limit=64*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertyKey {
    String name();
    int limit();
}
