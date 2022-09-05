package com.example.StockManagement.Controller;

import com.example.StockManagement.Entity.Exchange;
import com.example.StockManagement.Entity.Stock;
import com.example.StockManagement.Service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/exchange")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @PostMapping("/save")
    public ResponseEntity<Exchange> create(@RequestBody @Valid Exchange exchange){
        return new ResponseEntity<Exchange>(exchangeService.createExchange(exchange), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Exchange> updateExchange(@PathVariable int id, @RequestBody @Valid Exchange exchange){
        return new ResponseEntity<Exchange>(exchangeService.updateExchange(id,exchange),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Exchange> deleteExchange(@PathVariable int id){
        return new ResponseEntity<Exchange>(exchangeService.deleteExchange(id),HttpStatus.OK);
    }
}
