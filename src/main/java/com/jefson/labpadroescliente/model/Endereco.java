package com.jefson.labpadroescliente.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Endereco {

	@Id
	private String cep;
	@Schema(hidden = true)
	private String logradouro;
	@Schema(hidden = true)
	private String complemento;
	@Schema(hidden = true)
	private String bairro;
	@Schema(hidden = true)
	private String localidade;
	@Schema(hidden = true)
	private String uf;
	@Schema(hidden = true)
	private String ibge;
	@Schema(hidden = true)
	private String gia;
	@Schema(hidden = true)
	private String ddd;
	@Schema(hidden = true)
	private String siafi;
}
