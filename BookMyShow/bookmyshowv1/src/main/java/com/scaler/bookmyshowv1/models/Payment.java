package com.scaler.bookmyshowv1.models;

import com.scaler.bookmyshowv1.enums.PaymentMode;
import com.scaler.bookmyshowv1.enums.PaymentStatus;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Getter
@Entity
public class Payment extends BaseModel {

    private String referenceId;

    private Double amount;

    @Enumerated
    private PaymentMode mode;

    @Enumerated
    private PaymentStatus status;

}
