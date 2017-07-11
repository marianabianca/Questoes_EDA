package tsteda.primeiroestagio.particionalomuto;

import java.util.Arrays;
import java.util.Scanner;

class ParticionaLomuto {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		String[] entrada = rdr.nextLine().split(" ");
		int[] numeros = criaArrayDeInteiros(entrada); 
		particiona(numeros);
		System.out.println(Arrays.toString(numeros));
		
		rdr.close();
	}

	static int[] criaArrayDeInteiros(String[] frase) {
		int[] retorno = new int[frase.length]; 
		
		for (int i = 0; i < frase.length; i++) {
			retorno[i] = Integer.parseInt(frase[i]);
		}
		
		return retorno;
	}

	private static void particiona(int[] numeros) {
		int pivot = numeros[0];
		int i = 1;
		int j = 1;
		
		while (j < numeros.length) {
			if (numeros[j] < pivot) {
				swap(numeros, i, j);
				System.out.println(Arrays.toString(numeros));
				i++;
			}
			j++;
		}
		
		swap(numeros, 0, i-1);
		
		System.out.println(Arrays.toString(numeros));
	}

	private static void swap(int[] numeros, int i, int j) {
		int aux = numeros[i];
		numeros[i] = numeros[j];
		numeros[j] = aux;
	}
	
}
