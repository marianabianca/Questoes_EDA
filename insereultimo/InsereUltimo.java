package tsteda.insereultimo;

import java.util.Arrays;
import java.util.Scanner;

class InsereUltimo {
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		String[] saida = new String[0];
		
		String entrada = rdr.nextLine();
		if (! (entrada.length() == 0)) {
			saida = entrada.split(" ");
			int[] numeros = criaArrayDeInteiros(saida); 
			ordenaUltimo(numeros);
			System.out.println(Arrays.toString(numeros));
		} else {
			System.out.println(Arrays.toString(saida));
		}
		
		rdr.close();
	}
	
	static void ordenaUltimo(int[] vetor) {
		
		int i = vetor.length-1;
		while (i > 0) {
			
			if (vetor[i] > vetor[i-1]) {
				break;
			}
			
			int aux = vetor[i];
			vetor[i] = vetor[i-1];
			vetor[i-1] = aux;
			i--;
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
