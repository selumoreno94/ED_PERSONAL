package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio07_FicherosJugadores {

	public static void main(String[] args) {
		File fichero = new File("jugadores.txt");

		String codigo, nombreJugador, equipo;
		int a�osTotales;
		double mediaGoles = 0;

		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);

			FileWriter fw = null;
			BufferedWriter bw = null;

			String linea = null;

			try {

				String[] separacionCampos;
				String[] separacionA�os;
				String[] separacionGoles;

				while ((linea = br.readLine()) != null) {

					separacionCampos = linea.split(" ");
					File jugadorCodigo = new File(separacionCampos[0] + ".txt");
					if (!jugadorCodigo.exists()) {
						jugadorCodigo.createNewFile();
					}

					fw = new FileWriter(jugadorCodigo);
					bw = new BufferedWriter(fw);

					codigo = separacionCampos[0];
					nombreJugador = separacionCampos[1];
					equipo = separacionCampos[2];

					separacionA�os = separacionCampos[3].split(",");
					a�osTotales = separacionA�os.length;

					bw.write("C�digo: " + codigo);
					bw.newLine();
					bw.write("Nombre: " + nombreJugador);
					bw.newLine();
					bw.write("Equipo: " + equipo);
					bw.newLine();
					bw.write("A�os Totales: " + a�osTotales);
					bw.newLine();

					if (separacionCampos.length > 4) {
						separacionGoles = separacionCampos[4].split(",");

						for (int i = 0; i < separacionGoles.length; i++) {
							mediaGoles = Double.parseDouble(separacionGoles[i]) / a�osTotales;

						}
						bw.write("Media Goles Totales: " + mediaGoles);

					}

					bw.flush();
					bw.close();
					fw.close();

				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			finally {
				try {
					br.close();
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
