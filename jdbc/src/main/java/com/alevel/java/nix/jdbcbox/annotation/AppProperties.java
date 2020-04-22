package com.alevel.java.nix.jdbcbox.annotation;

public class AppProperties {
    @PropertyKey(name = "name", limit = 0)
    public String name;
    @PropertyKey(name="name", limit=0)
    public int limit;
    public int users;
}

