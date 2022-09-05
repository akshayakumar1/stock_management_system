package com.example.StockManagement.Service;

import com.example.StockManagement.Entity.Exchange;
import com.example.StockManagement.Exception.StockNotFoundException;
import com.example.StockManagement.Repo.ExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {

    @Autowired
    private ExchangeRepo exchangeRepo;

    public Exchange createExchange(Exchange exchange){
        return exchangeRepo.save(exchange);
    }

    public Exchange updateExchange(int id, Exchange ex){
       Exchange exchange= exchangeRepo.findById(id).orElse(null);

        if(exchange == null){
            throw new StockNotFoundException(id,"Exchange not found");
        }
        exchange=ex;
        return exchangeRepo.save(exchange);
    }

    public Exchange deleteExchange(int id){
        Exchange exchange=exchangeRepo.findById(id).orElse(null);
        if(exchange == null){
            throw  new StockNotFoundException(id,"Exchange not found");
        }
        exchangeRepo.delete(exchange);
        return exchange;
    }

}
