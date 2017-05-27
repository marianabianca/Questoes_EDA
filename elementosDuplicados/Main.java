package tsteda.elementosDuplicados;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String linha = rdr.nextLine();
		System.out.println(String.valueOf(repetido(linha)));
		rdr.close();
	}

	static boolean repetido(String texto) {
		String numeros[] = texto.split(" ");
		
		for (int i = 0; i < numeros.length; i++) {
			
			for (int j = i + 1; j < numeros.length; j++) {
				
				if (numeros[i].equals(numeros[j])) {
					return true;
					
				}
			}
		}
		
		return false;
	}

}