package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.JdbcTarefaDao;
import model.Tarefa;

@Controller
public class TarefasController {

	@RequestMapping("novaTarefa")
	public String form(Model model) {
		Tarefa tarefa = new Tarefa();
		tarefa.setId((long) 0);
		model.addAttribute("tarefa", tarefa);

		// Passagem de parametros
		String tipoParametroString = "tipoParametroString";
		model.addAttribute("tipoParametroString", tipoParametroString);
		model.addAttribute("tipoParametroTextoDireto", "tipoParametroTextoDireto");

		int tipoParametroInt = 10;
		model.addAttribute("tipoParametroInt", tipoParametroInt);
		return "formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(Tarefa tarefa) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa-adicionada";
	}

	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		List<Tarefa> tarefas = dao.lista();
		model.addAttribute("tarefas", tarefas);
		return "lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.remove(tarefa);
		return "forward:listaTarefas";
	}

	@RequestMapping("editaTarefa")
	public String mostra(Long id, Model model) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "formulario";
	}

	@RequestMapping("finalizaTarefa")
	public @ResponseBody String finaliza(Long id, Long idTeste, String parametroTeste, Model model) {
		System.out.println("id = " + id);
		System.out.println("idTeste = " + idTeste);
		System.out.println("parametroTeste = " + parametroTeste);
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.finaliza(id);
		
		String result = "0";
		return result;
	}
}