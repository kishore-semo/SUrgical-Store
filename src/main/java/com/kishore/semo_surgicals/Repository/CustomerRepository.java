package com.kishore.semo_surgicals.Repository;

import com.kishore.semo_surgicals.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT u.customer_name FROM customer u", nativeQuery = true)
    List<String> findAllCustomerNames();

    Customer findByCustomerName(String customerName);
}