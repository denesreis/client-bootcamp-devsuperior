package com.scasistemas.client.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.scasistemas.client.dto.ClientDTO;
import com.scasistemas.client.entities.Client;
import com.scasistemas.client.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
		
		Page<Client> list = repository.findAll(pageRequest);
			
		return list.map(x -> new ClientDTO( x ));
		
	}
	

}
