<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
		
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	
	<title>Adicionar Tarefa</title>
	</head>
	
	<body>
	
		<form action="adicionaTarefa" method="post">
		  <div class="form-group">
		    <label for="descricao">Descrição:</label>
		    <input type="descricao" class="form-control" name="descricao">
		  </div>
		  <div class="form-group">
		    <label for="pwd">Data de Finalização:</label>
		    <input type="date" class="form-control" name="dtFinalizacao">
		  </div>
		  <button type="submit" class="btn btn-default">Adicionar</button>
		</form>
		
			
	
	</body>
</html>