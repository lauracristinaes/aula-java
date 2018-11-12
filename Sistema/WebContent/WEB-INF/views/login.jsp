<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
			
<title>Login</title>
</head>
<body>

<div class="container">
<h1>Login</h1>
<form action="efetuaLogin" method="post">
  <div class="form-group">
    <label for="usuarip">Login </label>
    <input type="text" class="form-control" name="usuario" id="usuario"  placeholder="Login">
    
  </div>
  <div class="form-group">
    <label for="senha">Senha </label>
    <input type="password" class="form-control" name="senha" id="senha" placeholder="******">
  </div>

  <button type="submit" class="btn btn-primary">Entrar</button>
</form>
</div>
</body>
</html>