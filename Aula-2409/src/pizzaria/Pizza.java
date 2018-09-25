package pizzaria;

public class Pizza {

 public String tamanho;
 public int qntPedacos;
 public String sabor;
 public boolean borda;
 public String saborBorda;
 
 public void preencherBorda(boolean flag, String sabor) {
	 if(flag) {
		 this.sabor = sabor;
	 }
	 
 } 
}
