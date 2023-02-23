package com.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.domains.Tecnico;
import com.helpdesk.repositories.TecnicoRepository;
import com.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById (Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("objeto não encontrado ID:" + id));
		
	}
	
	//(() -> new ObjectnotFoundException("objeto não encontrado ID:" + id));

}
