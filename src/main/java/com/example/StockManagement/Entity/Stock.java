package com.example.StockManagement.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "symbol is mandatory")
    private String symbol;

    @NotBlank(message = "Industry name is mandatory")
    private String industry;

    @NotBlank(message = "Segment name is mandatory")
    private String segment;

    @NotBlank(message = "Exchange name is mandatory")
    private String exchange;

    @NotBlank(message = "Type is mandatory")
    private String type;

    private float currentPrice;

    private LocalDate expiryDate;

    private int lotSize;


}
