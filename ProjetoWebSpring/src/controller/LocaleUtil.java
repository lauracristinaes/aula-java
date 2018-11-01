package controller;

import java.util.Locale;

public class LocaleUtil {

	
	/** Armazena o locale a ser utilizado pelo sistema.*/
	private static Locale locale; 
	
	
	/**
	 * Obt�m o locale utilizado pela aplica��o.
	 * 
	 * @return Locale utilizado pela aplica��o.
	 */
	public static Locale getLocale() {
		
		if (locale == null) {
			
			locale = new Locale("pt", "BR");
			
		}
		
		return locale;
	}
}
