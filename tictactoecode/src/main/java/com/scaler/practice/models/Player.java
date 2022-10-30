package com.scaler.practice.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Player {

    private Symbol symbol;

    public abstract BoardCell play(Board board);
}
