package com.kata.tennis;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {
    @Getter
    private final String player1;
    @Getter
    private final String player2;
    private final Map<Integer, SetScore> sets;
    private Integer currentSet;
    private GameScore currentGame;
    private MatchStatus matchStatus;

    public TennisGame(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;

        this.sets = new HashMap<>();
        this.currentSet = 1;
        this.sets.put(this.currentSet, SetScore.newSet());

        this.currentGame = GameScore.newGame();
        this.matchStatus = MatchStatus.IN_PROGRESS;
    }

    public String getMachStatus() {
        return this.matchStatus.getText();
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        for (Integer set : this.sets.keySet()) {
            score.append("(")
                    .append(this.sets.get(set).getPlayer1Points())
                    .append("-")
                    .append(this.sets.get(set).getPlayer2Points())
                    .append(")");
        }
        return score.toString();
    }

    public String getCurrentGameStatus() {
        return this.currentGame.getCurrentGameStatus();
    }

    public void player1ScorePoint() {
        this.currentGame.player1ScorePoint();
        updateGameScore();
    }

    public void player2ScorePoint() {
        this.currentGame.player2ScorePoint();
        updateGameScore();
    }

    private void updateGameScore() {
        SetScore setScore = this.sets.get(currentSet);
        if (this.currentGame.getTieBreakGame()) {
            if (this.currentGame.getPlayer1CurrentScore() >= 7 && this.currentGame.getPlayer1CurrentScore() >= this.currentGame.getPlayer2CurrentScore() + 2) {
                setScore.player1ScorePoint();
                startNewSet();
            }
            if (this.currentGame.getPlayer2CurrentScore() >= 7 && this.currentGame.getPlayer2CurrentScore() >= this.currentGame.getPlayer1CurrentScore() + 2) {
                setScore.player2ScorePoint();
                startNewSet();
            }

        }
        if (!this.currentGame.getTieBreakGame() && this.currentGame.getPlayer1CurrentScore() > 3 && this.currentGame.getPlayer1CurrentScore() >= this.currentGame.getPlayer2CurrentScore() + 2) {
            setScore.player1ScorePoint();
            if (setScore.getPlayer1Points() >= 6 && setScore.getPlayer1Points() > setScore.getPlayer2Points() + 1) {
                startNewSet();
            }
            resetGameScore();
        }
        if (!this.currentGame.getTieBreakGame() && this.currentGame.getPlayer2CurrentScore() > 3 && this.currentGame.getPlayer2CurrentScore() >= this.currentGame.getPlayer1CurrentScore() + 2) {
            setScore.player2ScorePoint();
            if (setScore.getPlayer2Points() >= 6 && setScore.getPlayer2Points() > setScore.getPlayer1Points() + 1) {
                startNewSet();
            }
            resetGameScore();
        }
        if (!this.currentGame.getTieBreakGame() && this.sets.get(currentSet).getPlayer1Points().equals(6)
                && this.sets.get(currentSet).getPlayer2Points().equals(6)) {
            startTieBreakGame();
        }
    }

    private void startNewSet() {
        if (this.sets.entrySet().stream().filter(set -> set.getValue().getPlayer1Points() > set.getValue().getPlayer2Points()).count() == 3) {
            this.matchStatus = MatchStatus.PLAYER1_WIN;
        } else if (this.sets.entrySet().stream().filter(set -> set.getValue().getPlayer1Points() < set.getValue().getPlayer2Points()).count() == 3) {
            this.matchStatus = MatchStatus.PLAYER2_WIN;
        } else {
            this.currentSet++;
            this.sets.put(this.currentSet, SetScore.newSet());
            resetGameScore();
        }
    }

    private void resetGameScore() {
        if (this.matchStatus.equals(MatchStatus.IN_PROGRESS_TIE_BREAK)) {
            this.matchStatus = MatchStatus.IN_PROGRESS;
        }
        this.currentGame = GameScore.newGame();
    }

    private void startTieBreakGame() {
        this.matchStatus = MatchStatus.IN_PROGRESS_TIE_BREAK;
        this.currentGame = GameScore.newTieBreakGame();
    }
}
