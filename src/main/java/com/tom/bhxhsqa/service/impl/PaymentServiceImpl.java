package com.tom.bhxhsqa.service.impl;

import com.tom.bhxhsqa.entity.Payment;
import com.tom.bhxhsqa.repository.PaymentRepository;
import com.tom.bhxhsqa.repository.UserRepository;
import com.tom.bhxhsqa.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository injectedBean) {
        this.paymentRepository = injectedBean;
    }

    @Override
    public void thanhToan(Payment payment) {
        paymentRepository.save(payment);
    }
}
