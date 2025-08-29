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
public class Shipping {
    private Long shippingID;
    private Long orderID;
    private String address;
    private String phoneReceive;
    private String receiverName;
    private String shippingStatus;
    private Date shippingDate;
}
