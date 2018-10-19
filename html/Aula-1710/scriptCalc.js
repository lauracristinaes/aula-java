

function Calc(){


var op = document.getElementById("operator").value;
	console.log(op);

var n1 = document.getElementById("num1").value;

var n2 = document.getElementById("num2").value;


	var resultado;

	if(op == "1"){
		resultado = parseInt(n1) + parseInt(n2);

	}else if(op == "2"){
		resultado = n1 - n2;

	}else if(op == "3"){
		resultado = n1 * n2;

	}else if(op == "4"){ 
		resultado = n1 / n2;

	}
	document.getElementById("resultado").innerHTML = resultado;
}