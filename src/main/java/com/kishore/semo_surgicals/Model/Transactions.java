package com.kishore.semo_surgicals.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transactions {
    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private Long transactionId;
    private Long customer;
    private Long stock;

    private Boolean paymentStatus;
    @Column(updatable = false)
    private Timestamp createdAt = Timestamp.from(Instant.now());
    @Column(insertable = false)
    private Timestamp updatedAt = Timestamp.from(Instant.now());

    private Integer quantity;
    private Double price;
}
