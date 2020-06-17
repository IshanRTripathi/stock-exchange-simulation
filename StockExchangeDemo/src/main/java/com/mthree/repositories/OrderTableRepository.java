package com.mthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.models.OrderTable;

@Repository
public interface OrderTableRepository extends JpaRepository<OrderTable,Integer>{

}
