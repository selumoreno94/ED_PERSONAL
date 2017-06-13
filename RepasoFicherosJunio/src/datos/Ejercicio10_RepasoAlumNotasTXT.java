package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio10_RepasoAlumNotasTXT {

	public static void main(String[] args) {
		File fichero = new File("ListaAlumnosNotas.txt");

		String nombreCompleto = null, nombre, apellidos;
		int identificacionAlumno;
		double nota1, nota2, nota3, media3notas;

		if (fichero.exists()) {
			FileReader fr = null;
			BufferedReader br = null;

			FileWriter fw = null;
			BufferedWriter bw = null;

			try {
				String linea = null;

				fr = new FileReader(fichero);
				br = new BufferedReader(fr);

				fw = new FileWriter("ExpedienteCursoCompleto.txt");
				bw = new BufferedWriter(fw);

				// REGISTROS SEPARADOS
				String[] separacionInicial;
				String[] separacionNombreCompleto;

				while ((linea = br.readLine()) != null) {
					separacionInicial = linea.split(";");

					identificacionAlumno = Integer.parseInt(separacionInicial[0]);

					nombreCompleto = separacionInicial[1];

					nota1 = Double.parseDouble(separacionInicial[2]);
					nota2 = Double.parseDouble(separacionInicial[3]);
					nota3 = Double.parseDouble(separacionInicial[4]);
					media3notas = Math.round(((nota1 + nota2 + nota3) / 3) * 100) / 100;

					separacionNombreCompleto = nombreCompleto.split(", ");
					apellidos = separacionNombreCompleto[0];
					nombre = separacionNombreCompleto[1];

					bw.write("ID: " + identificacionAlumno);
					bw.newLine();
					bw.write("EMAIL: " + "csi16-" + nombre.substring(0, 1) + apellidos.substring(0, 3)
							+ apellidos.substring(apellidos.length() - 3, apellidos.length()) + "@colegioaltair.net");
					bw.newLine();
					bw.write("APELLIDOS: " + apellidos);
					bw.newLine();
					bw.write("NOMBRE: " + nombre);
					bw.newLine();
					bw.write("EXAMEN 1: " + nota1);
					bw.newLine();
					bw.write("EXAMEN 2: " + nota2);
					bw.newLine();
					bw.write("EXAMEN 3: " + nota3);
					bw.newLine();
					bw.write("MEDIA TOTAL: " + media3notas);
					bw.newLine();
					bw.newLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

			finally {
				try {
					bw.close();
					fw.close();

					br.close();
					fr.close();

					System.out.println("FICHERO CREADO CORRECTAMENTE");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("FICHERO NO ENCONTRADO");
		}

	}

}
