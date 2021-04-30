package com.livioneiva.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HrPayrollApplication {//folha de pagamento

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}
