package com.scaler.bookmyshowv1.models;

import com.scaler.bookmyshowv1.enums.TicketStatus;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Ticket extends BaseModel {

    @ManyToOne
    private Show show;

    @ManyToOne
    private User user;

    @ManyToMany
    // 1 ticket can have multiple seats
    //can 1 seat be a part of multiple tickets ?
    // Ticket 1- Seat : 1, 2, 3 //no 2 is cancelles
    // Then another can book it Ticket 2: seat: 2
    //Therefore if cancellation is present then manytomany
    private List<ShowSeat> seats = new ArrayList<>();

    private Double amount;

    @Enumerated
    private TicketStatus status;

    //payment can fail :- OneToMany
    //now we don't have a list so we have taken 1:1
    @OneToOne
    private Payment payment;

}