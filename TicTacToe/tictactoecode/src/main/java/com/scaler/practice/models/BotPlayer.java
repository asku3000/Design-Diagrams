package com.scaler.practice.models;

import com.scaler.practice.strategies.PlayingStrategy;
import lombok.Getter;

@Getter
public class BotPlayer extends Player{

    private BotLevel level;

    private PlayingStrategy playingStrategy;

    public BotPlayer(Symbol symbol, BotLevel level){
        super(symbol);
        this.level = level;
    }


    @Override
    public BoardCell play(Board board) {
        return null;
    }
}
