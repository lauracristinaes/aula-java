package arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Gravar {
	
	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\FTI\\Documents\\Laura\\teste2.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write("testando gravar em arquivo \r testando quebra de linha \r mais uma linha");
			fw.close();
			FileReader fr = new FileReader(file); 
			BufferedReader bf = new BufferedReader(fr);
			
			String s = bf.readLine();
			while(s != null) {
				System.out.println(s);
				s = bf.readLine();
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fw != null) {
				try {
					fw.close();					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
