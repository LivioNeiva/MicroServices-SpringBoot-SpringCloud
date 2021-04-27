package com.livioneiva.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.livioneiva.hrpayroll.entities.Payment;

/* criararemos um serviço para instanciar o payment */

//@Component //temos resistrar esse service com um component do Spring, para q ele possa ser injetado em outras classes
@Service
public class PaymentService {

	public Payment getPayment(Long workerId, int days) {
		return new Payment("Bob", 200.0, days);
	}
}
