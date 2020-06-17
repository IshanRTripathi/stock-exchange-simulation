package com.mthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.models.TradeTable;

@Repository
public interface TradeTableRepository extends JpaRepository<TradeTable,Integer> {

}
