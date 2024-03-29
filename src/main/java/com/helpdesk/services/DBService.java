package com.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.domains.Chamado;
import com.helpdesk.domains.Cliente;
import com.helpdesk.domains.Tecnico;
import com.helpdesk.domains.enums.Perfil;
import com.helpdesk.domains.enums.Prioridade;
import com.helpdesk.domains.enums.Status;
import com.helpdesk.repositories.ChamadoRepository;
import com.helpdesk.repositories.ClienteRepository;
import com.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecR;
	
	@Autowired
	private ClienteRepository cliR;
	
	@Autowired
	private ChamadoRepository chaR;
	
	public void instaciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Kennedy brito", "656874123", "kennedy@gmail.com", "123456");
		Tecnico tec2 = new Tecnico(null, "teste 2", "657774123", "kennedy@gmail.com", "123456");
		tec1.addPerfil(Perfil.ADMIN);
		
		
		Cliente cli1 = new Cliente(null, "Dwayne Johnson", "458712657", "dwayne@gmail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "chamado 01", "chamado teste", tec1, cli1);
		
		tecR.saveAll(Arrays.asList(tec1,tec2));
		cliR.saveAll(Arrays.asList(cli1));
		chaR.saveAll(Arrays.asList(c1));
		
	}

	

}
