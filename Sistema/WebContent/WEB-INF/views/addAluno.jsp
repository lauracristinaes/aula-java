<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
			
		<title>Adicionar Aluno</title>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
		<script	type="text/javascript">
		    $(document).ready(function () { 
		        var $Cpf = $("#cpf");
		        $Cpf.mask('000.000.000-00', {reverse: true});
		    });
		</script>

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
				<label class="radio-inline"><input type="radio" name="sexo" value="0" checked>Masculino</label>
				<label class="radio-inline"><input type="radio" name="sexo" value="1">Feminino</label>
			</div>
	
			 <div class="form-group col-md-6">
			    <label for="cpf">CPF:</label>
			    <input type="text" class="form-control" id= "cpf" name="cpf" placeholder="000.000.000-00">
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
				<label for="curso">Curso</label>
				 <select name="curso" class="form-control">
				    <option selected value = 1>Java Web</option>
				    <option value = 2>Cobol</option>
				    <option value = 3>.NET</option>
				    <option value = 4>Redes</option>
				    <option value = 5>Phyton</option>
				</select>
			</div>

  				<button type="submit" class="btn btn-primary">Enviar</button>
			</form>
		</div>
	
	</body>
</html>