package com.livioneiva.hrworker.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_worker")
public class Worker implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id //chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //GeneratedValue(valor Gerado), o id será gerado automatico pelo dba
	private Long id;
	private String name;
	private Double dailyIncome; //valor diaria
	
	public Worker() {
		
	}
	public Worker(Long id, String name, Double dailyIncome) {
		this.id=id;
		this.name=name;
		this.dailyIncome=dailyIncome;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}
	
	public String getNme() {
		return name;
	}
	public void setNmae(String name) {
		this.name=name;
	}
	public Double getDailyIncome() {
		return dailyIncome;
	}
	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
	
	
}
