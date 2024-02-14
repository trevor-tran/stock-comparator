package com.trevortran.stockcomparator.controller;

import com.trevortran.stockcomparator.model.Stock;
import com.trevortran.stockcomparator.model.StockKey;
import com.trevortran.stockcomparator.model.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StockController {
    private final Logger log = LoggerFactory.getLogger(StockController.class);
    private final StockRepository stockRepository;

    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @GetMapping("/stock/{symbol}")
    public ResponseEntity<Stock> getStock(@PathVariable String symbol, @RequestParam LocalDate date) {
        StockKey id = new StockKey(symbol, date);
        Optional<Stock> stock = stockRepository.findById(id);
        return stock.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}