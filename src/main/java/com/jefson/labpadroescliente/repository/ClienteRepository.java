package com.jefson.labpadroescliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jefson.labpadroescliente.model.Cliente;


@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}