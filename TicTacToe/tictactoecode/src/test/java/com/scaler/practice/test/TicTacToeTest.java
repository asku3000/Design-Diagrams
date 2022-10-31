package com.scaler.practice.test;

import com.scaler.practice.models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

    private Game game;

    @BeforeEach
    public void setUp(){
        this.game = createGame();
    }

    private Game createGame() {
        Player human = HumanPlayer.builder()
                .symbol(Symbol.O)
                .user(new User("Paul Morphy", "morphy@gmail.com", new Byte[]{}))
                .build();
        Player bot = new BotPlayer(Symbol.X, BotLevel.EASY);
        return Game.createGame(Arrays.asList(human, bot), 3, 3);
    }

    @Test
    public void testDimensions(){
        List<List<BoardCell>> cells = game.getBoard().getCells();
        assertEquals(3,cells.size(),"Rows should be equal" );

        assertEquals(3,cells.get(0).size(),"Columns should be equal" );
    }


}
