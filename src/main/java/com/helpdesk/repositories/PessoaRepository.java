package com.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpdesk.domains.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
