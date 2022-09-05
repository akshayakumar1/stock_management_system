package com.example.StockManagement.Repo;

import com.example.StockManagement.Entity.Segment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;

public interface SegmentRepo extends JpaRepository<Segment,Integer> {


}
