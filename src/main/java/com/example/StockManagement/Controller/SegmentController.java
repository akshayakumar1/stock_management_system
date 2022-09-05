package com.example.StockManagement.Controller;

import com.example.StockManagement.Entity.Segment;
import com.example.StockManagement.Service.SegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/segment")
public class SegmentController {

    @Autowired
    private SegmentService segmentService;

    @PostMapping("/save")
    public ResponseEntity<Segment> create(@RequestBody @Valid Segment segment){
        return new ResponseEntity<Segment>(segmentService.createSegment(segment), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Segment> updateSegment(@PathVariable int id, @RequestBody @Valid Segment segment){
        return new ResponseEntity<Segment>(segmentService.updateSegment(id,segment),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Segment> deleteSegment(@PathVariable int id){
        return new ResponseEntity<Segment>(segmentService.deleteSegment(id),HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Boolean> getSegmentStatus(@PathVariable int id){
        return new ResponseEntity<Boolean>(segmentService.getSegmentStatus(id),HttpStatus.OK);
    }
}
