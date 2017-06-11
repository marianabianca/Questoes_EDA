package tsteda.primeiroestagio.mergesort;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	
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
	
	private static void merge(int[] numeros) {
		mergePasso(numeros, 0, numeros.length -1);
	}

	public static void mergePasso(int[] array, int left, int right) {
		if (left != right) {
			int meio = (right + left) / 2;
			
			mergePasso(array, left, meio);
			mergePasso(array, meio + 1, right);
			merge(array, left, right, meio);
			
		}
	}
	
	
	public static void merge(int[] array, int left, int right, int meio) {
		
		int[] copia = Arrays.copyOf(array, array.length);
		
		int i = left;
		int j = meio + 1;
		int k = left;
		
		while (i <= meio && j <= right) {
			
			if (copia[i] < copia[j]) {
				array[k] = copia[i];
				i++;
			} else {
				array[k] = copia[j];
				j++;
			}
			
			k++;
		}
		
		while (i <= meio) {
			array[k] = copia[i];
			i++;
			k++;
		}
		
		while (j <= right) {
			array[k] = copia[j];
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
	
}
