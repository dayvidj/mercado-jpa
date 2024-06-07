package br.com.alura.mercado.dao;

import javax.persistence.EntityManager;

import com.ibm.icu.math.BigDecimal;

import br.com.alura.mercado.model.Venda;

public class VendaDao {
	private final EntityManager em;

	public VendaDao(EntityManager em) {
		this.em = em;
	}

	public void salvar(Venda venda) {
		em.getTransaction().begin();
		em.persist(venda);
		em.getTransaction().commit();
	}

	public Venda buscar(Long id) {
		return em.find(Venda.class, id);
	}

	public void atualizar(Venda venda) {
		em.getTransaction().begin();
		em.merge(venda);
		em.getTransaction().commit();
	}

	public void deletar(Long id) {
		em.getTransaction().begin();
		Venda venda = em.find(Venda.class, id);
		em.remove(venda);
		em.getTransaction().commit();
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT AVG(v.valorTotal) FROM Venda v";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
//	public List<Object[]> listarProdutosMaisVendidos() {
//	
//		String jpql = "SELECT iv.produto, SUM(iv.quantidade) as totalVendido " +
//				"FROM ItemVenda iv " +
//				"GROUP BY iv.produto " +
//				"ORDER BY totalVendido DESC";
//		
//		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
//	    return query.getResultList();
//	     
//	}

}
