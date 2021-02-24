package com.scasistemas.client.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.scasistemas.client.dto.ClientDTO;
import com.scasistemas.client.entities.Client;
import com.scasistemas.client.repositories.ClientRepository;
import com.scasistemas.client.services.Exception.ResourceNotFoundException;


@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
		
		Page<Client> list = repository.findAll(pageRequest);
			
		return list.map(x -> new ClientDTO( x ));
		
	}

	public ClientDTO findById(Long id) {
		
		Optional<Client> obj = repository.findById(id);
		
		//Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Cliente não localizado"));
		
		Client entity = obj.get();
		
		return new ClientDTO(entity);
		
	}
	

}
