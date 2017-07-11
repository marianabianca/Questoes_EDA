package tsteda.primeiroestagio.stoogesort;

import java.util.Scanner;

public class StoogeSort {
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);

		String[] entrada = rdr.nextLine().split(" ");
		int[] numeros = criaArrayDeInteiros(entrada);
		stooge(numeros, 0, numeros.length - 1);

		rdr.close();
	}
	
	private static void stooge(int[] numeros, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	static int[] criaArrayDeInteiros(String[] frase) {
		int[] retorno = new int[frase.length];

		for (int i = 0; i < frase.length; i++) {
			retorno[i] = Integer.parseInt(frase[i]);
		}

		return retorno;
	}
	
}
