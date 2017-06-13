package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		/*2. Se le debe pedir al usuario que ingrese el nombre de un archivo, leer línea a línea,
		 *  invertir cada una de las líneas y guardar todo en un archivo cuyo nombre debe ingresar
		 *   el usuario.*/
		
		System.out.print("NOMBRE DEL ARCHIVO (SIN EXTENSION): ");
		String nombreArchivo = sc.next() + ".txt";
		
		File fichero = new File(nombreArchivo);
		String linea = " ";
		
		if (fichero.exists()) 
		{
			FileReader fr = null;
			BufferedReader br = null;
			
			try 
			{
				
				fr = new FileReader(fichero);
				br = new BufferedReader(fr);
				
				if ( (linea = br.readLine() ) != null) 
				{
					
				}
			} 
			
			catch (IOException e) 
			{
				System.out.println(e.getMessage());

			}
		}
		else 
		{
			System.out.print("ARCHIVO INEXISTENTE, ¿DESEA CREARLO? (S/N) ");
			boolean respuesta = sc.next().equalsIgnoreCase("S");
			if (respuesta) 
			{
				FileWriter fw = null;
				BufferedWriter bw = null;
				
				try 
				{
					fw = new FileWriter(fichero);
					bw = new BufferedWriter(fw);
					
					String siNo = "";
					
					do {
						System.out.print("TEXTO: ");
						String texto = sc.next();
						linea += texto + ".";
						
						bw.write(linea);
						bw.newLine();
						bw.flush();
						linea = "";
						
						System.out.print("¿DESEA CONTINUAR (S/N) ?");
						siNo = sc.next();
						
						
						
					} while (siNo.equalsIgnoreCase("S"));
				} 
				
				catch (IOException e) 
				{
					System.out.println(e.getMessage());	
				}
				
				
			}
		}
		
		
		
		sc.close();	
	}

}
