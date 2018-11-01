package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OlaMundoController {
	
	@RequestMapping("/olaMundoSpring")
	public	String	execute() {
					System.out.println("Executando	a	lógica	com	Spring	MVC");
					return "Testes/cafe";
	}
	
	
	/*Testando passagem de parametros entre paginas*/
	@RequestMapping("filtrar")
	public String fazerCafe(@RequestParam("marca") String cafe, Model model) {
		model.addAttribute("marca", cafe);
		
		return "Testes/final";
	}

}
