package com.kishore.semo_surgicals.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long customerId;
    private String customerName;
    private String customerPhoneNumber;
    private String address;

    @Transient
    private String paymentStatus;

}
