package tsteda.estatisticadeordem;

import java.util.Scanner;

class EstatisticaDeOrdem {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);

		String entrada = rdr.nextLine();
		String[] saida = entrada.split(" ");
		int[] numeros = criaArrayDeInteiros(saida);

		System.out.println(estatisticaDeOrdem(numeros));

		rdr.close();
	}

	private static int estatisticaDeOrdem(int[] numeros) {
		int estatistica = 0;

		int numDaEstatistica = numeros[0];

		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] <= numDaEstatistica) {
				estatistica += 1;
			}
		}

		return estatistica;
	}

	static int[] criaArrayDeInteiros(String[] frase) {
		int[] retorno = new int[frase.length];

		for (int i = 0; i < frase.length; i++) {
			retorno[i] = Integer.parseInt(frase[i]);
		}

		return retorno;
	}

}
