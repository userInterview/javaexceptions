package throwing_classes ; 

import java.io.IOException ; 

import custom_Exceptions.LoizFirstCustomException ; 

public class CLDivide { 

	public CLDivide(int argnumerateur, int argdenominateur) throws LoizFirstCustomException	{
		foncDivide(argnumerateur, argdenominateur);
	}

	public void foncDivide(int i, int j)  throws LoizFirstCustomException {				
		
 		if (j==0) 	{
 			LoizFirstCustomException objLoizFirstCustomException =  new LoizFirstCustomException("Division par zero interdite") ;
 			
 			System.out.println(objLoizFirstCustomException.hashCode());
 			
 			throw objLoizFirstCustomException ; 			
 		}
 		
 		else
 			System.out.println(i / j) ; 
	}

}
