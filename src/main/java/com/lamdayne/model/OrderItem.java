package com.lamdayne.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderItem {
    private Long orderItemID;
    private Long orderID;
    private Long bookID;
    private Long quantity;
    private Double price;
}
