package com.livioneiva.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//o components //HrPayroll vai ser client do components hr-worker
//hrPayroll vai ser client de hr-worker
//@RibbonClient(name = "hr-worker") //cliente Ribbon, com essa annotations o hrpayroll é quem vai usaar o balanciamento de carga
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class HrPayrollApplication {//folha de pagamento

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}
