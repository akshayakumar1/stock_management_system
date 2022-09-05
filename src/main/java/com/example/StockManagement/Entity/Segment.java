package com.example.StockManagement.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is mandatory")
    private String exchangeName;

    @NotBlank(message = "Start time is mandatory")
    private LocalTime startTime;

    @NotBlank(message = "End time is mandatory")
    private LocalTime endTime;

    @NotBlank(message = "Working days are  mandatory")
    private String workingDays;
}
