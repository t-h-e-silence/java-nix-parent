package com.alevel.java.nix.oop;

public class Student {
    String name;
    int age;

    Student() {
        this.name = "String is empty";
        this.age = 0;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;

    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student name: " + name + " age: " + age;
    }
}