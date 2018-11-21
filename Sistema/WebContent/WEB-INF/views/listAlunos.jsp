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
		        <th>Nome</th>
		        <th>CPF</th>
		        <th>Email</th>
		        <th>Curso</th>
		        <th>Opções</th>
		      </tr>
		    </thead>
		    <tbody>
		     <c:forEach var="aluno" items="${alunos}">
		      <tr>
		        <td>${aluno.nome}</td>
		        <td>${aluno.cpf}</td>
		        <td>${aluno.email}</td>
		     	<td>
		     	<c:choose>
			        <c:when test="${aluno.curso == 1}">JavaWeb</c:when>
			        <c:when test="${aluno.curso == 2}">Cobol</c:when>
			        <c:when test="${aluno.curso == 3}">.NET</c:when>
			        <c:when test="${aluno.curso == 4}">Redes</c:when>
			        <c:when test="${aluno.curso == 5}">Phyton</c:when>
			        <c:otherwise>Sem Curso</c:otherwise>
			    </c:choose>
		     	</td>
		     	<td><a href="editaAluno?id=${aluno.id}" class="btn btn-info" role="button">Editar</a>
		     	<a href="deletaAluno?id=${aluno.id}" class="btn btn-info" role="button">Deletar</a></td>
		      </tr>
		      </c:forEach>
		      
		     </tbody>
		  </table>
		</div>

</body>
</html>