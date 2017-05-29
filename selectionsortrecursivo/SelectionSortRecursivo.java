package tsteda.selectionsortrecursivo;

import java.util.Arrays;
import java.util.Scanner;

class SelectionSortRecursivo {
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		String entrada = rdr.nextLine();
		if (! (entrada.length() == 0)) {
			String[] saida = entrada.split(" ");
			int[] numeros = criaArrayDeInteiros(saida); 
			sort(numeros, 0);
		} else {
			int[] saida = new int[0]; 
			System.out.println(Arrays.toString(saida));
		}
		
		
		rdr.close();
	}
	
	private static void sort(int[] numeros, int indiceInicial) {
		if (indiceInicial < numeros.length-1) {
			int menor = indiceInicial;
			for (int i = menor+1; i < numeros.length; i++) {
				if (numeros[menor] > numeros[i]) {
					menor = i;
				}
			}
			int aux = numeros[menor];
			numeros[menor] = numeros[indiceInicial];
			numeros[indiceInicial] = aux;
			System.out.println(Arrays.toString(numeros));
			sort(numeros, indiceInicial+1);
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
