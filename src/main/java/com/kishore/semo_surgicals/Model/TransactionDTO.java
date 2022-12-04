package com.kishore.semo_surgicals.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDTO {

    private String customerName;
    private String stockName;
    private Integer quantity;
    private Double price;
    private String paymentStatus;

}
