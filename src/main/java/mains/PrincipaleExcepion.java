package mains;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;

import custom_Exceptions.LoizFirstCustomException;
import gesterreurs.ClientException;
import throwing_classes.CLDivide;

public class PrincipaleExcepion extends LoizParent {

	public static void main(String[] argv) 
													throws 
													IOException
													//,LoizFirstCustomException
	//												FileNotFoundException 
	{

//		Consumer<String> objConStr = firstErrorMessageEncountered -> {
//			throw new ClientException(HttpStatus.BAD_REQUEST, firstErrorMessageEncountered);
//		};
//		objConStr.accept("mon message d'erreur");

		File objFileKO = new File("c:\\fichier.txt") ;
		File objFile_OK = new File("c:\\Drive.txt") ;
		
		try {
			FileReader objFileReader = new FileReader(objFileKO) ;
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		}
		
		int i = 1;
		int j = 0;
		
		try {
			i = 4 ;
			readFile("c:\\fichier.txt") ; 	
			System.out.println(i / j);
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}	
		
		
		try {
			CLDivide objCLDivide = new CLDivide(i,j) ;
		}
		catch (LoizFirstCustomException e) {
			System.out.println(e.hashCode()) ;
			e.printStackTrace();
		}
		
		
		try {
		readFile("c:\\fichier.txt") ; 		
		}		
		catch (FileNotFoundException fne) {
			System.out.println(fne.getMessage());
		}

		foncDivide(1,0) ;


	}
	
	public static void foncDivide(int i, int j) throws ArithmeticException {
 		System.out.println(i / j) ;
	}
	
	private static  void Affiche(String strTitle ) {
		System.out.println("\n"+ strTitle);
	}
	
	private static  void loizStrSep() {				
		System.out.println("-------------------------------");
	}
}
