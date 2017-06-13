package datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {

	private static int[] numCaracteres = new int [255];
	
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		File fichero = new File("ficheroExamen.txt");
		
		if (fichero.exists()) 
		{
			FileReader fr = null;
			BufferedReader br = null;
			
			try 
			{
				fr = new FileReader(fichero);
				br = new BufferedReader(fr);
				
				String linea;
				while ( (linea = br.readLine()) != null) 
				{
					comprobarLinea(linea);
				}
				
				mostrarResultado();
			} 
			
			catch (FileNotFoundException e) 
			{
				System.out.println(e.getMessage());
			}
			
			catch (IOException e) 
			{
				System.out.println(e.getMessage());
			}
			
			finally 
			{
				try 
				{
					br.close();
					fr.close();
				} 
				
				catch (IOException e) 
				{
					System.out.println(e.getMessage());
				}
				
			}
			
		}
		else 
		{
			System.out.println("FICHERO NO ENCONTRADO");
		}
		
		
		sc.close();
	}
	
	


	// M E T O D O S
	
	private static void comprobarLinea(String linea) 
	{
		int num = linea.length();
		numCaracteres[num]++;
		
	}
	
	private static void mostrarResultado() 
	{
		for (int i = 0; i < numCaracteres.length; i++) 
		{
			if (numCaracteres[i] != 0) 
			{
				System.out.println("CARACTERES: " + i + " LINEAS: " + numCaracteres[i]);
			}
		}
		
	}

}
