
/**************Testando loops***************/
let i;

for(i = 0; i < 5; i++){
	console.log("O valor atual de i é " + i + ". Vamos continuar no loop porque " + i + "é menor que 5");
}

i = 0;

while(i < 10){
	console.log("The value of i is " + i);
	i++;
}

console.log("Looping concluído");


/**************Testando Arrays***************/

let myArray = [];
myArray[0] = "Andrew";
myArray[1] = "Monica";
myArray[2] = "Catie";
myArray[3] = "Jenna";
myArray[4] = "Christofer";

console.log("Item at index 0:" + myArray[0]);
console.log("Item at index 1:" + myArray[1]);
console.log("Item at index 2:" + myArray[2]);
console.log("Item at index 3:" + myArray[3]);
console.log("Item at index 4:" + myArray[4]);

let myArray2 = ["Andrew", "Monica", "Catie", "Jenna", "Christofer"];

for(let j = 0; j < myArray2.length; j++){
	console.log(myArray2[j]);
}

/**************Mudando CSS em tempo de execução***************/

function mudarCSS(){
	console.log("entrou na função");
	let x = document.getElementsByTagName("header");

	console.log(x);
	for(let m = 0; m < x.length; m++){
		console.log(x[m].style.color);
		x[m].style.color = "#81BEF7";
	}
}