package com.alevel.java.nix.gallows.model;

import com.alevel.java.nix.gallows.view.TurnResultView;

import java.io.IOException;

public interface GallowInt {

    void reset() throws IOException;
    TurnResultView symbol(char s);
    TurnResultView view();
}
