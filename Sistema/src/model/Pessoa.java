package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Pessoa {
	
	@Id
    @GeneratedValue
	private	Long id;
	
	private String nome;
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Date dtNasc;
	private String endereco;
	private boolean sexo; //true = mulher; false = homem
	private String telefone;
	private String email;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String name) {
		this.nome = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDtNasc() {
		
		return dtNasc;
	}
	
public String getDtNascString() {
	
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	String dtN;
	dtN = date.format(dtNasc);
		
		return dtN;
	}
	
	public void setDtNascDate(Date dtNasc) {
		System.out.println("recebeu data date:" + dtNasc);
		this.dtNasc = dtNasc;
	}
	
	public void setDtNasc(String dtString) {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		date.setLenient(false); // data inválida! Não vai parsear
		Date dtN = new Date();
		System.out.println("recebeu data string: " + dtString);
		try {
			System.out.println("entrou no try ");
			dtN = date.parse(dtString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dtNasc = dtN;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean validaCPF() {
		
		String cpf = this.getCpf().replaceAll("[^0123456789]", "");
		System.out.println("cpf = " + cpf);
		
		//cpf deve ter 11 digitos
		if(cpf.length() != 11) {
			System.out.println("não tem 11 digitos");
			return false;
		}
		
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (cpf.equals("00000000000") ||
				cpf.equals("11111111111") ||
				cpf.equals("22222222222") || cpf.equals("33333333333") ||
				cpf.equals("44444444444") || cpf.equals("55555555555") ||
				cpf.equals("66666666666") || cpf.equals("77777777777") ||
				cpf.equals("88888888888") || cpf.equals("99999999999") ) {
		            return(false);
			}
			
			char dig10, dig11;
	        int sm, i, r, num, peso;
	        
	        try {
	            // Calculo do 1o. Digito Verificador
	        	/*
	        	 * Cada um dos nove primeiros números do CPF é multiplicado por um peso
	        	 * que começa de 10 e que vai sendo diminuido de 1 a cada passo,
	        	 * somando-se as parcelas calculadas:
				 * sm = (5*10)+(4*9)+(6*8)+(4*7)+(7*6)+(1*5)+(4*4)+(2*3)+(9*2) = 249;
				 * Calcula-se o dígito através da seguinte expressão:
				 * 11 - (sm % 11) = 11 - (249 % 11) = 11 - 7 = 4
				 * obs. Se o resto da divisão (operador %) calculado for 10 ou 11,
				 * o dígito verificador será 0; nos outros casos,
				 * o dígito verificador é o próprio resto.
	        	 * */
	                sm = 0;
	                peso = 10;
	                for (i=0; i<9; i++) {              
	            // converte o i-esimo caractere do CPF em um numero:
	            // por exemplo, transforma o caractere '0' no inteiro 0         
	            // (48 eh a posicao de '0' na tabela ASCII)         
	                num = (int)(cpf.charAt(i) - 48); 
	                sm = sm + (num * peso);
	                peso = peso - 1;
	                }
	              
	                r = 11 - (sm % 11);
	                if ((r == 10) || (r == 11))
	                    dig10 = '0';
	                else dig10 = (char)(r + 48); // converte no respectivo caracter numérico
	                
	             // Calculo do 2o. Digito Verificador
	                /*
	                 * Cada um dos dez primeiros números do CPF,
	                 * considerando-se aqui o primeiro DV,
	                 * é multiplicado por um peso que começa de 11
	                 * e que vai sendo diminuido de 1 a cada passo,
	                 * somando-se as parcelas calculadas:
	                 * sm = (5*11)+(4*10)+(6*9)+(4*8)+(7*7)+(1*6)+(4*5)+(2*4)+(9*3)+(4*2) = 299;
	                 * Calcula-se o dígito através da seguinte expressão:
	                 * 11 - (sm % 11) = 11 - (299 % 11) = 11 - 2 = 9
	                 * obs. se o resto da divisão (operador %) calculado for 10 ou 11, 
	                 * o dígito verificador será 0;
	                 * nos outros casos, o dígito verificador é o próprio resto.
	                 * */
	                sm = 0;
	                peso = 11;
	                for(i=0; i<10; i++) {
	                num = (int)(cpf.charAt(i) - 48);
	                sm = sm + (num * peso);
	                peso = peso - 1;
	                }
	              
	                r = 11 - (sm % 11);
	                if ((r == 10) || (r == 11))
	                     dig11 = '0';
	                else dig11 = (char)(r + 48);
	                return true;
                
        } catch (InputMismatchException erro) {
            return(false);
        }
                
		
	}
	

}
