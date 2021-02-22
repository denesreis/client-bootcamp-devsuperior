package com.scasistemas.client.dto;

import java.io.Serializable;
import java.time.Instant;

import com.scasistemas.client.entities.Client;

public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String cpf;
	private double income;
	private Instant birthDay;
	private Integer children ;
	
	public ClientDTO() {
		
	}
	
	public ClientDTO(Long id, String name, String cpf, double income, Instant birthDay, Integer children) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDay = birthDay;
		this.children = children;
	}	
	
	public ClientDTO(Client entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
		this.income = entity.getIncome();
		this.birthDay = entity.getBirthDay();
		this.children = entity.getChildren();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public Instant getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Instant birthDay) {
		this.birthDay = birthDay;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
