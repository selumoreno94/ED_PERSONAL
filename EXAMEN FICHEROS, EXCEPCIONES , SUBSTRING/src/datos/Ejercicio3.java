package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio3 {

	public static void main(String[] args) 
	{
		File fichero = new File ("mediciones.txt");
		File ficheroSalida = new File("medicionesMin.txt");
		
		
		if (fichero.exists()) 
		{
			FileReader fr = null;
			BufferedReader br = null;
			
			FileWriter fw = null;
			BufferedWriter bw = null;
			
			try 
			{
				fr = new FileReader(fichero);
				br = new BufferedReader(fr);
				
				try 
				{
					fw = new FileWriter(ficheroSalida);
					bw = new BufferedWriter(fw);
					
					String linea = null;
					String[] partes;
					int min = Integer.MIN_VALUE;
					while ( (linea = br.readLine() ) != null) 
					{
						partes = linea.split(" ");
						
						
						if (partes.length > 1) 
						{
							min = Integer.parseInt(partes[1]);
							for (int i = 1; i < partes.length; i++) 
							{
								if (Integer.parseInt(partes[i]) < min) 
								{
									min = Integer.parseInt(partes[i]);
								}
							}
							
							if (min == Integer.MIN_VALUE) 
							{
								bw.write(partes[0]);
							}
							else
							{
								bw.write(partes[0] + " " + min);
							}
							
							bw.flush();
							bw.newLine();
						}
						
					}
				} 
				
				catch (IOException e) 
				{
					System.out.println(e.getMessage());
				}
				
			} 
			
			catch (FileNotFoundException e) 
			{
				System.out.println(e.getMessage());
			}
			
			finally 
			{
				try 
				{
					br.close();
					fr.close();
					
					bw.close();
					fw.close();
				} 
				catch (IOException e) 
				{
					System.out.println(e.getMessage());
				}
				
			}
			
			
		}
		else 
		{
			System.out.println(" * * * FICHERO NO ENCONTRADO * * * ");
		}
	}

}
