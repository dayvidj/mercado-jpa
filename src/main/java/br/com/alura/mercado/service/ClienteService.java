package br.com.alura.mercado.service;

import javax.persistence.EntityManager;

import br.com.alura.mercado.dao.ClienteDao;
import br.com.alura.mercado.model.Cliente;

public class ClienteService {
	private final ClienteDao clienteDao;
	
	public ClienteService(EntityManager entityManager) {
		this.clienteDao = new ClienteDao(entityManager); 
	}
	
	public void salvarCliente(Cliente cliente) {
		clienteDao.salvar(cliente);
	}
}
