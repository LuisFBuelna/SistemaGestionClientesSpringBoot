package com.prueba.ControlClientesSpring.dao;

import com.prueba.ControlClientesSpring.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDAO extends CrudRepository<Persona, Long>{
    
}
