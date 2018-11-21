package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

public class TesteHibernate {
	
	public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.
                    createEntityManagerFactory("cadastro");
        
		EntityManager	manager	=	factory.createEntityManager();
		manager.getTransaction().begin();							
		Aluno aluno = new Aluno();
		aluno.setNome("teste");
		
		manager.persist(aluno);
		manager.getTransaction().commit();		

        factory.close();
        manager.close();
    }

}
