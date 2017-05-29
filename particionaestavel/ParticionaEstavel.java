package tsteda.particionaestavel;

import java.util.Arrays;
import java.util.Scanner;

class ParticionaEstavel {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		String entrada = rdr.nextLine();
		if (! (entrada.length() == 0)) {
			String[] saida = entrada.split(" ");
			int[] numeros = criaArrayDeInteiros(saida); 
			particiona(numeros);
			System.out.println(Arrays.toString(numeros));
		} else {
			int[] saida = new int[0]; 
			System.out.println(Arrays.toString(saida));
		}
		
		
		rdr.close();
	}
	
	private static void particiona(int[] numeros) {
		int pivot = numeros[0];
		int bordaMenores = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			if (pivot > numeros[i]) {
				bordaMenores++;
				ordena(numeros, bordaMenores, i);
			}
		}
		
		/* Coloca o pivot em sua posicao */
		for (int i = 0; i < bordaMenores; i++) {
			int aux = numeros[i];
			numeros[i] = numeros[i+1];
			numeros[i+1] = aux;
		}
		
	}

	private static void ordena(int[] numeros, int posDesejada, int posAtual) {
		for (int i = posAtual; posDesejada < i; i--) {
			int aux = numeros[i];
			numeros[i] = numeros[i-1];
			numeros[i-1] = aux;
		}
	}

	static int[] criaArrayDeInteiros(String[] frase) {
		int[] retorno = new int[frase.length]; 
		
		for (int i = 0; i < frase.length; i++) {
			retorno[i] = Integer.parseInt(frase[i]);
		}
		
		return retorno;
	}
	
}
