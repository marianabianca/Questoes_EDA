package tsteda.elementosDuplicados;

import java.util.Scanner;

class ElementosDuplicados {
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		String[] entrada = rdr.nextLine().split(" ");
		
		String[] numeros = new String[entrada.length];
		
		boolean verificador = false;
		boolean jaTem = false;
		
		int j = 0;
		
		while (j < entrada.length) {
			jaTem = contem(numeros, entrada[j]);
			
			if (jaTem) {
				verificador = true;
				break;
			}
			
			numeros[j] = entrada[j];
			j++;
		}
		
		System.out.println(String.valueOf(verificador));
		rdr.close();
	}
	
	static boolean contem(String[] numeros, String numeroAtual) {
		
		int i = 0;
		
		while (i < numeros.length) {
			if (numeros[i] == null) {
				break;
			}
			
			if (numeros[i].equals(numeroAtual)) {
				return true;
			}
			
			i++;
		}
		
		return false;
	}
	
}
