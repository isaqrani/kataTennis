package com.kata.tennis;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Builder
@Getter
public class GameScore {
    private Integer player1CurrentScore;
    private Integer player2CurrentScore;
    private final Boolean tieBreakGame;

    private static final Map<Integer, String> gameScoreSequence = new HashMap<Integer, String>() {{
        put(0, "0");
        put(1, "15");
        put(2, "30");
        put(3, "40");
    }};

    public static GameScore newGame() {
        return GameScore.builder()
                .player1CurrentScore(0)
                .player2CurrentScore(0)
                .tieBreakGame(false)
                .build();
    }

    public static GameScore newTieBreakGame() {
        return GameScore.builder()
                .player1CurrentScore(0)
                .player2CurrentScore(0)
                .tieBreakGame(true)
                .build();
    }

    public void player1ScorePoint() {
        this.player1CurrentScore++;
    }

    public void player2ScorePoint() {
        this.player2CurrentScore++;
    }

    public String getCurrentGameStatus() {
        if(!this.tieBreakGame){
            if (this.player1CurrentScore >= 3 && this.player1CurrentScore.equals(this.player2CurrentScore)) {
                return "Deuce";
            } else if ((this.player1CurrentScore > 3 && this.player1CurrentScore.equals(this.player2CurrentScore + 1))
                    || (this.player2CurrentScore > 3 && this.player2CurrentScore.equals(this.player1CurrentScore + 1))) {
                return "Advantage";
            }
            return gameScoreSequence.get(this.player1CurrentScore) + "-"
                    + gameScoreSequence.get(this.player2CurrentScore);
        }
        return this.player1CurrentScore + "-" + this.player2CurrentScore;
    }
}
