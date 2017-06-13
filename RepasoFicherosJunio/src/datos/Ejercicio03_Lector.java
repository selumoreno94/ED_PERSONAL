package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.time.Year;
import java.util.Calendar;

public class Ejercicio03_Lector {

	public static void main(String[] args) {
		int id = 0;
		String nombreCompleto, nombre, apellidos, primerApellido = null, segundoApellido = null, usuario = null,
				year = null;
		double nota1 = 0, nota2 = 0, nota3 = 0, media3Notas = 0;

		File fichero = new File("AlumnosNotas.txt");
		FileReader fr = null;
		BufferedReader br = null;

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);

			fw = new FileWriter("AlumNotasCompleto.txt");
			bw = new BufferedWriter(fw);

			String linea = null;
			Calendar calendario = Calendar.getInstance();
			int anno = calendario.get(Calendar.YEAR);
			year = Integer.toString(anno);

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

				bw.write("--------------------------------------------------------------------------------");
				bw.newLine();
				bw.write("ID ALUMNO: " + id);
				bw.newLine();
				bw.write("NOMBRE: " + nombre);
				bw.newLine();
				bw.write("APELLIDOS: " + primerApellido + ", " + segundoApellido);
				bw.newLine();
				bw.write("EMAIL: csi" + year.substring(year.length() - 2, year.length()) + "-" + nombre.substring(0, 1)
						+ primerApellido.substring(0, 3)
						+ segundoApellido.substring(segundoApellido.length() - 3, segundoApellido.length())
						+ "@colegioXXX.net");
				bw.newLine();
				bw.write("NOTA 1: " + nota1);
				bw.newLine();
				bw.write("NOTA 2: " + nota2);
				bw.newLine();
				bw.write("NOTA 3: " + nota3);
				bw.newLine();
				bw.write("MEDIA: " + media3Notas);
				bw.newLine();

			}

		}

		catch (Exception e) {
			// TODO: handle exception
		}

		finally {
			try {
				bw.close();
				fw.close();
				br.close();
				fr.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
