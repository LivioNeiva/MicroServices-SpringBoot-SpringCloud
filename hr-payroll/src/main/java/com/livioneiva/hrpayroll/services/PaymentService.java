package com.livioneiva.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.livioneiva.hrpayroll.entities.Payment;
import com.livioneiva.hrpayroll.entities.Worker;

/* criararemos um serviço para instanciar o payment */

//@Component //temos resistrar esse service com um component do Spring, para q ele possa ser injetado em outras classes
@Service
public class PaymentService {

	//essa propriedade esta no application.properties
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//vamos fazer uma requisiçao externa usando HastTemplate
	public Payment getPayment(Long workerId, int days) {
		
		//vmos crar um mapa ou dicionario de parametros
		//vamos usar String no Map, os parametros http é sempre String
		Map<String, String> uriVariables = new HashMap<>();//Map é uma interface e HashMap é uma interface;
		uriVariables.put("id", ""+workerId);// ""+workerId - converti Long para string
		
		//Worker.class é tipo de obj q estou buscando, temos passar os parametros para uriVariables
		Worker worker = restTemplate.getForObject(workerHost+"/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
