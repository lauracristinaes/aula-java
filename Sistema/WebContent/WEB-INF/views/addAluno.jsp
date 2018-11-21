<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
			
		<title>Adicionar Aluno</title>
		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
		<script	type="text/javascript">
		    $(document).ready(function () { 
		        var $Cpf = $("#cpf");
		        $Cpf.mask('000.000.000-00', {reverse: true});
		    });
		</script>

	</head>
	<body>

		<c:choose>
			<c:when test="${empty(aluno)}"><h1>Adicionar Novo Aluno</h1></c:when>			        
			<c:otherwise><h1>Editar Aluno</h1></c:otherwise>
		</c:choose>
		
		
		
		<div class="container">
		<form action="adicionaAluno" method="post">
		
			<input type="hidden" id="novo" name="novo"
				<c:choose>
	                    <c:when test="${empty(aluno)}"> value="novo" </c:when>                 
	                    <c:otherwise> value="existente"</c:otherwise>
	             </c:choose>>
	             
	           
	             
	        <div class="form-group col-md-6">
			    <label for="id">Id:</label>
			    <c:choose>
					<c:when test="${empty(aluno)}"> <input type="text" class="form-control" name="id" placeholder="Id"></c:when>			        
					<c:otherwise> <input type="text" class="form-control" name="id" value="${aluno.id}"></c:otherwise>
				</c:choose>
			   
			</div>
			
	  		<div class="form-group col-md-6">
			    <label for="nome">Nome:</label>
			    <c:choose>
					<c:when test="${empty(aluno)}"> <input type="text" class="form-control" name="nome" placeholder="Nome do Aluno"></c:when>			        
					<c:otherwise> <input type="text" class="form-control" name="nome" value="${aluno.nome}"></c:otherwise>
				</c:choose>
			   
			</div>
	  
			 <div class="form-group col-md-4">
			 	<label for="sexo">Sexo:</label>
				<label class="radio-inline"><input type="radio" name="sexo" value="0" <c:if test = "${!empty(aluno) and aluno.sexo == false}"> checked </c:if>>Masculino</label>
				<label class="radio-inline"><input type="radio" name="sexo" value="1"<c:if test = "${!empty(aluno) and aluno.sexo == true}"> checked </c:if>>Feminino</label>
			</div>
	
			 <div class="form-group col-md-6">
			    <label for="cpf">CPF:</label>
			    <c:choose>
					<c:when test="${empty(aluno)}"> <input type="text" class="form-control" id= "cpf" name="cpf" placeholder="000.000.000-00"></c:when>			        
					<c:otherwise> <input type="text" class="form-control" name="cpf" value="${aluno.cpf}"></c:otherwise>
				</c:choose>
			    
			 </div>
	
			 <div class="form-group col-md-6">
			    <label for="dtNasc">Data de Nascimento:</label>
			    <c:choose>
                    <c:when test="${empty(aluno)}"> <input type="date" class="form-control" name="dtNasc" value=""> </c:when>                 
                    <c:otherwise> <input type="date" class="form-control" name="dtNasc" value="${aluno.dtNasc}"> </c:otherwise>
                </c:choose>
			  
			 </div>
	
	
			 <div class="form-group col-md-10">
			    <label for="endereco">Endereço:</label>
			    <c:choose>
                    <c:when test="${empty(aluno)}"> <input type="text" class="form-control" name="endereco" placeholder="Rua, num, bairro"> </c:when>                 
                    <c:otherwise> <input type="text" class="form-control" name="endereco" value="${aluno.endereco}"> </c:otherwise>
                </c:choose>
            </div>
	
			 <div class="form-group col-md-6">
			    <label for="email">Email:</label>
			    <c:choose>
                    <c:when test="${empty(aluno)}"> <input type="email" class="form-control" name="email" placeholder="nome@exemplo.com"> </c:when>                 
                    <c:otherwise> <input type="email" class="form-control" name="email" value="${aluno.email}"> </c:otherwise>
                </c:choose>
			</div>
	
	
			 <div class="form-group col-md-6">
			    <label for="telefone">Telefone:</label>
			    <c:choose>
                    <c:when test="${empty(aluno)}"> <input type="text" class="form-control" name="telefone" placeholder="(00)00000-0000"> </c:when>                 
                    <c:otherwise> <input type="text" class="form-control" name="telefone" value="${aluno.telefone}"> </c:otherwise>
                </c:choose>
			 </div>
	
	
			 <div class="form-group col-md-6">
			    <label for="matricula">Matricula:</label>
			    <c:choose>
                    <c:when test="${empty(aluno)}"> <input type="text" class="form-control" name="matricula" placeholder="000000000"> </c:when>                 
                    <c:otherwise> <input type="text" class="form-control" name="matricula" value="${aluno.matricula}"> </c:otherwise>
                </c:choose>
			</div>


			<div class="form-group col-md-4">
				<label for="curso">Curso</label>
				 <select name="curso" class="form-control">
				    <option <c:if test = "${!empty(aluno) and aluno.curso ==1}"> selected </c:if> value = 1>Java Web</option>
				    <option <c:if test = "${!empty(aluno) and aluno.curso ==2}"> selected </c:if> value = 2>Cobol</option>
				    <option <c:if test = "${!empty(aluno) and aluno.curso ==3}"> selected </c:if> value = 3>.NET</option>
				    <option <c:if test = "${!empty(aluno) and aluno.curso ==4}"> selected </c:if> value = 4>Redes</option>
				    <option <c:if test = "${!empty(aluno) and aluno.curso ==5}"> selected </c:if> value = 5>Phyton</option>
				</select>
			</div>

  				<button type="submit" class="btn btn-primary">Enviar</button>
			</form>
		</div>
	
	</body>
</html>