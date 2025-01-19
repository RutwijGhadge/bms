package com.example.bms.models;

import com.example.bms.models.constants.TransactionStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Transaction extends BaseModel{
    private double transactionAmount;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
}
