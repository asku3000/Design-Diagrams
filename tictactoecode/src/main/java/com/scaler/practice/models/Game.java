package com.scaler.practice.models;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Game {

    private Board board;

    private List<Player> players = new ArrayList<>();

    public static Game createGame(List<Player> players, int rows, int columns){
        Board board = new Board(rows, columns);
        Game game = new Game(board, players);
        return game;
    }

    public void makeMove(Player incPlayer, int row, int column){

        //find the relevant player
        //Delegate the make move method
        incPlayer.play(board);
    }
}
