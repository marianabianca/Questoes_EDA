package tsteda.invertefrase;

import java.util.Scanner;

class InverteFrase {
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String[] frase = rdr.nextLine().split(" ");
		System.out.println(inverte(frase));
		
		rdr.close();
	}
	
	private static String inverte(String[] original) {
		int i = 0;
		int tamanho = original.length-1;
		while (i < tamanho -i) {
			swap(original, i, tamanho-i);
			i+=1;
		}
		
		return juntaFrase(original);
	}

	private static String juntaFrase(String[] original) {
		String frase = "";
		for (int i = 0; i < original.length; i++) {
			frase += original[i];
			if (i != original.length-1) {
				frase += " ";
			}
		}
		return frase;
	}

	private static void swap(String[] array, int i, int j) {
		String aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}


}
