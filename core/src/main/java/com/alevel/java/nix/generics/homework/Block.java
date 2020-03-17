package com.alevel.java.nix.generics.homework;

@FunctionalInterface
public interface Block <T>{
    T run() throws Exception;
}
