package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.AlunoDao;
import model.Aluno;



@Controller
public class alunoController {

	
	@RequestMapping("novoAluno")
	public	String	form() {
	
	return "addAluno";
	}
	
	@RequestMapping("adicionaAluno")
	public	String	adiciona(Aluno	aluno, @RequestParam("novo") String novo, @RequestParam("id") String id) throws ParseException {
		
		util util = new util();
		System.out.println("variavel id é: " + id);
		
		Boolean teste = (novo.equals("existente"));
		System.out.println("novo = existente: " + teste);
	    
	     if(aluno.validate()) {

	    	 AlunoDao dao = new AlunoDao();
	    	 if(novo.equals("novo"))
	    		 util.AddBanco(aluno);
	    		// dao.cadastrarAluno(aluno);
	    	 else if (novo.equals("existente")) {
	    		 
	    		 System.out.println("atualizando aluno");dao.alterarAluno(aluno);
	    	 }
	    	 return "alunoadicionado";
	     }
	     
	     System.out.println("erros encontrados: ");
	     for(String erros: aluno.erro) {
	    	 System.out.println(" " + erros + " ");
	     }
	        
		return "addAluno";
		
	}
	
	@RequestMapping("listaAlunos")
	public	String lista(Model model) {
					util util = new util();
					//AlunoDao dao = new AlunoDao();
					List<Aluno> alunos = util.ListaAlunoBanco();//dao.consultarListaAluno();	
					System.out.println("buscou alunos no banco e retornou aluno com " + alunos.size() + " alunos. ");
					model.addAttribute("alunos", alunos);
					return	"listAlunos";

	}
	
	
	@RequestMapping("deletaAluno")
	public	String deleta(Long id, Model model) {
					AlunoDao dao = new AlunoDao();
					
					System.out.println("valor do id = " + id);
					
					dao.deletarAluno(id);	
					
					System.out.println("deletou o aluno");
					//model.addAttribute("tarefas", tarefas);
					
					return	"redirect:listaAlunos";

	}
	
	@RequestMapping("editaAluno")
	public	String edita(Long id, Model model) {
					AlunoDao dao = new AlunoDao();
					
					System.out.println("valor do id = " + id);
					
					Aluno aluno = dao.recuperarAluno(id);	
					
					System.out.println("tem valor o aluno " + aluno.getNome());
					model.addAttribute("aluno", aluno);
					
					return	"addAluno";

	}	
	
	
}
