package com.example.StockManagement.Service;

import com.example.StockManagement.Entity.Stock;
import com.example.StockManagement.Exception.StockNotFoundException;
import com.example.StockManagement.Repo.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepo stockRepo;

    public Stock createStock(Stock stock){
        return stockRepo.save(stock);
    }

    public Stock updateStock(int id,Stock st){
        Stock stock= stockRepo.findById(id).orElse(null);

        if(stock == null){
            throw new StockNotFoundException(id,"Stock not found");
        }
        stock=st;
        return stockRepo.save(stock);
    }

    public Stock deleteStock(int id){
        Stock stock=stockRepo.findById(id).orElse(null);
        if(stock == null){
            throw  new StockNotFoundException(id,"Stock not found");
        }
        stockRepo.delete(stock);
        return stock;
    }

    public List<Stock> searchStock(String searchedContent){
        List<Stock> stock=stockRepo.searchedStock(searchedContent);
        return stock;
    }

//    public List<Stock> filterStock(String filterData){
//        List<Stock> stock=new ArrayList<>();
//        if(filterData.equalsIgnoreCase("segment")){
//            stock= stockRepo.findBySegment();
//        }
//        else if(filterData.equalsIgnoreCase("exchange")){
//            stock= stockRepo.findByExchange();
//        }
//        else if(filterData.equalsIgnoreCase("type")){
//            stock= stockRepo.findByType();
//        }
//        return stock;
//    }


}
