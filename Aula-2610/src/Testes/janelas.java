package Testes;

import javax.swing.JOptionPane;

public class janelas {
	
	public static void main(String[] args) {
		
		String name = JOptionPane.showInputDialog("What is your name?");
		String message = String.format("Welcome, %s, to Java Programming!", name);
		// exibe a mensagem para cumprimentar o usuário pelo nome

		JOptionPane.showMessageDialog(null, message);
	}

}
