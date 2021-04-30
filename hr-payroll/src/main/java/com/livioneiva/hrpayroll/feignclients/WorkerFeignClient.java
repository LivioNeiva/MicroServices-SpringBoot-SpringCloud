package com.livioneiva.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.livioneiva.hrpayroll.entities.Worker;

@Component //essa interface vai ser um component gerenciado pelo spring
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers") //name = "hr-worker" = é o nome do micro-service, que seencontra no application-properties do componente hr-worker
public interface WorkerFeignClient {
	
	//assinatura da interface
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id); 

}
