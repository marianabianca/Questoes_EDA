package tsteda.multiplicaporn;

import java.util.Scanner;

class MultiplicaPorN {
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		int n = rdr.nextInt();
		rdr.nextLine();
		String[] entrada = rdr.nextLine().split(" ");
		int[] numeros = new int[entrada.length];
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = Integer.parseInt(entrada[i]);
			numeros[i] *= n;
		}
		
		String saida = "";
		
		for (int i = 0; i < numeros.length; i++) {
			saida += numeros[i];
			if (!(i == (numeros.length -1))) {
				saida += " ";
			}
		}
		
		System.out.println(saida);
		
		rdr.close();
	}
	
}
