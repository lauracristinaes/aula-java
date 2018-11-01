package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe para conversão de datas
 */
public class DataUtil {
	
	/**
	 * Método que converte a data do objeto java.util.Date para a data com o objeto
	 * java.sql.Date que é usada pelo banco de dados. 
	 * @param data Data  
	 * @return Data
	 */
	public static java.sql.Date converteDataBanco(Date data) {
		return new java.sql.Date(data.getTime());
	}
	
	/**
	 * Converte data do banco para data da aplicação
	 * @param data Data
	 * @return Data
	 */
	public static Date converteDataAppl(java.sql.Date data) {
		return new Date(data.getTime());
	}
	
	/**
	 * Converte a tada em uma mascara especifica
	 * 
	 * @param data Date
	 * @param mascara Mascara ex: 'dd/MM/YYYY'
	 * @return String
	 */
	public static String formataData(Date data, String mascara) {
		
		String retorno = "";
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(mascara,LocaleUtil.getLocale());
			retorno = sdf.format(data);
		} catch (Exception e) {
			retorno = "";
		}
		
		return retorno;
	}
	
	/**
	 * Formata a data com a máscara dd/MM/yyyy HH:mm:ss
	 * @param data
	 * @return
	 */
	public static String formataDDMMYYYYHHMMSS(Date data) {
		return formataData(data, "dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * Formata a data com a máscara dd de M de yyyy
	 * @param data
	 * @return
	 */
	public static String formataDDMMMMYYYY(Date data) {
		return formataData(data, "dd 'de' MMMM 'de' yyyy");
	}
	
	/**
	 * Formata a data com a máscara dd/MM/yyyy
	 * @param data
	 * @return
	 */
	public static String formataDDMMYYYY(Date data) {
		return formataData(data, "dd/MM/yyyy");
	}
	
	/**
	 * Formata a data com a máscara HH:mm
	 * @param data
	 * @return
	 */
	public static String formataHHmm(Date data) {
		return formataData(data, "HH:mm");
	}
	/**
	 * Parse da data em formato String para objeto date
	 * @param data String 
	 * @param mascara String
	 * @return Date
	 * @throws NegocioExcepition ERRO!
	 */
	public static Date parseData(String data, String mascara) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(mascara,LocaleUtil.getLocale());
			return sdf.parse(data);
		} catch (Exception e) {
			System.out.println("Erro ao converter data. Data: " + data + ", mascara: " + mascara);
			return null;
		}
	}
	
	/**
	 * Parse da string no formato dd/MM/yyyy para um objeto Date
	 * @param data String
	 * @return Date
	 * @throws NegocioExcepition ERRO!
	 */
	public static Date parseDDMMYYYY(String data) {
		return parseData(data, "dd/MM/yyyy");
	}
	
	/**
	 * Parse da string no formato dd/MM/yyyy HH:mm:ss para um objeto Date
	 * @param data String
	 * @return Date
	 * @throws NegocioExcepition ERRO!
	 */
	public static Date parseDDMMYYYYHHMMSS(String data) {
		return parseData(data, "dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * Retorna a data atual
	 * @return Date
	 */
	 public static Date getDataAtual() {
	  
	  Date dataAtual = new Date();
	  
//	  Logger.getLogger(DataUtil.class).info("Retornando data atual: " + dataAtual);
	  
	  return dataAtual;
	 }
	
	/**
	 * Retorna a data atual com as informações de horário zerado
	 * @return Date
	 */
	public static Date getDataAtualHorarioZerado() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDataAtual());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * Verifica se o o dia atual é sabado ou domingo
	 * @return boolean
	 */
	public static boolean isFinalSemana() {
		boolean finalSemana = false;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDataAtual());
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			finalSemana = true;
		}
		return finalSemana;
	}
	
	/**
	 * Verifica se o o dia atual é sabado ou domingo
	 * @return boolean
	 */
	public static boolean isDomingo() {
		boolean isDomingo = false;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDataAtual());
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			isDomingo = true;
		}
		return isDomingo;
	}
	
	/**
	 * Adiciona dias úteis a uma data
	 * 
	 * @param data Data
	 * @param qtdeDiasAcrescentados Dias
	 * @return Data adicionada dias úteis
	 */
	public static Date adicionarDiasUteis(Date data, Integer qtdeDiasAcrescentados) {  
	    Calendar dataInicial = Calendar.getInstance();  
	    dataInicial.setTime(data);  
	    while(qtdeDiasAcrescentados > 0){  
	        dataInicial.add(Calendar.DAY_OF_MONTH, 1);  
	        int diaDaSemana = dataInicial.get(Calendar.DAY_OF_WEEK);  
	        if (diaDaSemana != Calendar.SATURDAY && diaDaSemana != Calendar.SUNDAY) {  
	            --qtdeDiasAcrescentados;  
	        }  
	    }  
	    return dataInicial.getTime();  
	}
	
	/**
	 * Adiciona dias ate chegar em determinado dia da semana
	 * 
	 * @param data Data que sera incrementada
	 * @param proximoDiaDaSemana Determinado dia da semana (Ex: Domingo = 1; Segunda = 2; Terca = 3; Sabado = 7)
	 * @return Data adicionada dias úteis
	 */
	public static Date adicionarDiasAteProximoDiaDaSemana(Date data, int proximoDiaDaSemana) {  
	    Calendar dataInicial = Calendar.getInstance();  
	    dataInicial.setTime(data);  
	    dataInicial.add(Calendar.DAY_OF_MONTH, 1);//adiciona no minimo 1 dia, caso a data da confirmacao seja o proximo dia da semana desejado
        int diaDaSemana = dataInicial.get(Calendar.DAY_OF_WEEK);
        
	    while(diaDaSemana != proximoDiaDaSemana){  
	        dataInicial.add(Calendar.DAY_OF_MONTH, 1);  
	        diaDaSemana = dataInicial.get(Calendar.DAY_OF_WEEK);  
	    }  
	    return dataInicial.getTime();  
	}
	
	/**
	 * Adiciona uma hora na data
	 * @return Date
	 */
	public static Date adicionarUmaHora(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.HOUR_OF_DAY, 1);
		return calendar.getTime();
	}
	
	/**
	 * Adiciona meses a data atual
	 * @param mes núemro de meses a ser adicionado
	 * @return Data
	 */
	public static Date adicionarMes(int mes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDataAtualHorarioZerado());
		calendar.add(Calendar.MONTH, mes);
		return calendar.getTime();
	}

	/**
	 * Soma dias em uma determinada data
	 * 
	 * @param data Date
	 * @param qtdDias int
	 * @return Nova data
	 */
	public static Date somarDias(Date data, int qtdDias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.DAY_OF_MONTH, qtdDias);
		return calendar.getTime();
	}
	
	/**
	 * Soma semana em uma determinada data
	 * 
	 * @param data Date
	 * @param qtdSemana int
	 * @return Nova data
	 */
	public static Date somarSemana(Date data, int qtdSemana) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.WEEK_OF_MONTH, qtdSemana);
		return calendar.getTime();
	}	
	
	/**
	 * Retonar uma data com um dia especificado por parametro
	 * 
	 * @param data Date
	 * @param dia int
	 * @return Nova data com o dia especificado
	 */
	public static Date retonarDataComDiaEspecifico(Date data, int dia) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.set(Calendar.DAY_OF_MONTH, dia);
		return calendar.getTime();
	}	
	
	/**
	 * Retorna a diferença de dias entre 2 datas
	 * @param Date data inicial para comparação
	 * @param Date data final para comparação
	 * @return int Diferença entre as datas em dias
	 */
	public static int obterDiferencaDeDiasEntreDatas(Date dataInicial, Date dataFinal) {
		
		int dias = 0;
		
		Calendar calDataInicial = Calendar.getInstance();
		calDataInicial.setTime(dataInicial);
		
		// Zera horário
		calDataInicial.set(Calendar.HOUR_OF_DAY, 0);
		calDataInicial.set(Calendar.MINUTE, 0);
		calDataInicial.set(Calendar.SECOND, 0);
		calDataInicial.set(Calendar.MILLISECOND, 0);
		
		Calendar calDataFinal = Calendar.getInstance();
		calDataFinal.setTime(dataFinal);
		
		// Zera horário
		calDataFinal.set(Calendar.HOUR_OF_DAY, 0);
		calDataFinal.set(Calendar.MINUTE, 0);
		calDataFinal.set(Calendar.SECOND, 0);
		calDataFinal.set(Calendar.MILLISECOND, 0);

		long tempoRestante = calDataFinal.getTimeInMillis() - calDataInicial.getTimeInMillis();
		
		dias = (int) (tempoRestante / (1000 * 60 * 60 * 24));
		if (dias == 0) {
			dias = 1;
		} else if (dias < 0) {
			dias = dias * -1;
		}

		return dias;
	}
	
	public static int pegarUltimoDiaMes(int mes, int ano) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(DataUtil.parseData("01/"+mes+"/"+ano, "dd/MM/yyyy"));
		         
		return cal.getActualMaximum( Calendar.DAY_OF_MONTH );
	}
	
	public static String getMesExtenso(int mes) {
    	if(mes == 1) {
			return "Janeiro";
		}else if(mes == 2) {
			return "Fevereiro";
		}else if(mes == 3) {
			return "Mar&ccedil;o";
		}else if(mes == 4) {
			return "Abril";
		}else if(mes == 5) {
			return "Maio";
		}else if(mes == 6) {
			return "Junho";
		}else if(mes == 7) {
			return "Julho";
		}else if(mes == 8) {
			return "Agosto";
		}else if(mes == 9) {
			return "Setembro";
		}else if(mes == 10) {
			return "Outubro";
		}else if(mes == 11) {
			return "Novembro";
		}else if(mes == 12) {
			return "Dezembro";
		}
    	return "";
    }
}
