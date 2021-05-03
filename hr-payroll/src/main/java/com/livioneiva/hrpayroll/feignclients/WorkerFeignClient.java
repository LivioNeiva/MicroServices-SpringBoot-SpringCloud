package com.livioneiva.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.livioneiva.hrpayroll.entities.Worker;

@Component //essa interface vai ser um component gerenciado pelo spring | parametro hadeCode path = "/workers"
@FeignClient(name = "hr-worker", path = "/workers") //name = "hr-worker" = é o nome do micro-service, que se encontra no application-properties do componente hr-worker. path = "/workers" é caminho para acessar host
public interface WorkerFeignClient {
	
	//assinatura da interface, ele chama metodo q estar project worker, package Resources class workerResource
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id); 

}

/*
config do FeignClient

usamos o url= "localhost:8001"(url do worker) quando temos apenas uma localização, com balanceamento de carga
usamos outra forma, é o baleceamento de cara com Ribbon
@FeignClient(name = "hr-worker", url= "localhost:8001", path = "/workers")

@Component //essa interface vai ser um component gerenciado pelo spring
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers") //name = "hr-worker" = é o nome do micro-service, que seencontra no application-properties do componente hr-worker
public interface WorkerFeignClient {
	
	//assinatura da interface
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id); 

}

Hardcode é o termo utilizado para todo tipo de codificação feita que, para alterar a visualização,
 o comportamento ou resultado final de algo, requer uma mudança no código fonte da aplicação, 
 quando o recomendado seria mudar algum dado (parâmetro) desta.
*/