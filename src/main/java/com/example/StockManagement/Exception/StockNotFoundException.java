package com.example.StockManagement.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockNotFoundException extends RuntimeException{

    private int id;

    private String message;
}
