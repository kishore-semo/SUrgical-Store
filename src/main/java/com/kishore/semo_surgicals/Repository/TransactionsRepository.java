package com.kishore.semo_surgicals.Repository;

import com.kishore.semo_surgicals.Model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

    @Query("SELECT CASE WHEN (count (T) > 0)  then true else false end FROM Transactions T where T.customer=:customerId and T.paymentStatus = 'true'")
    Boolean existsByDefaulter(Long customerId);
}