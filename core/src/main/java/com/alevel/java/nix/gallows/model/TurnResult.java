package com.alevel.java.nix.gallows.model;
public enum TurnResult {
    CONTINUE("continue"),
    YOU_WON("you won"),
    YOU_LOSE("you lose");

    private final String displayName;

    TurnResult(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }
}
