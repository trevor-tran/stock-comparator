package com.trevortran.stockcomparator.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Embeddable
public class StockKey implements Serializable {
    @NonNull
    private String symbol;
    @NonNull
    private LocalDate date;
}