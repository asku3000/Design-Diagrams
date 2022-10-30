package com.scaler.practice.models;

import lombok.AllArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
public class Game {

    private Board board;

    private List<Player> players = new ArrayList<>();
}
