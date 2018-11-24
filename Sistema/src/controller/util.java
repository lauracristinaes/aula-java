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
	
	public Aluno RecuperaAlunoBanco(Long id) {
		
		   EntityManagerFactory factory = Persistence.
	                createEntityManagerFactory("cadastro");
	    
		   EntityManager	manager	=	factory.createEntityManager();
		   manager.getTransaction().begin();	
			
		   Aluno aluno	= manager.find(Aluno.class, id);
		   
		
		   System.out.println("aluno recuperado do banco: ");
		   System.out.println(aluno.isSexo());
		   System.out.println(aluno.getEndereco());
		   
		   manager.getTransaction().commit();		

		   factory.close();
		   manager.close();
		    
		   return aluno;
	    
	    
		}
	
	public void UpdateAlunoBanco(Aluno aluno) {
		
		   EntityManagerFactory factory = Persistence.
	                createEntityManagerFactory("cadastro");
	    
		   EntityManager	manager	=	factory.createEntityManager();
		   manager.getTransaction().begin();	
				   
		   manager.merge(aluno);
		   
		   manager.getTransaction().commit();		

		   factory.close();
		   manager.close();	    	   
	    
		}
	
	public void RemoveAlunoBanco(Long id) {
		
		   EntityManagerFactory factory = Persistence.
	                createEntityManagerFactory("cadastro");
	    
		   EntityManager	manager	=	factory.createEntityManager();
		   manager.getTransaction().begin();	
		   System.out.println("o valor que veio de id é: " + id);
		   
		   Query	query	=	manager
					.createQuery("delete from Aluno where id = :id");
		   query.setParameter("id", id);
		   query.executeUpdate();

		      
		   //Aluno aluno	= manager.find(Aluno.class, id);	
		  // manager.remove(aluno);

		   factory.close();
		   manager.close();
		    
	
	    	    
		}

}
