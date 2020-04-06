package com.alevel.java.nix.gallows.view;

import com.alevel.java.nix.gallows.model.TurnResult;

import java.io.PrintStream;

public final class TurnResultView {

    private final TurnResult result;

    private final String view;

    public TurnResultView(TurnResult result, String view) {
        this.result = result;
        this.view = view;
    }

    public TurnResult result() {
        return result;
    }

    public String view() {
        return view;
    }

    public void print(PrintStream target) {
        target.println(view);
    }

    @Override
    public String toString() {
        return view;
    }
}