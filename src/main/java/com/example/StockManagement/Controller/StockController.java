package com.example.StockManagement.Controller;

import com.example.StockManagement.Entity.Stock;
import com.example.StockManagement.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/save")
    public ResponseEntity<Stock> create(@RequestBody @Valid Stock stock){
        return new ResponseEntity<Stock>(stockService.createStock(stock), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable int id,@RequestBody @Valid Stock stock){
        return new ResponseEntity<Stock>(stockService.updateStock(id,stock),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Stock> deleteStock(@PathVariable int id){
        return new ResponseEntity<Stock>(stockService.deleteStock(id),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Stock>> searchStock(@RequestParam String query){
        return new ResponseEntity<>(stockService.searchStock(query),HttpStatus.OK);
    }

}
