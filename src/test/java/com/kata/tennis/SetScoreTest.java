package com.kata.tennis;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SetScoreTest{

    @Test
    public void should_increment_player1_set_score(){
        SetScore setScore = SetScore.newSet();
        setScore.player1ScorePoint();
        assertThat(setScore.getPlayer1Points()).isEqualTo(1);
        assertThat(setScore.getPlayer2Points()).isEqualTo(0);
    }

    @Test
    public void should_increment_player2_set_score(){
        SetScore setScore = SetScore.newSet();
        setScore.player2ScorePoint();
        assertThat(setScore.getPlayer2Points()).isEqualTo(1);
        assertThat(setScore.getPlayer1Points()).isEqualTo(0);
    }

}