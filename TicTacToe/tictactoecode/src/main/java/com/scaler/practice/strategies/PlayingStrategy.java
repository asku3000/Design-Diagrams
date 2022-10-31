package com.scaler.practice.strategies;

import com.scaler.practice.models.Board;
import com.scaler.practice.models.BoardCell;

public interface PlayingStrategy {

    public BoardCell play(Board board);
}
