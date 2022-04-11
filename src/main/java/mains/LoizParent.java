package mains;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LoizParent {
	
	public static void readFile(String strChemin) throws FileNotFoundException {
		
		File objFile = new File(strChemin) ;
		
//		try {
			
			FileReader objFileReader = new FileReader(objFile) ;
			
//		} catch (FileNotFoundException e) {
//			System.out.println(e.getLocalizedMessage());
//		}
		
		
		
	}	

}
