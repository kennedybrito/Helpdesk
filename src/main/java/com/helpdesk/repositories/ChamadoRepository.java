package com.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpdesk.domains.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
