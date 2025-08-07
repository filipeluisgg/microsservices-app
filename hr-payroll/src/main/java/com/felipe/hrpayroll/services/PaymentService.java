package com.felipe.hrpayroll.services;

import com.felipe.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService
{
    public Payment getPayment(Long workerId, int days) {
        return new Payment("Bob", 200.0, days);
    }
}
