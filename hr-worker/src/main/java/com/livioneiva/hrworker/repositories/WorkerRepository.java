package com.livioneiva.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livioneiva.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
