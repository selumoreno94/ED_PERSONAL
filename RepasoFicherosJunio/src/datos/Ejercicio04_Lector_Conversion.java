package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio04_Lector_Conversion {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		File fichero = new File("AlumNotasCompleto.txt");

		int id = 0;
		String nombreCompleto, nombre, apellidos, primerApellido = null, segundoApellido = null, usuario = null,
				year = null;
		double nota1 = 0, nota2 = 0, nota3 = 0, media3Notas = 0;

		if (fichero.exists()) {
			System.out.println("ARCHVIVO ENCONTRADO");
			System.out.println();

			FileReader fr = null;
			BufferedReader br = null;

			FileWriter fw = null;
			BufferedWriter bw = null;

			try {
				fr = new FileReader(fichero);
				br = new BufferedReader(fr);

				fw = new FileWriter("FicheroSalidaCompleto.txt");
				bw = new BufferedWriter(fw);
				String linea;
				String[] separacionCampos;

				while ((linea = br.readLine()) != null) {

					separacionCampos = linea.split(": ");

					id = Integer.parseInt(separacionCampos[0]);

					System.out.println(id);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		else {
			System.out.println("ARCHIVO NO ENCONTRADO");
		}

		sc.close();
	}

}
