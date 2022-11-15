package com.scaler.bookmyshowv1.models;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "users")
public class User extends BaseModel {
    private String email;

}
