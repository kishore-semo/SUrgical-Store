package com.kishore.semo_surgicals.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "stock")
@Getter
@Setter
public class Stock {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long stockId;
    private String name;
    private String description;
    private Integer quantity;
    private BigDecimal originalPrice;
    private BigDecimal salePrice;



}
