package tsteda.mergepassoapasso;

import java.util.Arrays;
import java.util.Scanner;

class MergeSortPassoAPasso {
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		String entrada = rdr.nextLine();
		if (! (entrada.length() == 0)) {
			String[] saida = entrada.split(" ");
			int[] numeros = criaArrayDeInteiros(saida); 
			merge(numeros);
			System.out.println(Arrays.toString(numeros));
		} else {
			int[] saida = new int[0]; 
			System.out.println(Arrays.toString(saida));
		}
		
		
		rdr.close();
	}
	
	static void merge(int[] vetor) {
		mergePasso(vetor, 0, vetor.length-1);
	}
	
	static void mergePasso(int[] vetor, int ini, int fim) {
		if (!(ini == fim)) {
			System.out.println(Arrays.toString(fazSaida(vetor, ini, fim)));
			int meio = (ini+fim)/2;
			mergePasso(vetor, ini, meio);
			mergePasso(vetor, meio+1, fim);
			merge(vetor, ini, fim);
		}
		if (!(fim == vetor.length-1 && ini == 0)) {
			System.out.println(Arrays.toString(fazSaida(vetor, ini, fim)));
		}

	}
	
	static void merge(int[] vetor, int ini, int fim) {
		int med = (ini + fim) / 2;
		
		/* Cria copia do vetor original */
		int[] ajudante = new int[vetor.length];
		for (int i = 0; i < ajudante.length; i++) {
			ajudante[i] = vetor[i];
		}
		
		/* Modifica vetor com ajuda de ponteiros em ambos arrays */
		
		int i = ini;
		int j = med+1;
		int k = ini;
		
		while (i <= med && j <= fim) {
			if (ajudante[i] < ajudante[j]) {
				vetor[k] = ajudante[i];
				i++;
			} else {
				vetor[k] = ajudante[j];
				j++;
			}
			k++;
		}
		
		/* Como a condicao de parada foi atingida em apenas 1 vetor, adiciona o restante dos elementos */
		
		while (i <= med) {
			vetor[k] = ajudante[i];
			i++;
			k++;
		}
		
		while (j <= fim) {
			vetor[k] = ajudante[j];
			j++;
			k++;
		}
		
		
		
	}
	
	static int[] criaArrayDeInteiros(String[] frase) {
		int[] retorno = new int[frase.length]; 
		
		for (int i = 0; i < frase.length; i++) {
			retorno[i] = Integer.parseInt(frase[i]);
		}
		
		return retorno;
	}
	
	static int[] fazSaida(int[] vetor, int ini, int fim) {
		int[] saida = new int[fim-ini+1];
		int j = 0;
		
		for (int i = ini; i <= fim; i++) {
			saida[j] = vetor[i];
			j++;
		}
		
		return saida;
	}

}
