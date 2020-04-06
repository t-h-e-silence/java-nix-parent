package com.alevel.java.nix.gallows;

import com.alevel.java.nix.gallows.controller.GameLoop;
import com.alevel.java.nix.gallows.model.Gallow;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        var gameLoop = new GameLoop(System.in, System.out, new Gallow());
        gameLoop.loop();
         /*var gameLoop = new GameLoop(System.in, System.out, new GallowInt());
        gameLoop.loop();*/
    }
}