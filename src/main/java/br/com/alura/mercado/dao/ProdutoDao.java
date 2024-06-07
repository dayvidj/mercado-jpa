package br.com.alura.mercado.dao;

import javax.persistence.EntityManager;

import br.com.alura.mercado.model.Produto;

public class ProdutoDao {
	private final EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void salvar(Produto produto) {
		// Iniciando a transação no bd
		em.getTransaction().begin();	
		em.persist(produto);
		// Commita as operações no bd
		em.getTransaction().commit();
	}

	public Produto buscar(Long id) {
		return em.find(Produto.class, id);
	}

	public void atualizar(Produto produto) {
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
	}

	public void deletar(Long id) {
		em.getTransaction().begin();
		Produto produto = em.find(Produto.class, id);
		em.remove(produto);
		em.getTransaction().commit();
	}
	
	public Integer verificarQuantidadeDisponível(Long id) {
		String jpql = "SELECT p.quantidadeEmEstoque FROM Produto p WHERE p.id = :id";
		return em.createQuery(jpql, Integer.class).setParameter("id", id).getSingleResult();
	}

}
