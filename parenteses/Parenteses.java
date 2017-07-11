package tsteda.parenteses;

import java.util.Scanner;

class Parenteses {
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		String entrada = rdr.nextLine();
		System.out.println(confereEntrada(entrada));
		
		rdr.close();
	}
	
	public static String confereEntrada(String entrada) {
		int contador = 0;
		int i = 0;
		
		while (i < entrada.length()) {
			String letra = Character.toString(entrada.charAt(i));
			if (letra.equals("(")) {
				contador += 1;
			} else if (letra.equals(")")) {
				contador -= 1;
			}
			
			if (contador < 0) {
				break;
			}
			
			i++;
		}
		
		
		if (contador == 0) {
			return "S";
		}
		
		return "N";
	}

}
