package com.microservicedemo.PaymentService.repository;

import com.microservicedemo.PaymentService.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails,Long> {
}
