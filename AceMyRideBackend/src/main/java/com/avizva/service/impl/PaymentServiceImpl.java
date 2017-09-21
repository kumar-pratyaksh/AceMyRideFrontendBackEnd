package com.avizva.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.PaymentDao;
import com.avizva.model.Payment;
import com.avizva.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	@Override
	public Payment savePayment(Payment payment) {
		return paymentDao.save(payment);
	}

}
