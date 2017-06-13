package datos;

import java.util.Scanner;

public class Ejercicio08_String_StringBuffer_BASICO {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String cadena = "aloha";

		// CADENA DE CARACTERES EN MAYUSCULAS Y MINUSCULAS

		System.out.println(cadena.toUpperCase());
		System.out.println(cadena.toLowerCase());

		// LOS DOS PRIMEROS CARACTERES

		System.out.println(cadena.substring(0, 2));

		// LOS DOS ULTIMOS CARACTERES

		System.out.println(cadena.substring(cadena.length() - 2, cadena.length()));

		// REPETICIONES DEL ULTIMO CARACTER

		int contador = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) == cadena.charAt(cadena.length() - 1)) {
				contador++;
			}
		}

		System.out.println("EL ULTIMO CARACTER DE LA CADENA (" + cadena.substring(cadena.length() - 1, cadena.length())
				+ ") SE REPITE: " + contador + " VECES");

		// TODAS OCURRENCIAS (MISMO CARACTER) DEL PRIMER CARACTER EN MAYUSCULA

		System.out.println(cadena.replaceAll(cadena.substring(0, 1), cadena.substring(0, 1).toUpperCase()));

		// CADENA CON MODIFICACIONES --> USO DEL STRINGBUFFER <--

		StringBuffer cadenaBuffer = new StringBuffer(cadena);

		// *** POR DELANTE Y POR DETRAS

		System.out.println(cadenaBuffer.append("***"));
		System.out.println(cadenaBuffer.insert(0, "***"));

		// CADENA INVERTIDA

		System.out.println(cadenaBuffer.reverse());

		sc.close();
	}

}
