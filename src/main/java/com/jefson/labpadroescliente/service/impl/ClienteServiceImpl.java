package com.jefson.labpadroescliente.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jefson.labpadroescliente.model.Cliente;
import com.jefson.labpadroescliente.model.Endereco;
import com.jefson.labpadroescliente.repository.ClienteRepository;
import com.jefson.labpadroescliente.repository.EnderecoRepository;
import com.jefson.labpadroescliente.service.ClienteService;
import com.jefson.labpadroescliente.service.ViaCepService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository clienteRepository;
	private EnderecoRepository enderecoRepository;
	private ViaCepService viaCepService;
	
	

	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public Cliente inserir(Cliente cliente) {
		return salvarClienteComCep(cliente);
		
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}

	private Cliente salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		return clienteRepository.save(cliente);
	}
}