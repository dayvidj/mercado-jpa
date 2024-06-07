package br.com.alura.mercado.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("mercado");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}
