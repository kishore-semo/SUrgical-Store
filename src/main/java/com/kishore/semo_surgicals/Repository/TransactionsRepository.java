package com.kishore.semo_surgicals.Repository;

import com.kishore.semo_surgicals.Model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

}