		function myFunction(){


			

			let total = 0;

			let lances = document.getElementsByTagName('input');
	
			
			

			for (var i = 0; i < lances.length - 1; i++) {

						let num = parseFloat(lances[i].value);
						console.log(num);
						total = total +	num;
						
					}

			document.getElementById("resultado").value = total;


		}

		