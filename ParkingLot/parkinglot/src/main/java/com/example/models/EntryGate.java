package com.example.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class EntryGate extends Gate {
    private DisplayBoard displayBoard;
}