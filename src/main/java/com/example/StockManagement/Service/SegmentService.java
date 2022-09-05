package com.example.StockManagement.Service;

import com.example.StockManagement.Entity.Exchange;
import com.example.StockManagement.Entity.Segment;
import com.example.StockManagement.Exception.StockNotFoundException;
import com.example.StockManagement.Repo.SegmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

@Service
public class SegmentService {

    @Autowired
    private SegmentRepo segmentRepo;

    public Segment createSegment(Segment segment){
        return segmentRepo.save(segment);
    }

    public Segment updateSegment(int id, Segment se){
        Segment segment= segmentRepo.findById(id).orElse(null);

        if(segment == null){
            throw new StockNotFoundException(id,"Segment not found");
        }
        segment=se;
        return segmentRepo.save(segment);
    }

    public Segment deleteSegment(int id){
        Segment segment=segmentRepo.findById(id).orElse(null);
        if(segment == null){
            throw  new StockNotFoundException(id,"Segment not found");
        }
        segmentRepo.delete(segment);
        return segment;
    }

    public boolean getSegmentStatus(int id){

        Segment segment=segmentRepo.findById(id).orElse(null);

        if(segment == null){
            throw new StockNotFoundException(id,"Segment Not found");
        }
        LocalTime startTime=segment.getStartTime();
        LocalTime endTime=segment.getEndTime();
        String workingDays=segment.getWorkingDays();
        LocalTime todayDate=LocalTime.now();
        if(workingDays.equalsIgnoreCase("YYYYYNN") && DayOfWeek.of(todayDate.get(ChronoField.DAY_OF_WEEK)) != DayOfWeek.SUNDAY && DayOfWeek.of(todayDate.get(ChronoField.DAY_OF_WEEK)) != DayOfWeek.SATURDAY){
            LocalTime currentTime=LocalTime.now();
            if(currentTime.compareTo(startTime) > 0 && currentTime.compareTo(endTime) < 0){
                return true;
            }
        }
        else if(workingDays.equalsIgnoreCase("NNNNNYY") && DayOfWeek.of(todayDate.get(ChronoField.DAY_OF_WEEK)) == DayOfWeek.SUNDAY && DayOfWeek.of(todayDate.get(ChronoField.DAY_OF_WEEK)) == DayOfWeek.SATURDAY){
            LocalTime currentTime=LocalTime.now();
            if(currentTime.compareTo(startTime) > 0 && currentTime.compareTo(endTime) < 0){
                return true;
            }
        }

        return false;
    }
}
