package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class testaCollection {
	
	public static void main(String[] args) {
		
		List<String> nomes;
		List<String> nomes2;
		
	nomes = new ArrayList<>();
	nomes2 = new ArrayList<>();
		
		
		
		
		nomes.add("Miguel");
		nomes2.add("Elise");
		
		nomes.addAll(nomes2);
		 Collections.sort(nomes);
		 
		 for(String nome : nomes) {
				
				//System.out.println(nome);
			}
		
		Set<String> times = new HashSet<>();
		times.add("Londrina");
		times.add("Corinthians");
		times.add("Corinthians");
		times.add("Santos");
		
		for(String time : times) {
			
			System.out.println(time);
		}
		
		
		Map<Integer, String> partidos = new HashMap<>();
		partidos.put(51, "Patriota");
		partidos.put(000, "teste");
		partidos.put(13, "PT");
		partidos.put(000, "teste");
		partidos.put(18, "Rede");
		partidos.put(12, "PDT");
		partidos.put(000, "teste");
		
		Set<Integer> chaves = partidos.keySet();
		
		for (Integer integer : chaves) {
			System.out.println(partidos.get(integer));
			System.out.println(integer);
		}
		
		Map<String, List<Integer>> notasAluno = new HashMap<>();
		notasAluno.put("José", Arrays.asList(1,2,3));
		notasAluno.put("Lidia", Arrays.asList(1,2,3));
		notasAluno.put("teste", Arrays.asList(1,2,3));
		
		Set<String>  chaves2 = notasAluno.keySet();
		
		for(String chave : chaves2) {
			  
		}
		
		List<Integer> notas = new ArrayList<>();
		notas.add(1);
		notas.add(2);
		notas.add(3);
		
		
		
		
	}

}
