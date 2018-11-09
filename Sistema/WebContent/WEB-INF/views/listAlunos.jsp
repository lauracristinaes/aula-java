<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>Listar Alunos</title>
</head>
<body>

		<div class="container">
		  <h2>Lista de Alunos</h2>
		         
		  <table class="table table-hover">
		    <thead>
		      <tr>
		        <th>Nome/Email</th>
		        <th>CPF/Endereço</th>
		        <th>Data de Nascimento/Telefone</th>
		      </tr>
		    </thead>
		    <tbody>
		     <c:forEach var="aluno" items="${alunos}">
		      <tr>
		        <td>${aluno.email}</td>
		        <td>${aluno.endereco}</td>
		        <td>${aluno.telefone}</td>
		     
		      </tr>
		      </c:forEach>
		      
		     </tbody>
		  </table>
		</div>

</body>
</html>