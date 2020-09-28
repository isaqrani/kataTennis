package com.kata.tennis;

public enum MatchStatus {
    IN_PROGRESS("In progress"),
    PLAYER1_WIN("Player 1 win"),
    PLAYER2_WIN("Player 2 win"),
    IN_PROGRESS_TIE_BREAK("In progress - Tie-Break");
    private final String text;

    MatchStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
