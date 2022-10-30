package com.scaler.practice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {

    private String name;

    private String email;

    private Byte[] photo;
}
