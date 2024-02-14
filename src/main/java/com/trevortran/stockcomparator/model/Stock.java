package com.trevortran.stockcomparator.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public final class Stock implements Serializable {
    @EmbeddedId
    private StockKey id;
    @NonNull
    private double endOfDayPrice;
    private double split;
    private double dividend;
}