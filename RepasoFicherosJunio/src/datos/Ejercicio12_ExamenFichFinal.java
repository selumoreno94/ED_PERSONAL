package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio12_ExamenFichFinal {

	public static void main(String[] args) {

		File fichero = new File("ENUNCIADO");

		if (fichero.exists()) {
			FileReader fr = null;
			BufferedReader br = null;

			FileWriter fw = null;
			BufferedWriter bw = null;

			String linea = null;

			String[] camposSeparados;
			String[] nombreCompletoSeparado;
			String[] notasSeparada;

			int edad;
			String nombreCompleto;
			String notas;
			int numTelefono;
			String ciudad;
			String apellidos;
			String nombre;
			double nota1, nota2, nota3, mediaCurso;

			try {

				fr = new FileReader(fichero);
				br = new BufferedReader(fr);

				fw = new FileWriter("ficheroExamenFinalConjunto.txt");
				bw = new BufferedWriter(fw);

				while ((linea = br.readLine()) != null) {
					camposSeparados = linea.split(";");
					// 0 1 2 3 4
					// Arranz Fuertes, Rubén;22;(+34654321123);(La
					// Campana);3,6.7,8,9,2

					nombreCompleto = camposSeparados[0];
					nombreCompletoSeparado = nombreCompleto.split(", ");
					apellidos = nombreCompletoSeparado[0];
					nombre = nombreCompletoSeparado[1];

					edad = Integer.parseInt(camposSeparados[1]);

					numTelefono = Integer.parseInt(camposSeparados[2].substring(4, camposSeparados[2].length() - 1));

					ciudad = camposSeparados[3].substring(1, camposSeparados[3].length() - 1);

					notas = camposSeparados[4];
					notasSeparada = notas.split(",");
					mediaCurso = Double.parseDouble(notasSeparada[0] + notasSeparada[1] + notasSeparada[2]) / 3;

					bw.write("USUARIO: " + nombre.substring(0, 3)
							+ apellidos.substring(apellidos.length() - 4, apellidos.length()));
					bw.newLine();
					bw.write("NOMBRE COMPLETO: " + nombre + " " + apellidos);
					bw.newLine();
					bw.write("EDAD: " + edad);
					bw.newLine();
					bw.write("CIUDAD: " + ciudad);
					bw.newLine();
					bw.write("TELEFONO: " + numTelefono);
					bw.newLine();
					bw.write("MEDIA CURSO: " + mediaCurso);
					bw.newLine();
					bw.newLine();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			finally {
				try {
					bw.close();
					fw.close();

					br.close();
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		else {
			System.out.println("FICHERO NO ENCONTRADO");
		}
	}

}
