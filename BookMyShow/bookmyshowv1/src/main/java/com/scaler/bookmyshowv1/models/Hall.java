package com.scaler.bookmyshowv1.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Hall extends BaseModel {

    private Integer hallNumber;

    @OneToMany
    private List<Seat> seats = new ArrayList<>();

}