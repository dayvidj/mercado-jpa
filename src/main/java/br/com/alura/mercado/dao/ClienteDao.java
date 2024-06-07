package br.com.alura.mercado.dao;

import javax.persistence.EntityManager;

import br.com.alura.mercado.model.Cliente;

public class ClienteDao {
	private final EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public void salvar(Cliente cliente) {
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
	}

	public Cliente buscar(Long id) {
		return em.find(Cliente.class, id);
	}

	public void atualizar(Cliente cliente) {
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
	}

	public void deletar(Long id) {
		em.getTransaction().begin();
		Cliente cliente = em.find(Cliente.class, id);
		em.remove(cliente);
		em.getTransaction().commit();
	}

}
