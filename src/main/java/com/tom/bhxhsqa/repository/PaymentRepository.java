package com.tom.bhxhsqa.repository;

import com.tom.bhxhsqa.entity.Company;
import com.tom.bhxhsqa.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}