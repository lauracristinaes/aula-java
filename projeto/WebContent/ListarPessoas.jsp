<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<%@	page import="java.util.*,
projeto.*"
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Pessoas</title>
</head>
<body>

<p> Pessoas Cadastradas no Banco:

<ul>


<%ArrayList<Pessoa> teste = new  ArrayList<Pessoa>(); 
teste =  (ArrayList<Pessoa>) request.getAttribute("arrayListPessoas");

for(Pessoa pessoa: teste){
	out.println(pessoa.nome);
}
%>

</ul>

</body>
</html>