<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${tarefa.id	eq 0}">
		<h3>Adicionar tarefas</h3>
	</c:if>
	<c:if test="${tarefa.id	> 0}">
		<h3>Alterar tarefas</h3>
	</c:if>
	<form action="adicionaTarefa" method="post">
		<input type="hidden" name="id" value="${tarefa.id}" />
		Descrição: <br />
		<textarea name="descricao" rows="5" cols="100">${tarefa.descricao}</textarea>
		<br /> 
		<input type="submit" value="${tarefa.id	eq 0 ? 'Adicionar' : 'Alterar'}">
	</form>
	
	<h4>Passagem de parâmetros</h4>
	<p>Parâmetro por objeto String = ${tipoParametroString}</p>
	<p>Parâmetro por texto direto = ${tipoParametroTextoDireto}</p>
	<p>Parâmetro int = ${tipoParametroInt}</p>
</body>
</html>