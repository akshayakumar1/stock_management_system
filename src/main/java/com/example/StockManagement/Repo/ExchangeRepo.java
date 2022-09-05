package com.example.StockManagement.Repo;

import com.example.StockManagement.Entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepo extends JpaRepository<Exchange,Integer> {
}
