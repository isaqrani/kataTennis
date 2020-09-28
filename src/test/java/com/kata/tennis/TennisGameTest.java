package com.kata.tennis;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisGameTest {

    @Test
    public void should_start_new_match_between_tow_new_players() {
        TennisGame game = new TennisGame("Ilyas", "Nada");

        assertThat(game.getMachStatus()).isEqualTo("In progress");
        assertThat(game.getPlayer1()).isEqualTo("Ilyas");
        assertThat(game.getPlayer2()).isEqualTo("Nada");
    }

    @Test
    public void new_match_current_game_status_should_be_0_0() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        assertThat(game.getCurrentGameStatus()).isEqualTo("0-0");
    }

    @Test
    public void score_of_new_match_should_be_0_0() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        assertThat(game.getScore()).isEqualTo("(0-0)");
    }

    @Test
    public void current_game_status_score_should_increase_when_to_15_player1_score_new_point()  {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player1ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("15-0");
    }

    @Test
    public void current_game_status_should_increase_to_15_when_player2_score_new_point() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player2ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("0-15");
    }

    @Test
    public void current_game_status_should_increase_to_30_when_player1_score_2_points() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player1ScorePoint();
        game.player1ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("30-0");
    }

    @Test
    public void current_game_status_should_increase_to_30_when_player2_score_2_points() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player2ScorePoint();
        game.player2ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("0-30");
    }

    @Test
    public void current_game_status_should_be_15_30_when_player1_score_one_point_and_player2_score_two_points() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player2ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("15-30");
    }

    @Test
    public void current_game_status_should_be_40_30_when_player1_score_three_points_and_player2_score_two_points() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player2ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player1ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("40-30");
    }

    @Test
    public void current_game_status_should_be_deuce_if_both_players_have_40() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("Deuce");
    }

    @Test
    public void current_game_status_should_be_advantage_if_player1_score_point_on_40_40() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("Deuce");
        game.player1ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("Advantage");
    }

    @Test
    public void current_game_status_should_be_advantage_if_player2_score_point_on_40_40() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("Deuce");
        game.player2ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("Advantage");
    }

    @Test
    public void current_game_status_should_be_deuce_if_player2_score_point_on_player1_advantage() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("Deuce");
        game.player1ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("Advantage");
        game.player2ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("Deuce");
    }

    @Test
    public void current_game_status_should_be_deuce_if_player1_score_point_on_player2_advantage() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("Deuce");
        game.player2ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("Advantage");
        game.player1ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("Deuce");
    }

    @Test
    public void player1_win_the_game_when_he_score_one_point_after_his_advantage() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("Deuce");
        game.player1ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("Advantage");
        game.player1ScorePoint();
        assertThat(game.getScore()).isEqualTo("(1-0)");
    }

    @Test
    public void player2_win_the_game_when_he_score_one_point_after_his_advantage() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("Deuce");
        game.player2ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("Advantage");
        game.player2ScorePoint();
        assertThat(game.getScore()).isEqualTo("(0-1)");
    }

    @Test
    public void player1_win_the_game_when_he_score_one_point_after_40() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player1ScorePoint();
        assertThat(game.getScore()).isEqualTo("(1-0)");
    }

    @Test
    public void player2_win_the_game_when_he_score_one_point_after_40() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        assertThat(game.getScore()).isEqualTo("(0-1)");
    }

    @Test
    public void current_game_status_should_be_rest_when_player2_won_a_game() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        assertThat(game.getScore()).isEqualTo("(0-1)");
        assertThat(game.getCurrentGameStatus()).isEqualTo("0-0");
    }

    @Test
    public void current_game_status_should_be_rest_when_player1_won_a_game() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player2ScorePoint();
        game.player2ScorePoint();
        player1WinAGame(game);
        assertThat(game.getScore()).isEqualTo("(1-0)");
        assertThat(game.getCurrentGameStatus()).isEqualTo("0-0");
    }

    @Test
    public void score_should_increase_when_player_win_a_new_game() {
        TennisGame game = new TennisGame("Ilyas", "Nada");
        game.player2ScorePoint();
        game.player2ScorePoint();
        player1WinAGame(game);
        assertThat(game.getScore()).isEqualTo("(1-0)");
        game.player2ScorePoint();
        game.player2ScorePoint();
        player1WinAGame(game);
        assertThat(game.getScore()).isEqualTo("(2-0)");
        player2WinAGame(game);
        assertThat(game.getScore()).isEqualTo("(2-1)");
    }

    @Test
    public void first_player_score_6_game_and_exceeds_the_other_player_by_two_points_won_the_set_and_new_set_is_started(){
        TennisGame game = new TennisGame("Ilyas", "Nada");
        player1WinAGame(game);
        player1WinAGame(game);
        player1WinAGame(game);
        player2WinAGame(game);
        player1WinAGame(game);
        player2WinAGame(game);
        player1WinAGame(game);
        player1WinAGame(game);
        assertThat(game.getScore()).isEqualTo("(6-2)(0-0)");
        assertThat(game.getMachStatus()).isEqualTo("In progress");
    }

    @Test
    public void player1_score_7_and_the_other_player_with_5_game_win_the_set_and_new_set_is_started(){
        TennisGame game = new TennisGame("Ilyas", "Nada");
        player1WinAGame(game);
        player1WinAGame(game);
        player1WinAGame(game);
        player2WinAGame(game);
        player1WinAGame(game);
        player2WinAGame(game);
        player2WinAGame(game);
        player2WinAGame(game);
        player1WinAGame(game);
        player2WinAGame(game);
        player1WinAGame(game);
        player1WinAGame(game);
        assertThat(game.getScore()).isEqualTo("(7-5)(0-0)");
        assertThat(game.getMachStatus()).isEqualTo("In progress");
    }

    @Test
    public void player2_score_7_and_the_other_player_with_5_game_win_the_set_and_new_set_is_started(){
        TennisGame game = new TennisGame("Ilyas", "Nada");
        player1WinAGame(game);
        player1WinAGame(game);
        player1WinAGame(game);
        player2WinAGame(game);
        player2WinAGame(game);
        player2WinAGame(game);
        player2WinAGame(game);
        player2WinAGame(game);
        player1WinAGame(game);
        player1WinAGame(game);
        player2WinAGame(game);
        player2WinAGame(game);
        assertThat(game.getScore()).isEqualTo("(5-7)(0-0)");
        assertThat(game.getMachStatus()).isEqualTo("In progress");
    }

    @Test
    public void should_start_tie_break_session_if_both_have_six(){
        TennisGame game = new TennisGame("Ilyas", "Nada");
        both_players_have_six_game(game);
        assertThat(game.getScore()).isEqualTo("(6-6)");
        assertThat(game.getMachStatus()).isEqualTo("In progress - Tie-Break");
    }

    @Test
    public void game_score_should_increments_by_one_on_tie_break(){
        TennisGame game = new TennisGame("Ilyas", "Nada");
        both_players_have_six_game(game);
        assertThat(game.getScore()).isEqualTo("(6-6)");
        assertThat(game.getMachStatus()).isEqualTo("In progress - Tie-Break");
        game.player1ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("1-0");
        game.player1ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("2-0");
        game.player2ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("2-1");
    }

    @Test
    public void player1_win_the_tie_break_when_he_score_7_point_and_exceeds_the_other_player_by_two_points(){
        TennisGame game = new TennisGame("Ilyas", "Nada");
        both_players_have_six_game(game);
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player1ScorePoint();
        assertThat(game.getScore()).isEqualTo("(7-6)(0-0)");
        assertThat(game.getMachStatus()).isEqualTo("In progress");
    }

    @Test
    public void player2_win_the_tie_break_when_he_score_7_point_and_exceeds_the_other_player_by_two_points(){
        TennisGame game = new TennisGame("Ilyas", "Nada");
        both_players_have_six_game(game);
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        assertThat(game.getScore()).isEqualTo("(6-7)(0-0)");
        assertThat(game.getMachStatus()).isEqualTo("In progress");
    }

    @Test
    public void player1_win_the_set_if_he_tow_successive_point_when_both_players_have_six(){
        TennisGame game = new TennisGame("Ilyas", "Nada");
        both_players_have_six_game(game);
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player1ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("6-6");
        game.player1ScorePoint();
        game.player1ScorePoint();
        assertThat(game.getScore()).isEqualTo("(7-6)(0-0)");
        assertThat(game.getMachStatus()).isEqualTo("In progress");
    }

    @Test
    public void player2_win_the_set_if_he_tow_successive_point_when_both_players_have_six(){
        TennisGame game = new TennisGame("Ilyas", "Nada");
        both_players_have_six_game(game);
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player1ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player1ScorePoint();
        assertThat(game.getCurrentGameStatus()).isEqualTo("6-6");
        game.player2ScorePoint();
        game.player2ScorePoint();
        assertThat(game.getScore()).isEqualTo("(6-7)(0-0)");
        assertThat(game.getMachStatus()).isEqualTo("In progress");
    }

    @Test
    public void player1_win_the_match_if_he_win_three_set(){
        TennisGame game = new TennisGame("Ilyas", "Nada");
        player1WinASet(game);
        player1WinASet(game);
        player1WinASet(game);
        assertThat(game.getScore()).isEqualTo("(6-0)(6-0)(6-0)");
        assertThat(game.getMachStatus()).isEqualTo("Player 1 win");
    }

    @Test
    public void player2_win_the_match_if_he_win_three_set(){
        TennisGame game = new TennisGame("Ilyas", "Nada");
        player2WinASet(game);
        player1WinASet(game);
        player2WinASet(game);
        player2WinASet(game);
        assertThat(game.getScore()).isEqualTo("(0-6)(6-0)(0-6)(0-6)");
        assertThat(game.getMachStatus()).isEqualTo("Player 2 win");
    }

    @Test
    public void player2_win_the_match_if_he_win_three_set_and_player2_win_only_two_set(){
        TennisGame game = new TennisGame("Ilyas", "Nada");
        player2WinASet(game);
        player1WinASet(game);
        player1WinASet(game);
        player2WinASet(game);
        player1WinASet(game);
        assertThat(game.getScore()).isEqualTo("(0-6)(6-0)(6-0)(0-6)(6-0)");
        assertThat(game.getMachStatus()).isEqualTo("Player 1 win");
    }

    private void player1WinASet(TennisGame game) {
        player1WinAGame(game);
        player1WinAGame(game);
        player1WinAGame(game);
        player1WinAGame(game);
        player1WinAGame(game);
        player1WinAGame(game);
    }

    private void player2WinASet(TennisGame game) {
        player2WinAGame(game);
        player2WinAGame(game);
        player2WinAGame(game);
        player2WinAGame(game);
        player2WinAGame(game);
        player2WinAGame(game);
    }

    private void player1WinAGame(TennisGame game) {
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
        game.player1ScorePoint();
    }

    private void player2WinAGame(TennisGame game) {
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
        game.player2ScorePoint();
    }

    private void both_players_have_six_game(TennisGame game) {
        player1WinAGame(game);
        player1WinAGame(game);
        player1WinAGame(game);
        player2WinAGame(game);
        player1WinAGame(game);
        player2WinAGame(game);
        player2WinAGame(game);
        player2WinAGame(game);
        player1WinAGame(game);
        player2WinAGame(game);
        player1WinAGame(game);
        player2WinAGame(game);
    }
}
