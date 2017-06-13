package datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio4 {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		/*Escribir un programa que dado un texto de un telegrama que termina en punto:
-contar la cantidad de palabras que posean mas de 10 letras
-la posocion inicial de la palabra mas larga
- reportar el porcentaje de espacios en blanco con respecto al total de caracteres
- cuantas palabras con una longitud entre 8 y 16 caracteres poseen más de tres veces la vocal “a”*/
		
		File telegrama = new File("telegrama.txt");
		FileReader fr = null;
		BufferedReader br = null;
		
		try 
		{
			fr = new FileReader(telegrama);
			br = new BufferedReader(fr);
			
			String linea = null;
			
			linea = br.readLine();
			String[] palabras = linea.split(" ");
			int masDeDiez = 0, pos = 0, espacios = 0, aes = 0, caracteres = 0, palabrasConAes = 0, caracteresTotales = 0;
			float porcentajeEspacios;
			
			caracteresTotales=linea.length();
			
			for (int i = 0; i < palabras.length; i++) 
			{
				if (palabras[i].length() > 10) 
				{
					masDeDiez++;
				}
				
				if (i != 0) 
				{
					if ( palabras[i].length() > palabras[i - 1].length() ) 
					{
						pos = i;
						caracteres += palabras[i].length();
						
						if (condition) 
						{
							
						}
					}
				}
			}
		}
		
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		finally 
		{
			
		}
		
		
		
		
		
		
		sc.close();
	}

}
