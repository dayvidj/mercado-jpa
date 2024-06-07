package br.com.alura.mercado.service;

import javax.persistence.EntityManager;

import br.com.alura.mercado.dao.VendaDao;
import br.com.alura.mercado.model.Venda;

public class VendaService {
	private final VendaDao vendaDao;
	
	public VendaService(EntityManager entityManager) {
		this.vendaDao = new VendaDao(entityManager);
	}
	
	public void salvarVenda(Venda venda) {
		vendaDao.salvar(venda);
	}
	
}
