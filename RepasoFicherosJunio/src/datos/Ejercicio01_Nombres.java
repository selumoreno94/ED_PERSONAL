package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class Ejercicio01_Nombres {

	// Arranz Fuertes, Rubén;23;(+34654321123);(La Campana);3,6.7,8,9,2

	public static void main(String[] args) {

		String domicilio = null, usuario = null, apellidosNombre, nombre = null, apellidos = null, edad = null,
				telefono = null, notas = null, primerApellido = null, segundoApellido = null;
		double asignaturasAprobadas = 0;

		File fichero = new File("ENUNCIADO");

		if (fichero.exists()) {
			FileReader fr = null;
			BufferedReader br = null;

			FileWriter fw = null;
			BufferedWriter bw = null;

			try {
				fr = new FileReader(fichero);
				br = new BufferedReader(fr);

				fw = new FileWriter("ficheroFinal.txt");
				bw = new BufferedWriter(fw);

				String linea = null;
				String[] nombreApellidos;
				String[] separacionApellidos;
				String[] separacionNotas;
				String[] campos;

				double notasSeparadas = 0;
				int numAsignaturasAprobadas = 0;
				while ((linea = br.readLine()) != null) {
					campos = linea.split(";");

					apellidosNombre = campos[0];
					nombreApellidos = apellidosNombre.split(", ");
					apellidos = nombreApellidos[0];

					separacionApellidos = apellidos.split(" ");
					primerApellido = separacionApellidos[0];
					segundoApellido = separacionApellidos[1];

					nombre = nombreApellidos[1];

					edad = campos[1];
					telefono = campos[2];
					domicilio = campos[3];
					notas = campos[4];
					separacionNotas = notas.split(",");
					for (int i = 0; i < separacionNotas.length; i++) {
						notasSeparadas = Double.parseDouble(separacionNotas[i]);
						if (notasSeparadas >= 5) {
							numAsignaturasAprobadas++;
						}
					}

					usuario = nombre.substring(0, 1) + primerApellido.substring(0, 2)
							+ segundoApellido.substring((segundoApellido.length() - 3), segundoApellido.length());

				}

				bw.write("NOMBRE: " + nombre + " " + apellidos);
				bw.newLine();
				bw.write("EDAD: " + edad + " AÑOS");
				bw.newLine();
				bw.write("TELEFONO: " + telefono.substring(4, telefono.length() - 1));
				bw.newLine();
				bw.write("DOMICILIO: " + domicilio.substring(1, domicilio.length() - 1));
				bw.newLine();
				bw.write("ASIGNATURAS APROBADAS: " + numAsignaturasAprobadas);
				bw.newLine();
				bw.write("USUARIO: " + usuario.toLowerCase());
				bw.newLine();

			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}

			finally {
				try {
					bw.close();
					fw.close();
					br.close();
					fr.close();
				} catch (IOException e) {
					System.out.println(e);
				}

			}
		} else {
			System.out.println("FICHERO NO EXISTE");
		}
	}
}
