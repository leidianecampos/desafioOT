package com.orangetalents.repository;

import org.springframework.data.repository.CrudRepository;

import com.orangetalents.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {
	
}
