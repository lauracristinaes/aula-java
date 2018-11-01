<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<a href="novaTarefa">Criar nova tarefa</a>
	<br />
	<br />
	<table>
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizado?</th>
			<th>Data de finalização</th>
		</tr>
		<c:forEach items="${tarefas}" var="tarefa">
			<tr>
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
				<c:if test="${tarefa.finalizado	eq	false}">
					<td>Não finalizado</td>
					<td><a href="#" onclick="finalizaAgora(${tarefa.id})">Finalizar $get</a></td>
					<td><a href="#" onclick="finalizaAgoraPost(${tarefa.id})">Finalizar $post</a></td>
					<td><a href="#" onclick="finalizaAgoraAjax(${tarefa.id})">Finalizar $ajax</a></td>
				</c:if>
				<c:if test="${tarefa.finalizado	eq	true}">
					<td>Finalizado</td>
				</c:if>
				<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
				<td><a href="editaTarefa?id=${tarefa.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
		$(document).ready(function(e){
			alert("Recarregando a página");
		});
		
		function finalizaAgora(id) {
			$.get("finalizaTarefa?id=" + id, function(dadosDeResposta) { 
				alert("Tarefa Finalizada .get!");
				return false;
			});
		}
		function finalizaAgoraPost(id) {
			$.post("finalizaTarefa?id=" + id, function(dadosDeResposta) { 
				alert("Tarefa Finalizada .post!");
				return false;
			});
		}
		function finalizaAgoraAjax(id) {
		   var data = {
				   idTeste: id,
				   parametroTeste: 'parametroAserEnviado'
        			};   
						   
			$.ajax({
				url:"finalizaTarefa?id=" + id,
				type: "POST",
				async:false,
				data: data,
				dataType:"json",
			    cache: true,
				contentType: 'application/x-www-form-urlencoded; charset=iso-8859-1;', 
				success: function(resultado){
					alert(resultado);
					if(resultado == "0"){
						alert("Tarefa Finalizada .ajax!");
						return false;
					} else {
						alert("Erro na execução .ajax!");
					}
				}
			});
		}
	</script>
</body>
</html>
