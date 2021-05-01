package com.livioneiva.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livioneiva.hrworker.entities.Worker;
import com.livioneiva.hrworker.repositories.WorkerRepository;

/*
essa classe vai funcionar como um web Services, ou seja um recurso web que vai disponibilizar 
os web point
 */

@RestController
@RequestMapping(value = "/workers")
public class workerResource {
	
	//esse obj serve para imprimir no log
	@Autowired
	private static Logger logger = LoggerFactory.getLogger(workerResource.class);
	
	//Environment(propriedade do sistema) = tem varias informaçoes do contexto da aplicação.
	@Autowired
	private Environment env;//vamos usar esse obj para fazer get as port no balanceamento de carga
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	//ResponseEntity = encapsula uma resposta http
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity findById(@PathVariable Long id) {
		
		/*
		 imprimir no console do worker, o num porta app está rodando,"local.server.port" faz o print da porta
		 da port app roda.
		 */
		logger.info("PORT = "+ env.getProperty("local.server.port"));
		
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}

}
/*
https://devkico.itexto.com.br/?p=3157
 “environment variable” (variável de ambiente) e “system property” (propriedade do sistema). 
 
 Variáveis de ambiente

Variável de ambiente é aquela que você define no sistema operacional em que seu código é executado.
No caso do Linux (e macOS) o fazemos com os comandos set e export. Já no caso do Windows é com o 
comando set (mais comum) ou a partir do utilitário de configuração gráfica de ambiente

Environment
O Environment representa na prática o ambiente de execução da sua aplicação.
É ele que diz quais variáveis de ambiente estamos usando, quais beans deverão ser instanciados e 
também quais os perfis que estão ativos ou que serão ativados pela nossa aplicação.
*/