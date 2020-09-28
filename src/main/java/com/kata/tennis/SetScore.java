package com.kata.tennis;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SetScore {
    private Integer player1Points;
    private Integer player2Points;

    public static SetScore newSet(){
        return SetScore.builder().player1Points(0).player2Points(0).build();
    }

    public void player1ScorePoint(){
        this.player1Points++;
    }

    public void player2ScorePoint(){
        this.player2Points++;
    }
}
