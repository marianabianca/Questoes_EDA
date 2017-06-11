package tsteda.particionaestavel;

import java.util.Arrays;
import java.util.Scanner;

class ParticionaEstavel {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		String[] entrada = rdr.nextLine().split(" ");
		int[] numeros = criaArrayDeInteiros(entrada); 
		particiona(numeros);
		System.out.println(Arrays.toString(numeros));
		
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
		
		juntaIguais(numeros, pivot, bordaMenores+1);
		
	}

	private static void ordena(int[] numeros, int posDesejada, int posAtual) {
		for (int i = posAtual; posDesejada < i; i--) {
			int aux = numeros[i];
			numeros[i] = numeros[i-1];
			numeros[i-1] = aux;
		}
	}
	
	private static void juntaIguais(int[] vetor, int numero, int borda) {
		for (int i = borda; i < vetor.length; i++) {
			if (vetor[i] == numero) {
				ordena(vetor, borda, i);
				borda++;
			}
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
