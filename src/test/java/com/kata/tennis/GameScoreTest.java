package com.kata.tennis;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameScoreTest {

    @Test
    public void should_increment_player1_score(){
        GameScore gameScore = GameScore.newGame();

        gameScore.player1ScorePoint();

        assertThat(gameScore.getPlayer1CurrentScore()).isEqualTo(1);
        assertThat(gameScore.getCurrentGameStatus()).isEqualTo("15-0");
    }

    @Test
    public void should_increment_player2_score(){
        GameScore gameScore = GameScore.newGame();

        gameScore.player2ScorePoint();

        assertThat(gameScore.getPlayer2CurrentScore()).isEqualTo(1);
        assertThat(gameScore.getCurrentGameStatus()).isEqualTo("0-15");
    }

    @Test
    public void should_return_deuce_if_players_have_the_same_score(){
        GameScore gameScore = GameScore.newGame();

        gameScore.player2ScorePoint();
        gameScore.player2ScorePoint();
        gameScore.player2ScorePoint();
        gameScore.player1ScorePoint();
        gameScore.player1ScorePoint();
        gameScore.player1ScorePoint();

        assertThat(gameScore.getCurrentGameStatus()).isEqualTo("Deuce");
    }

    @Test
    public void should_return_advantage_if_player1_score_after_deuce(){
        GameScore gameScore = GameScore.newGame();

        gameScore.player2ScorePoint();
        gameScore.player2ScorePoint();
        gameScore.player2ScorePoint();
        gameScore.player1ScorePoint();
        gameScore.player1ScorePoint();
        gameScore.player1ScorePoint();
        gameScore.player1ScorePoint();

        assertThat(gameScore.getCurrentGameStatus()).isEqualTo("Advantage");
    }

    @Test
    public void should_start_tie_break_game(){
        GameScore gameScore = GameScore.newTieBreakGame();
        assertThat(gameScore.getTieBreakGame()).isTrue();
    }

    @Test
    public void should_increment_by_1_when_tie_break_game(){
        GameScore gameScore = GameScore.newTieBreakGame();

        gameScore.player1ScorePoint();
        gameScore.player2ScorePoint();

        assertThat(gameScore.getCurrentGameStatus()).isEqualTo("1-1");
    }
}