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
		<form>
		  <div class="form-row">
		  <div class="form-group col-md-6">
		      <label for="nome">Nome</label>
		      <input type="text" class="form-control" id="nome" placeholder="Nome do Aluno">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="cpf">CPF</label>
		      <input type="number" class="form-control" id="cpf" placeholder="000.000.000-00">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="inputEmail4">Email</label>
		      <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="inputPassword4">Telefone</label>
		      <input type="number" class="form-control" id="inputPassword4" placeholder="Telefone">
		    </div>
		      <div class="form-group col-md-6">
		   <label for="dtNasc">Data de Nascimento:</label>
		    <input type="date" class="form-control" name="dtNasc">
		  </div>
		  <div class="form-group col-md-6">
		    <label for="sexo" class="inline">Sexo</label>
		    <input type="radio" name="sexo" value=0 checked> Homem<br>
 			<input type="radio" name="sexo" value=1> Mulher<br>
		  </div>
		  <div class="form-group col-md-6">
		      <label for="curso">Curso</label>
		      <input type="text" class="form-control" id="curso" placeholder="Nome do Aluno">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="matricula">Matricula</label>
		      <input type="number" class="form-control" id="matricula" placeholder="000000000">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="endereco">Endereço</label>
		    <input type="text" class="form-control" id="endereco" placeholder="">
		  </div>
		  
		
		  <div class="form-group">
		    <div class="form-check">
		      <input class="form-check-input" type="checkbox" id="gridCheck">
		      <label class="form-check-label" for="gridCheck">
		        Check me out
		      </label>
		    </div>
		  </div>
		  <button type="submit" class="btn btn-primary">Sign in</button>
		</form>
	
	</body>
</html>