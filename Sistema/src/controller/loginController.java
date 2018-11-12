package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.UsuarioDao;
import model.Usuario;

@Controller
public class loginController {
	
	
	@RequestMapping("login")
	public	String	loginForm() {
					return "login";
	}

	@RequestMapping("efetuaLogin")
	public	String	efetuaLogin(Usuario	usuario,	HttpSession	session) {
		System.out.println("entrou no efetuar login");
					if(new	UsuarioDao().existeUsuario(usuario))	{
						System.out.println("entrou no if existe usuário");
									session.setAttribute("usuarioLogado",	usuario);
									return "addAluno";
					}
					return "redirect:login";
	}


}
