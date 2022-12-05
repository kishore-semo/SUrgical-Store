package com.kishore.semo_surgicals.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "buyer")
@Getter @Setter
public class Buyer {
    @Id
    @GeneratedValue( strategy= GenerationType.SEQUENCE )
    private Long buyerId;
    private String buyerName;
    private String buyerAddress;
    private String product;
    private Integer quantity;


}
