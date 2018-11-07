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
	<script	type="text/javascript">
	function finalizaAgora(id) {
		$.get("finalizaTarefa?id="	+	id,	function(dadosDeResposta) {
			alert("Tarefa	Finalizada!");
		});
	}
	</script>
	<title>Lista de Tarefas</title>
	</head>
	<body>
	
		<div class="container">
		  <h2>Lista de Tarefas</h2>
		         
		  <table class="table table-hover">
		    <thead>
		      <tr>
		        <th>Descrição</th>
		        <th>Status</th>
		        <th>Data de Finalização</th>
		        <th>Opções</th>
		      </tr>
		    </thead>
		    <tbody>
		     <c:forEach var="tarefa" items="${tarefas}">
		      <tr>
		        <td>${tarefa.descricao}</td>
		        <c:if test="${tarefa.finalizado eq false}">
	    			<td>Não finalizado</td>
	    			<td><a	href="#" onclick="finalizaAgora(${tarefa.id})">
								Finalizar agora
				</a></td>
	   			</c:if>
	   			<c:if test="${tarefa.finalizado eq true}">
	    			<td>Finalizado</td>
	   			</c:if>
		        <td><fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/></td>
		      	<td><a href="deletaTarefa?id=${tarefa.id}" class="btn btn-info" role="button">Deletar</a></td>
		      </tr>
		      </c:forEach>
		      
		     </tbody>
		  </table>
		</div>

	</body>
</html>