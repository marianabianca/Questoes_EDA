package tsteda.teoremamestre;

import java.util.Scanner;

class TeoremaMestre {

	public static void main(String[] args) {
		
		Scanner rdr = new Scanner(System.in);
		String[] entrada = rdr.nextLine().split(" ");
		
		int a = Integer.parseInt(entrada[0]);
		int b = Integer.parseInt(entrada[1]);
		int ord = Integer.parseInt(entrada[2]);
		
		String saida = "T(n) = theta(";

		double logbase10a = Math.log10(a);
		double logbase10b = Math.log10(b);

		double logabaseb = logbase10a / logbase10b;

		if (ord < logabaseb) {
			saida += "n**" + logabaseb + ")";
		} else if (ord == logabaseb) {
			saida += "n**" + ord +  " * log n)";
		} else {
			saida += "n**" + ord + ")";
		}
		
		System.out.println(saida);
		rdr.close();
	}
	
}
