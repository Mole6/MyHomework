package com.softeem.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String author;
    private Integer sales;
    private Integer stock;
    private String img_path;
}
