package com.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.domains.Chamado;
import com.helpdesk.repositories.ChamadoRepository;
import com.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class ChamadoService {
	
	@Autowired 
	private ChamadoRepository repository;
	
	public Chamado findById( Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectnotFoundException("chamado não encontrado ID:" + id));
	}
	

}
