package tsteda.countingnegativos;

import java.util.Arrays;
import java.util.Scanner;

class CountingNegativos {
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		String[] entrada = rdr.nextLine().split(" ");
		Integer[] numeros = criaArrayDeInteiros(entrada);
		
		int k = rdr.nextInt();
		rdr.nextLine();
		int menor = rdr.nextInt();
		rdr.nextLine();
		
		Integer[] ordenado = sort(numeros, k, menor);
		
		System.out.println(Arrays.toString(ordenado));
		
		rdr.close();
	}
	
	private static Integer[] sort(Integer[] array, int k, int menor) {
		
		menor = Math.abs(menor);
		
		int[] c = new int[k + menor + 1];
		
		/* Conta elementos */
		for (int i = 0; i < array.length; i++) {
			if (i > 0) {
				System.out.println(Arrays.toString(c));
			}
			c[array[i] + menor] += 1;
		}
		System.out.println(Arrays.toString(c));
		
		/* Cria counting array */
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i-1];
		}
		System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(c));
		
		
		Integer[] b = new Integer[array.length];
		
		for (int i = array.length - 1; 0 <= i; i--) {
			b[c[array[i] + menor] - 1] = array[i];
			c[array[i] + menor] -= 1; 
		}
		System.out.println(Arrays.toString(c));

		return b;
	}

	static Integer[] criaArrayDeInteiros(String[] frase) {
		Integer[] retorno = new Integer[frase.length]; 
		
		for (int i = 0; i < frase.length; i++) {
			retorno[i] = Integer.parseInt(frase[i]);
		}
		
		return retorno;
	}
	
}
