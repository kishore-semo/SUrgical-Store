package com.kishore.semo_surgicals.Repository;

import com.kishore.semo_surgicals.Model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query(value = "SELECT u.name FROM stock u", nativeQuery = true)
    List<String> findAllStockNames();

    Stock findByName(String name);
}