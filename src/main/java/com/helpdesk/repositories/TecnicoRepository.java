package com.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpdesk.domains.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
