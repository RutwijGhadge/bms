package com.example.bms.models;

import com.example.bms.models.constants.MethodOfPayment;
import com.example.bms.models.constants.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Payment extends BaseModel{
    @Enumerated(EnumType.STRING)
    private MethodOfPayment methodOfPayment;

    private Double Amount;
    private String referenceId;
    private LocalDateTime timeOfPayment;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @OneToMany
    private List<Transaction> transactionList;

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getTimeOfPayment() {
        return timeOfPayment;
    }

    public void setTimeOfPayment(LocalDateTime timeOfPayment) {
        this.timeOfPayment = timeOfPayment;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public MethodOfPayment getMethodOfPayment() {
        return methodOfPayment;
    }

    public void setMethodOfPayment(MethodOfPayment methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
    }
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