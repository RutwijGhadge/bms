package com.example.bms.models;

import com.example.bms.models.constants.MethodOfPayment;
import com.example.bms.models.constants.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class Payment extends BaseModel{
    @Enumerated(EnumType.STRING)
    private MethodOfPayment methodOfPayment;

    private Double Amount;
    private String referenceId;
    private LocalDateTime timeOfPayment;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @ManyToOne
    private Ticket ticket;

    @OneToMany
    private List<Transaction> transactionList;
}
/*
Ticket      Payment
1              M           //Not supporting Partial Payment but there can be failedPayments as well
1              1
Payment : Ticket   -> ManyToOne


Payment         Transaction
1                  M
1                  1
Payment : Transaction -> One to Many
 */