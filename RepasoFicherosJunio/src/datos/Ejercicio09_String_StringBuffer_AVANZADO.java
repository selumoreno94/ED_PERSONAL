package datos;

import java.util.Scanner;

public class Ejercicio09_String_StringBuffer_AVANZADO {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// REALIZAR UN PROGRAMA QUE RECIBA DOS CADENAS DE CARACTERES Y CUENTE
		// EL NUMERO DE APARICIONES DE LA PRIMERA EN LA SEGUNDA

		System.out.println("FRASE PRINCIPAL: ");
		String frase = sc.nextLine();

		System.out.println("CADENA A BUSCAR: ");
		String cadena = sc.next();

		System.out.println("NUMERO DE OCURRENCIAS DE " + cadena + " EN " + frase + ": " + ocurrencias(frase, cadena));

		sc.close();
	}

	private static int ocurrencias(String frase, String cadena) {
		int contador = 0;

		int posicion = frase.indexOf(cadena);

		if (posicion != -1) {
			do {
				contador++;
				// posicion = frase.in
			} while (posicion != -1);
		}

		return contador;
	}

}
