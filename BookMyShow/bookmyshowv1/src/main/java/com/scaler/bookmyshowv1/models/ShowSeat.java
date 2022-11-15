package com.scaler.bookmyshowv1.models;

import com.scaler.bookmyshowv1.enums.SeatStatus;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Getter
@Entity
public class ShowSeat extends BaseModel {

    private Double price;

    @Enumerated
    private SeatStatus status;

    @ManyToOne
    private Seat seat;

}
