<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Pessoa</title>
</head>
<body>
	<form	action="adicionaContato">
		CPF: <input type ="text" name = "CPF" /> <br	/>
		Nome:	<input	type="text" name="nome"	/><br	/>
		Sexo:	<input	type="text" name="sexo"	/><br	/>
		Data	Nascimento:	<input	type="text" name="dtNasc"	/><br	/>
		<input	type="submit" value="Gravar"	/>
	</form>
	<% String nome = "teste"; %>
	<% System.out.println(nome); %>

</body>
</html>