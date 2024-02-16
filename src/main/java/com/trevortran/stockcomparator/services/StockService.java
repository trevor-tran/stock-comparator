package com.trevortran.stockcomparator.services;

import com.trevortran.stockcomparator.model.Stock;

import java.time.LocalDate;
import java.util.List;

public interface StockService {
    List<Stock> request(String symbol);
    Stock request(String symbol, LocalDate date);
    List<Stock> request(String symbol, LocalDate start, LocalDate end);
}