package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Aluno;

public class util {
	
	public void AddBanco(Aluno aluno) {
		
	      EntityManagerFactory factory = Persistence.
                  createEntityManagerFactory("cadastro");
      
		EntityManager	manager	=	factory.createEntityManager();
		manager.getTransaction().begin();							
		manager.persist(aluno);
		manager.getTransaction().commit();		

      factory.close();
      manager.close();
	}
	
	public List<Aluno> ListaAlunoBanco() {
		
	   EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("cadastro");
    
	   EntityManager	manager	=	factory.createEntityManager();
	   manager.getTransaction().begin();	
		
	   Query	query	=	manager
				.createQuery("select a	from	Aluno a");
	   List<Aluno>	alunos	=	query.getResultList();


	   manager.getTransaction().commit();		

	   factory.close();
	   manager.close();
	    
	   return alunos;
    
    
	}
	

}
