package com.lamdayne.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Order {
    private Long orderID;
    private Long userID;
    private Double totalAmount;
    private String status;
    private Long createBy;
    private Date createAt;
}
