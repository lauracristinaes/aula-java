/**************Igualdade e Identidade*****************/

let valueOne = 3;
let valueTwo = "3";

if (valueOne == valueTwo) {

	console.log("valueOne and valueTwo are the same");
}else{
	console.log("valueOne and valueTwo are not the same")
}

if (valueOne === valueTwo) {

	console.log("valueOne and valueTwo are the same");
}else{
	console.log("valueOne and valueTwo are not the same")
}

/**************Retornando Type de uma Variável*****************/

let myString = "22";
console.log(typeof myString);

let myNum = 13;
console.log(typeof myNum);

let myParse = parseInt(myString);
console.log(typeof myParse);

let myToString = myNum.toString();
console.log(typeof myToString);

/***************Inicializando Objects****************/

let myObject = {};

myObject.firstName = "Laura";
myObject.lastName = "Santo";

console.log(myObject.firstName);

let myObjSec = {firstName:"Cristina", lastName: "Espírito"}
console.log(myObjSec.firstName);

let myOtherObj = new Object();
myOtherObj.firstName = "Elise";
myOtherObj.lastName = "Souza";
console.log(myOtherObj.firstName);


/***************Adicionando Métodos****************/

let Obj = {
	firstName : "Laura",
	age : 25,
	myInfo: function(){
		console.log("Meu nome é: " + this.firstName + ".");
		console.log("Minha idade é: " + this.age + ".");
	}

	//Obj.myInfo();
}

/***************Acessando Propriedades****************/

let myObj = {
	firstName: "Laura",
	surName: "Santo",
	age: 25
}

for(let prop in myObj){
	console.log(myObj[prop]);
}