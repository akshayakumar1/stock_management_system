package com.example.StockManagement.Repo;

import com.example.StockManagement.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepo extends JpaRepository<Stock,Integer> {

    @Query("select s from Stock s where "+"s.segment like concat('%',:query,'%')"
            +"or s.exchange like concat('%',:query,'%')"
            +"or s.type like concat('%',:query,'%')")
    public List<Stock> searchedStock(String query);


}
