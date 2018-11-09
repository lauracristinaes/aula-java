<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
			
		<title>Adicionar Aluno</title>

	</head>
	<body>
		<h1>Adicionar Novo Aluno</h1>
		<div class="container">
		<form action="adicionaAluno" method="post">
	  		<div class="form-group col-md-6">
			    <label for="nome">Nome:</label>
			    <input type="text" class="form-control" name="nome" placeholder="Nome do Aluno">
			</div>
	  
			 <div class="form-group col-md-4">
			 	<label for="sexo">Sexo:</label>
				<label class="radio-inline"><input type="radio" name="sexo" checked>Masculino</label>
				<label class="radio-inline"><input type="radio" name="sexo">Feminino</label>
			</div>
	
			 <div class="form-group col-md-6">
			    <label for="cpf">CPF:</label>
			    <input type="number" class="form-control" name="cpf" placeholder="000.000.000-00">
			 </div>
	
			 <div class="form-group col-md-6">
			    <label for="dtNasc">Data de Nascimento:</label>
			    <input type="date" class="form-control" name="dtNasc">
			 </div>
	
	
			 <div class="form-group col-md-10">
			    <label for="endereco">Endereço:</label>
			    <input type="text" class="form-control" name="endereco" placeholder="Rua, num, bairro">
			 </div>
	
			 <div class="form-group col-md-6">
			    <label for="email">Email:</label>
			    <input type="email" class="form-control" name="email" placeholder="nome@exemplo.com">
			 </div>
	
	
			 <div class="form-group col-md-6">
			    <label for="telefone">Telefone:</label>
			    <input type="number" class="form-control" name="telefone" placeholder="(00)00000-0000">
			 </div>
	
	
			 <div class="form-group col-md-6">
			    <label for="matricula">Matricula:</label>
			    <input type="text" class="form-control" name="matricula" placeholder="000000000">
			 </div>


			<div class="form-group col-md-4">
				<label for="inputEstado">Curso</label>
				 <select name="inputEstado" class="form-control">
				    <option selected>Java Web</option>
				    <option>Cobol</option>
				    <option>.NET</option>
				    <option>Redes</option>
				    <option>Phyton</option>
				</select>
			</div>

  				<button type="submit" class="btn btn-primary">Enviar</button>
			</form>
		</div>
	
	</body>
</html>