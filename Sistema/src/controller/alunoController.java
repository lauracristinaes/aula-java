package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AlunoDao;
import model.Aluno;



@Controller
public class alunoController {

	
	@RequestMapping("novoAluno")
	public	String	form() {
	
	return "addAluno";
	}
	
	@RequestMapping("adicionaAluno")
	public	String	adiciona(Aluno	aluno, BindingResult result) throws ParseException {
		System.out.println("entrou aqui");
		//verifica se há erros de validação no formulário geral
//		if(result.hasErrors())	{
//			System.out.println("entrou no erro geral");
//			return "tarefa/addTarefa";
//		}

		//verifica se há erros de validação no formulário, especificamente no campo descrição
//		if(result.hasFieldErrors("descricao")){
//			System.out.println("entrou no erro especifico");
//			return "";
//		}
//		
		System.out.println("A data que veio do form é: " + aluno.getDtNasc());
		
		 Calendar cal = GregorianCalendar.getInstance();
	     SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	     String d = df.format(cal.getTime());
	     Date d2 = df.parse(d);
	     aluno.setDtNasc(d2);
	        
		AlunoDao dao = new AlunoDao();
		dao.cadastrarAluno(aluno);
		
		//model.addAttribute("tarefa", tarefa.getDescricao());
		return "alunoadicionado";
	}
	
	@RequestMapping("listaAlunos")
	public	String lista(Model model) {
					AlunoDao dao = new AlunoDao();
					List<Aluno> alunos = dao.consultarListaAluno();	
					System.out.println("buscou alunos no banco e retornou aluno com " + alunos.size() + " alunos. ");
					model.addAttribute("alunos", alunos);
					return	"listAlunos";

	}
	
	
}
