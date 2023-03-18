package com.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.domains.Cliente;
import com.helpdesk.domains.Pessoa;
import com.helpdesk.dto.ClienteDTO;
import com.helpdesk.repositories.ClienteRepository;
import com.helpdesk.repositories.PessoaRepository;
import com.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Cliente findById (Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("objeto não encontrado ID:" + id));
		
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Cliente newObj = new Cliente(objDTO);
		return repository.save(newObj);
	}

	private void validaPorCpfEEmail(ClienteDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if( obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF ja cadastrado");
	}
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if( obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail ja cadastrado");
		
		}
	}

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldobj = findById(id);
		validaPorCpfEEmail(objDTO);
		
		oldobj = new Cliente(objDTO);
		
		return repository.save(oldobj);
	}

	public void delete(Integer id) {
		Cliente obj = findById(id);
		if( obj.getChamados().size()>0) {
			throw new DataIntegrityViolationException("Cliente possui ordens de serviços não pode ser deletado");
		} else {
			repository.deleteById(id);
		}
		
	}
	
	
	
	}
