package com.micro.baseDomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String OrderId;
    private String name;
    private Integer quantity;
    private Double price;
}
