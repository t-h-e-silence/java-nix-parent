package com.alevel.java.nix.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class Group {
    private ArrayList<Student> contractGroup;
    private ContractStudent contractStudent;

    public Group() {
        contractGroup = new ArrayList<>();
        contractStudent = new ContractStudent();
    }

    public ArrayList<Student> getContractGroup() {
        return contractGroup;
    }

    public void add(Student student) {
        if (student != null) {
            if (student instanceof ContractStudent) {
                var contractStudent = (ContractStudent) student;
                contractGroup.add(contractStudent);
            }
        }
    }

    @Override
    public String toString() {
        return "Contract Students=" + contractGroup;
    }

}


