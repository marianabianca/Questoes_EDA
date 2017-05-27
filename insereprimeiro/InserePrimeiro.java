import java.util.Arrays;
import java.util.Scanner;

class InserePrimeiro {
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		String entrada = rdr.nextLine();
		if (! (entrada.length() == 0)) {
			String[] saida = entrada.split(" ");
			int[] numeros = criaArrayDeInteiros(saida); 
			ordenaPrimeiro(numeros);
			System.out.println(Arrays.toString(numeros));
		} else {
			int[] saida = new int[0]; 
			System.out.println(Arrays.toString(saida));
		}
		
		
		rdr.close();
	}
	
	static void ordenaPrimeiro(int[] vetor) {
		
		int i = 0;
		while ((vetor.length > 1) && (i < vetor.length-1)) {
			if (!(vetor[i] > vetor[i+1])) {
				break;
			}
			int aux = vetor[i];
			vetor[i] = vetor[i+1];
			vetor[i+1] = aux;
			i++;
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
