package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.plaf.synth.Region;

public class Ejercicio1 {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// NOMBRE DEL FICHERO
		System.out.print("NOMBRE FICHERO: ");
		String nombreFichero = sc.next();
		
		// CREACION DE LOS METODOS PARA ESCRIBIR Y LEER
		escribirEnFichero(nombreFichero);
		
		leerDeFichero(nombreFichero);
		
		
		sc.close();
	}

	private static void leerDeFichero(String nombreFichero) 
	{
		// CREAMOS UN OBJETO DE LA CLASE FILE 
		
		File fichero = new File(nombreFichero);
		
		// SI EL FICHERO EXISTE, LO LEEMOS CON UN "FILEREADER" SINO MENSAJE DE ERROR
		
		if (fichero.exists()) 
		{
			// CREACION DE UN OBJETO FILE Y OTRO BUFFER DE LECTURA
			
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				fr = new FileReader(fichero);
				br = new BufferedReader(fr);
				
				// LEER DEL FICHERO
				
				
				// 1ª FORMA ( LINEA A LINEA )
				
				String linea;
				
				while ( (linea = br.readLine() ) != null) // LEO UNA LINEA ENTERA Y SEA DISTINTO DE NULL, GUARDO LA VARIABLE LINEA (NULL = FINAL DEL FICHERO)
				{
					//System.out.println(linea);
					
					String[] partes = linea.split(";");
					System.out.print("NOMBRE: " + partes[0] + ", EDAD: " + partes[1] + ", " );
					double media = 0;
					if ( partes.length >= 3)
					{
						for (int i = 2; i < partes.length; i++) 
						{
							media += Double.parseDouble(partes[i]);
						}
						
						media = media / partes.length - 2;
					}
					System.out.println("MEDIA: " + media);
				}
				
			
/*				
				// 2ª FORMA ( CARACTER A CARACTER )
				
				int c;
				
				while ( (c = br.read() ) != -1)
				{
					System.out.print( (char) c);
				}
*/	
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
			System.out.println(" * * * FICHERO NO EXISTE * * *");
		}
		
		
	}

	private static void escribirEnFichero(String nombreFichero) 
	{
		
		// CREACION DEL OBJETO "FILE" DANDOLE EL NOMBRE DEL FICHERO
		File fichero = new File(nombreFichero);
		
		// UNA VEZ TENGO EL OBJETO, PREGUNTAMOS SI EL FICHERO EXISTE O NO
		// ( EN CASO DE NO EXISTIR, LO CREA Y SI EXISTE LO UTILIZA )
		
		if (!fichero.exists()) 
		{
			// LO METO EN UN TRY CATCH PARA QUE NO COLAPSE
			try 
			{
				fichero.createNewFile();
			} catch (IOException e) 
			{
				
				System.out.println(e.getMessage());
			}
			
			// PARA ESCRIBIR EN EL FICHERO NECESITAMOS DOS OBJETOS
			
			// 1º FILEWRITTER ( ESCRIBIR EN EL FICHERO )
			FileWriter fw = null;
			
			
			// 2º BUFFER WRITTER ( PODER ESCRIBIR EN EL FICHERO A PARTIR DE UN BUFFER )
			BufferedWriter bw = null;
			
			// CONSTRUCCION DE LOS OBJETOS "FW" Y "BW"
			try 
			{
				
				fw = new FileWriter(fichero);
				bw = new BufferedWriter(fw);
				
				// ESCRIBIR EN EL FICHERO 
				
				/*
				// FASE 1: AUTO ESCRITURA ENSAYO
				bw.write("PRIMERA LINEA");
				bw.newLine();
				bw.write("SEGUNDA LINEA");
				bw.flush(); // FLUSH SIRVE PARA VOLCAR TODO EL BUFFER EN EL FICHERO
				*/
				
				
				// FASE 2: ESCRITURA REAL ALUMNOS ( NOMBRE, EDAD, NOTA MEDIA )
				String siNo = "";
				String linea = "";
				
				do {
					System.out.print("NOMBRE: ");
					String nombre = sc.next();
					linea += nombre + ";";
					
					System.out.print("EDAD: ");
					int edad = sc.nextInt();
					linea += edad + ";";
					double nota;
					do 
					{
						
						System.out.print("NOTA: ");
						nota = sc.nextDouble();
						if (nota != 1) 
						{
							linea += nota + ";";
						}
						
						
					} while (nota >= 0);
					
					bw.write(linea);
					bw.newLine();
					bw.flush();
					linea = "";
					
					System.out.print("¿DESEA CONTINUAR (S/N) ?");
					siNo = sc.next();
					
					
					
				} while (siNo.equalsIgnoreCase("S"));

				
			} catch (IOException e) 
			{
				System.out.println(e.getMessage());
			}
			
			finally 
			{
				// CERRAMOS BUFFER Y FILEWRITTER EN UN FINALLY PARA QUE SIEMPRE SE EJECUTE LA ACCION
				
				try {
					bw.close();
					fw.close();
				} catch (IOException e) 
				{
					System.out.println(e.getMessage());
				}
				
			}
			
			
			
		}
		
		
	}

}
