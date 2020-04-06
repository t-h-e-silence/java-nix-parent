package com.alevel.java.nix.gallows.controller;

import com.alevel.java.nix.gallows.model.GallowInt;
import com.alevel.java.nix.gallows.model.TurnResult;
import com.alevel.java.nix.gallows.view.TurnResultView;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GameLoop {

    private final InputStream input;
    private final PrintStream output;
    private final GallowInt model;

    public GameLoop(InputStream input, PrintStream output, GallowInt model) {
        this.input = input;
        this.output = output;
        this.model = model;
    }

    public void loop() throws IOException {
        output.println("Game started");
        model.view().print(output);
        var scanner = new Scanner(input);

        TurnResult turn;
        do {
            output.println("Пожалуйста, введите букву: ");
            char s = scanner.next().charAt(0);
            TurnResultView resultView = model.symbol(s);
            turn = resultView.result();
            resultView.print(output);
        } while (turn == TurnResult.CONTINUE);

        output.println("Game over, " + turn.displayName());
        model.reset();
    }
}

