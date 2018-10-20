/*

Montar um objeto contendo os seguintes atributos:
Nome
DataNascimento
LocalNascimento
Endereco
Pai
	Nome
	DataNascimento
	LocalNascimento
	Endereco
	Filhos
		Nome
		DataNascimento
		LocalNascimento
		Endereco
		NomePai
		NomeMae
Mae (igual ao pai)


*/

let myObject = {

	Nome: "Laura",
	DataNascimento: "26/12/1992",
	LocalNascimento: "Londrina",
	Endereco: "Jd Sabara",
	Pai: {
		Nome: "XXX",
		DataNascimento: "00/00/0000",
		LocalNascimento: "Desconhecido",
		Endereco: "Não encontrado",
		Filhos: {
			Nome: "teste",
			DataNascimento: "00/00/0000",
			LocalNascimento: "Desconhecido",
			Endereco: "Não encontrado",
			NomePai: "XXX",
			NomeMae:  "OOO"

		}
	},
	Mae: {
		Nome: "XXX",
		DataNascimento: "00/00/0000",
		LocalNascimento: "Desconhecido",
		Endereco: "Não encontrado",
		Filhos: {
			Nome: "teste",
			DataNascimento: "00/00/0000",
			LocalNascimento: "Desconhecido",
			Endereco: "Não encontrado",
			NomePai: "XXX",
			NomeMae:  "OOO"

		}
	}


}







for(let prop in myObject){
	console.log(myObject[prop]);
}