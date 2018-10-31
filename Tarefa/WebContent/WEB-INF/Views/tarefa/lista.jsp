<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 <c:forEach var="tarefa" items="${tarefas}">
  <tr>
   <td>${tarefa.id}</td>
   <td>Descri��o: ${tarefa.descricao}</td>
   <c:if test="${tarefa.finalizado eq false}">
    <td>N�o finalizado</td>
   </c:if>
   <c:if test="${tarefa.finalizado eq true}">
    <td>Finalizado</td>
   </c:if>
   <td><fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
   </td>
  </tr>
 </c:forEach>

</body>
</html>