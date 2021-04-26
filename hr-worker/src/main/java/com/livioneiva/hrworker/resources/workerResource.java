package com.livioneiva.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}

}
