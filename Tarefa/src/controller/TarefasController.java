package controller;

import javax.validation.Valid;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import dao.TarefaDAO;
import model.Tarefa;


@Controller
public class TarefasController {
	
	
	@RequestMapping("novaTarefa")
	public	String	form() {
			
			
	return "tarefa/addTarefa";
	}

	
	@RequestMapping("adicionaTarefa")
	public	String	adiciona(@Valid Tarefa	tarefa, BindingResult result) {
		System.out.println("entrou aqui");
		//verifica se há erros de validação no formulário geral
//		if(result.hasErrors())	{
//			System.out.println("entrou no erro geral");
//			return "tarefa/addTarefa";
//		}

		//verifica se há erros de validação no formulário, especificamente no campo descrição
		if(result.hasFieldErrors("descricao")){
			System.out.println("entrou no erro especifico");
			return "cafe";
		}

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


	
/*Testando passagem de parametros entre paginas*/
	@RequestMapping("filtrar")
	public String fazerCafe(@RequestParam("marca") String cafe, Model model) {
		model.addAttribute("marca", cafe);
		
		return "final";
	}
	

}
