package User;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {
	
	List<String> preferences;
	
	public User() {
		preferences = new ArrayList<>();
		
		for(String nome : preferences) {
			
			System.out.println(nome);
		}
		
	}
}
