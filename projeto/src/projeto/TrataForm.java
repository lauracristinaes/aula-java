package projeto;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adicionaContato")
public class TrataForm extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		PrintWriter	out	=	response.getWriter();
	/*	
		String	CPF	=	request.getParameter("CPF");
		String	nome	=	request.getParameter("nome");
		String	sexo	=	request.getParameter("sexo");
		//String	dtNasc	=	request.getParameter("dtNasc");
		/*
		
		String	dataEmTexto	= request.getParameter("dtNasc");
		Calendar dataNascimento	=	null;
		//	fazendo	a	conversão	da	data
		try	{
			Date date = new	SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento	=	Calendar.getInstance();
			dataNascimento.setTime(date);
			}	catch	(ParseException	e)	{
				out.println("Erro	de	conversão	da	data");
				return;	//para	a	execução	do	método
				}
		*/
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String strDt = "2015-11-15";
		Date dt = null;
		try {
			dt = formato.parse(strDt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//int cpf = Integer.parseInt(CPF);
		
		//Pessoa pessoa = new Pessoa(cpf, nome, sexo, dt);
		
		//System.out.println(pessoa.cpf);
		//System.out.println(pessoa.nome);
		//System.out.println(pessoa.dtNasc);
		
		//pessoa.addBanco();
		
		
		
		ArrayList<Pessoa> listPessoas = new ArrayList<Pessoa>();
		//listPessoas = pessoa.ListaPessoasBanco();
		listPessoas.add(new Pessoa(12, "teste", "m", dt));
		for(Pessoa pessoa1: listPessoas){
			System.out.println(pessoa1.nome);
		}
		
		request.setAttribute("arrayListPessoas", listPessoas);
	
		RequestDispatcher rd = request.getRequestDispatcher("ListarPessoas.jsp");
		rd.forward(request, response);


	}

}
