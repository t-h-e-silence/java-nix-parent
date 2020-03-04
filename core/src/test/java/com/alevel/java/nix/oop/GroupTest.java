package com.alevel.java.nix.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    @Test
    void getContractGroup() {
        Group g = new Group();
        Student s = new Student("Tony Stark", 19);
        Student s1 = new ContractStudent("Bruce Wayne", 21, 780.0);
        Student s2 = new Student("Jack Sparrow", 22);
        Student s3 = new ContractStudent("Smaug", 20, 1000.0);
        g.add(s);
        g.add(s1);
        g.add(s3);
        g.add(s2);
        String expected = "Contract Students=[Student name: Bruce Wayne age: 21 cost: 780.0, Student name: Smaug age: 20 cost: 1000.0]";
        assertEquals(expected, g.toString());
    }
}