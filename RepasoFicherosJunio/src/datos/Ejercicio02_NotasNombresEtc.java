package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio02_NotasNombresEtc {

	public static void main(String[] args) {
		File fichero = new File("AlumnosNotas.txt");

		// VARIABLES
		int id = 0;
		String nombreCompleto, nombre, apellidos, primerApellido = null, segundoApellido = null;
		double nota1 = 0, nota2 = 0, nota3 = 0, media3Notas = 0;
		// float nota1 = 0, nota2 = 0, nota3 = 0, media3Notas = 0;

		if (fichero.exists()) {
			FileReader fr = null;
			BufferedReader br = null;

			FileWriter fw = null;
			BufferedWriter bw = null;

			try {

				fr = new FileReader(fichero);
				br = new BufferedReader(fr);

				fw = new FileWriter("FicheroSalida.txt");
				bw = new BufferedWriter(fw);

				String linea = null;
				String[] separacionCamposIniciales;
				String[] separacionApellidosNombres;
				String[] separacionApellidos;

				while ((linea = br.readLine()) != null) {
					// 0 1 2 3 4
					// 207;Arenas Mata, Daniel Luis;2,9;9,7;5,6
					separacionCamposIniciales = linea.split(";");

					id = Integer.parseInt(separacionCamposIniciales[0]);

					nombreCompleto = separacionCamposIniciales[1];
					separacionApellidosNombres = nombreCompleto.split(", ");
					apellidos = separacionApellidosNombres[0];
					nombre = separacionApellidosNombres[1];

					separacionApellidos = apellidos.split(" ");
					primerApellido = separacionApellidos[0];
					segundoApellido = separacionApellidos[1];

					nota1 = Double.parseDouble(separacionCamposIniciales[2]);
					nota2 = Double.parseDouble(separacionCamposIniciales[3]);
					nota3 = Double.parseDouble(separacionCamposIniciales[4]);
					media3Notas = Math.round(((nota1 + nota2 + nota3) / 3));

					bw.write(id + "  " + primerApellido + ", " + segundoApellido + "  " + nota1 + "  " + nota2 + "  "
							+ nota3 + "  " + media3Notas);
					bw.newLine();

				}

				System.out.println("FICHERO ANTERIOR LEIDO Y ESCRITO UNO NUEVO CORRECTAMENTE");

			} catch (Exception e) {
				System.out.println(e.getMessage());

			}

			finally {

				try {
					bw.close();
					fw.close();
					br.close();
					fr.close();

					System.out.println("FICHERO CERRADO CORRECTAMENTE");
				}

				catch (IOException e) {
					System.out.println(e.getMessage());
				}

			}

		} else {
			System.out.println(" FICHERO NO ENCONTRADO ");
		}
	}
}
