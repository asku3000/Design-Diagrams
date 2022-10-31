package com.scaler.practice.models;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@SuperBuilder
public abstract class Player {

    private Symbol symbol;

    public abstract BoardCell play(Board board);
}
