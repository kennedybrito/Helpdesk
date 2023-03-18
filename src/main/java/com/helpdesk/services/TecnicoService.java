package com.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.domains.Pessoa;
import com.helpdesk.domains.Tecnico;
import com.helpdesk.dto.TecnicoDTO;
import com.helpdesk.repositories.PessoaRepository;
import com.helpdesk.repositories.TecnicoRepository;
import com.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Tecnico findById (Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("objeto não encontrado ID:" + id));
		
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);
	}

	private void validaPorCpfEEmail(TecnicoDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if( obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF ja cadastrado");
	}
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if( obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail ja cadastrado");
		
		}
	}

	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		objDTO.setId(id);
		Tecnico oldobj = findById(id);
		validaPorCpfEEmail(objDTO);
		
		oldobj = new Tecnico(objDTO);
		
		return repository.save(oldobj);
	}

	public void delete(Integer id) {
		Tecnico obj = findById(id);
		if( obj.getChamados().size()>0) {
			throw new DataIntegrityViolationException("Tecnico possui ordens de serviços não pode ser deletado");
		} else {
			repository.deleteById(id);
		}
		
	}
	
	
	
	}
