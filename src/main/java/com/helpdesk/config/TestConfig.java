package com.helpdesk.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.helpdesk.domains.Chamado;
import com.helpdesk.domains.Cliente;
import com.helpdesk.domains.Tecnico;
import com.helpdesk.domains.enums.Perfil;
import com.helpdesk.domains.enums.Prioridade;
import com.helpdesk.domains.enums.Status;
import com.helpdesk.repositories.ChamadoRepository;
import com.helpdesk.repositories.ClienteRepository;
import com.helpdesk.repositories.TecnicoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
//	@Autowired
//	private DBService dbService;
//
//	@Bean
//    public void instanciaDB() {
//        this.dbService.instaciaDB();
//    }

	@Autowired
	private TecnicoRepository tecR;
	
	@Autowired
	private ClienteRepository cliR;
	
	@Autowired
	private ChamadoRepository chaR;
	
	public void instaciaDB() {
		
	
}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Tecnico tec1 = new Tecnico(null, "Kennedy brito", "656874123", "kennedy@gmail.com", "123456");
	
		tec1.addPerfil(Perfil.ADMIN);
		
		
		Cliente cli1 = new Cliente(null, "Dwayne Johnson", "458712657", "dwayne@gmail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "chamado 01", "chamado teste", tec1, cli1);
		
		tecR.saveAll(Arrays.asList(tec1));
		cliR.saveAll(Arrays.asList(cli1));
		chaR.saveAll(Arrays.asList(c1));
	}}


