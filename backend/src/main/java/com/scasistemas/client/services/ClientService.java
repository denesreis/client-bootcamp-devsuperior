package com.scasistemas.client.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scasistemas.client.dto.ClientDTO;
import com.scasistemas.client.entities.Client;
import com.scasistemas.client.repositories.ClientRepository;
import com.scasistemas.client.services.Exception.DatabaseException;
import com.scasistemas.client.services.Exception.ResourceNotFoundException;


@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
		
		Page<Client> list = repository.findAll(pageRequest);
			
		return list.map(x -> new ClientDTO( x ));
		
	}
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		
		Optional<Client> obj = repository.findById(id);
		
		Client entity =obj.orElseThrow(() -> new ResourceNotFoundException("Cliente não localizado"));
		
		//Client entity = obj.get();
		
		return new ClientDTO(entity);
		
	}
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setBirthDate(dto.getBirthDate()); 
		entity.setChildren(dto.getChildren());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity = repository.save(entity);
		
		return new ClientDTO(entity);

	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			
			Client entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity.setBirthDate(dto.getBirthDate());
			entity.setChildren(dto.getChildren());
			entity.setCpf(dto.getCpf());
			entity.setIncome(dto.getIncome());
			entity = repository.save(entity);
			
			return new ClientDTO(entity);
		}
		catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Id de Cliente não localizdada"+id);
		}
		
	}
	
	public void delete(long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id de Cliente não localizdada");
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integridade de banco de dados violada");
		}
	}
	

}
