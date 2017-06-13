package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio06_FicheroNBA {

	public static void main(String[] args) {

		File fichero = new File("nba.txt");

		String stClasificacion = null, stPj = null, stPg = null, stPp = null, stCiudad = null, stFundacion = null,
				stEstadio = null, estadioFinal = "";

		int BasketAverage = 0, intPf = 0, intPc = 0;

		if (fichero.exists()) {

			FileReader fr = null;
			BufferedReader br = null;

			FileWriter fw = null;
			BufferedWriter bw = null;

			try {
				fr = new FileReader(fichero);
				br = new BufferedReader(fr);

				// fw = new FileWriter("nbaFinalCompleto.txt");
				// bw = new BufferedWriter(fw);

				String linea = null;
				String[] separacionCampos;

				while ((linea = br.readLine()) != null) {
					separacionCampos = linea.split(";");

					File ficheroEquipo = new File(separacionCampos[0] + ".txt");
					if (!ficheroEquipo.exists()) {
						ficheroEquipo.createNewFile();
					}

					fw = new FileWriter(ficheroEquipo);
					bw = new BufferedWriter(fw);

					stClasificacion = separacionCampos[0];
					stPj = separacionCampos[1];
					stPg = separacionCampos[2];
					stPp = separacionCampos[3];

					intPf = Integer.parseInt(separacionCampos[4]); // PUNTOS
																	// FAVOR
					intPc = Integer.parseInt(separacionCampos[5]); // PUNTOS EN
																	// CONTRA
					BasketAverage = intPf - intPc;

					stCiudad = separacionCampos[6];
					stFundacion = separacionCampos[7];
					stEstadio = separacionCampos[8];

					bw.write("EQUIPO: " + stClasificacion);
					bw.newLine();
					bw.write("PARTIDOS JUGADOS: " + stPj);
					bw.newLine();
					bw.write("PARTIDOS GANADOS: " + stPg);
					bw.newLine();
					bw.write("PARTIDOS PERDIDOS: " + stPp);
					bw.newLine();
					bw.write("BASKET AVERAGE: " + BasketAverage);
					bw.newLine();
					bw.write("CIUDAD: " + stCiudad.substring(1, stCiudad.length() - 1));
					bw.newLine();
					bw.write("FUNDACION: " + stFundacion);
					bw.newLine();

					String[] separacionEstadio = stEstadio.split("-");
					estadioFinal = ""; // PARA NO CONCATENAR LOS ANTERIORES
										// NOMBRES DEL BUCLE
					estadioFinal += separacionEstadio[0].toUpperCase();
					for (int i = 1; i < separacionEstadio.length; i++) {
						estadioFinal += separacionEstadio[i].substring(0, 1).toUpperCase();
					}

					bw.write("ESTADIO: " + estadioFinal);

					bw.flush();
					bw.close();
					fw.close();

				}
			}

			catch (Exception e) {
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
		}

		else {
			System.out.println("FICHERO NO ENCONTRADO");
		}

	}

}
