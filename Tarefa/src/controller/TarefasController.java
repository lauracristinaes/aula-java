package controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import dao.TarefaDAO;
import model.Tarefa;


@Controller
public class TarefasController {
	
	@RequestMapping("projetoTarefas")
	public	String	index() {
			
			
	return "tarefa/index";
	}
	
	@RequestMapping("novaTarefa")
	public	String	form() {
			
			
	return "tarefa/addTarefa";
	}

	
	@RequestMapping("adicionaTarefa")
	public	String	adiciona(@Valid Tarefa	tarefa, BindingResult result) throws ParseException {
		System.out.println("entrou aqui");
		//verifica se h� erros de valida��o no formul�rio geral
//		if(result.hasErrors())	{
//			System.out.println("entrou no erro geral");
//			return "tarefa/addTarefa";
//		}

		//verifica se h� erros de valida��o no formul�rio, especificamente no campo descri��o
		if(result.hasFieldErrors("descricao")){
			System.out.println("entrou no erro especifico");
			return "";
		}
		
		System.out.println("A data que veio do form �: " + tarefa.getDtFinalizacao());
		
		 Calendar cal = GregorianCalendar.getInstance();
	     SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	     String d = df.format(cal.getTime());
	     Date d2 = df.parse(d);
	        
		tarefa.setDataFinalizacao(d2);
		TarefaDAO dao = new TarefaDAO();
		dao.cadastrarTarefa(tarefa);
		
		//model.addAttribute("tarefa", tarefa.getDescricao());
		return "tarefa/adicionada";
	}
	
	
	@RequestMapping("listaTarefas")
	public	String lista(Model model) {
					TarefaDAO dao = new TarefaDAO();
					List<Tarefa> tarefas = dao.consultarListaTarefa();	
					System.out.println("buscou tarefas no banco e retornou " + tarefas.get(0).getDescricao() + "tarefas");
					model.addAttribute("tarefas", tarefas);
					return	"tarefa/lista";

	}
	
	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public	void	finaliza(Long	id) {
			TarefaDAO	dao	=	new	TarefaDAO();
			dao.finaliza(id);
	}


	
	@RequestMapping("deletaTarefa")
	public	String deleta(Long id, Model model) {
					TarefaDAO dao = new TarefaDAO();
					
					System.out.println("valor do id = " + id);
					
					dao.deletarTarefa(id);	
					
					System.out.println("deletou a tarefa");
					//model.addAttribute("tarefas", tarefas);
					
					return	"redirect:listaTarefas";

	}

	

}
