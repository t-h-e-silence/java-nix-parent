package com.alevel.java.nix.oop;

public class ContractStudent extends Student {
    private double cost;

    ContractStudent() {
        super();
        cost = 0.0;
    }

    ContractStudent(String name, int age, double cost) {
        super(name, age);
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    private void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Student name: " + getName() + " age: " + getAge() + " cost: " + getCost();
    }

}