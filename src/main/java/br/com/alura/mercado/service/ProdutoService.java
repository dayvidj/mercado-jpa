package br.com.alura.mercado.service;

import javax.persistence.EntityManager;

import br.com.alura.mercado.dao.ProdutoDao;
import br.com.alura.mercado.model.Produto;

public class ProdutoService {
	private final ProdutoDao produtoDao;

	public ProdutoService(EntityManager entityManager) {
		this.produtoDao = new ProdutoDao(entityManager);
	}

	public void salvarProduto(Produto produto) {
		produtoDao.salvar(produto);
	}
	
	public Produto buscarPorId(Long id) {
		return produtoDao.buscar(id);
	}

	public void atualizarProduto(Produto produto) {
		produtoDao.atualizar(produto);
	}
	
	public void deletarProduto(Long id) {
		produtoDao.deletar(id);
	}
	
	public Integer estoqueProdutoService(Long id) {
		return produtoDao.verificarQuantidadeDisponível(id);
	}

}
