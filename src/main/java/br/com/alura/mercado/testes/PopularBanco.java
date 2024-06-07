package br.com.alura.mercado.testes;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.h2.tools.Server;

import br.com.alura.mercado.model.Cliente;
import br.com.alura.mercado.model.ItemVenda;
import br.com.alura.mercado.model.Produto;
import br.com.alura.mercado.model.Venda;
import br.com.alura.mercado.service.ClienteService;
import br.com.alura.mercado.service.ProdutoService;
import br.com.alura.mercado.service.VendaService;
import br.com.alura.mercado.util.JPAUtil;

public class PopularBanco {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		//Persistindo Produto 
		Produto produto = new Produto("Celular", "iPhone 11", new BigDecimal("2000"), 10);
		ProdutoService produtoService = new ProdutoService(em);
		produtoService.salvarProduto(produto);

		//Persistindo CLiente
		Cliente cliente = new Cliente("John", "john@email", "(99)99999-9999");
		ClienteService clienteService = new ClienteService(em);
		clienteService.salvarCliente(cliente);
		
		//Instanciando um item venda com os dados da venda e salvando no bd
		Venda venda = new Venda(cliente);
		ItemVenda itemVenda = new ItemVenda(3, produto, venda);		
		venda.adicionarItem(itemVenda);
		VendaService vendaService = new VendaService(em);
		vendaService.salvarVenda(venda);
		
		//Atualização dos dados do produto no banco
		produto.setQuantidadeEmEstoque(itemVenda.atualizarQuantidadeProduto());
		produtoService.atualizarProduto(produto);
		
		System.out.println("QUANTIDADE DISPONÍVEL: "+produtoService.estoqueProdutoService(1l));

		
		em.close();

		iniciarServidor();

	}
	
	public static void iniciarServidor() {
		try {
			Server.createWebServer("-web").start();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Servidor H2 iniciado. Acesse o console em http://localhost:8082");		
	}

}
