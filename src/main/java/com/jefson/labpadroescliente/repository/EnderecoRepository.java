package com.jefson.labpadroescliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jefson.labpadroescliente.model.Endereco;


@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}