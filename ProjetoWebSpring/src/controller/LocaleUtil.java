package controller;

import java.util.Locale;

public class LocaleUtil {

	
	/** Armazena o locale a ser utilizado pelo sistema.*/
	private static Locale locale; 
	
	
	/**
	 * Obtém o locale utilizado pela aplicação.
	 * 
	 * @return Locale utilizado pela aplicação.
	 */
	public static Locale getLocale() {
		
		if (locale == null) {
			
			locale = new Locale("pt", "BR");
			
		}
		
		return locale;
	}
}
