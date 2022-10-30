package com.scaler.practice.models;

import lombok.Getter;

@Getter
public class BotPlayer extends Player{

    private BotLevel level;

    public BotPlayer(Symbol symbol, BotLevel level){
        super(symbol);
        this.level = level;
    }


    @Override
    public BoardCell play(Board board) {
        return null;
    }
}
