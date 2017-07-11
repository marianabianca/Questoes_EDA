package tsteda.primeiroestagio.quicksort;

import java.util.Scanner;

class QuickSortPassoAPasso {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);

		String[] entrada = rdr.nextLine().split(" ");
		int[] numeros = criaArrayDeInteiros(entrada);
		quickSort(numeros, 0, numeros.length - 1);

		rdr.close();
	}

	static int[] criaArrayDeInteiros(String[] frase) {
		int[] retorno = new int[frase.length];

		for (int i = 0; i < frase.length; i++) {
			retorno[i] = Integer.parseInt(frase[i]);
		}

		return retorno;
	}

	private static void quickSort(int[] numeros, int left, int right) {
		if (left < right) {
			int posPivot = particiona(numeros, left, right);
			quickSort(numeros, left, posPivot - 1);
			quickSort(numeros, posPivot + 1, right);
		}
	}

	private static int particiona(int[] numeros, int left, int right) {
		int pivot = numeros[left];
		int i = left;
		int j = left + 1;

		while (j <= right) {
			if (numeros[j] < pivot) {
				i++;
				swap(numeros, i, j);
			}
			j++;
		}

		swap(numeros, left, i);
		System.out.println(fazSaida(numeros));
		return i;
	}

	private static String fazSaida(int[] numeros) {
		String saida = "";

		for (int i = 0; i < numeros.length; i++) {
			saida += numeros[i];
			if (i != (numeros.length - 1)) {
				saida += " ";
			}
		}

		return saida;
	}

	private static void swap(int[] numeros, int i, int j) {
		int aux = numeros[i];
		numeros[i] = numeros[j];
		numeros[j] = aux;
	}

}
