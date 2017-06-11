package tsteda.pilhacomarray;

import java.util.Scanner;

class PilhaComArray {
	private int contador;
	private int[] array;
	private static final String VAZIO = "empty";
	private static final String CHEIO = "full";

	public PilhaComArray(int tamanho) {
		this.contador = 0;
		this.array = new int[tamanho];
	}
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		int tamanho = rdr.nextInt(); rdr.nextLine();
		PilhaComArray pilha = new PilhaComArray(tamanho);
		
		while(true) {
			String[] entrada = rdr.nextLine().split(" ");
			if (entrada[0].equals("end")) {
				break;
			}
			String result;
			if (entrada[0].equals("push")) {
				result = pilha.recebeComando(entrada[1]);
			} else {
				result = pilha.recebeComando(entrada[0]);
			}
			if (result != null) {
				System.out.println(result);
			}
		}
		
		rdr.close();
	}
	
	public String recebeComando(String comando) {
		if (comando.equals("pop")) {
			return this.pop();
		} else if (comando.equals("peek")) {
			return this.peek();
		} else if (comando.equals("print")) {
			return this.print();
		} else {
			return this.push(Integer.parseInt(comando));
		}
	}
	
	public String pop(){
		String saida = null;
		if (contador == 0) {
			saida = VAZIO;
		} else {
			array[this.contador-1] = 0;
			this.contador--;
		}
		return saida;
	}
	
	public String push(int numero) {
		String saida = null;
		if (contador == array.length) {
			saida = CHEIO;
		} else {
			array[this.contador] = numero;
			this.contador++;
		}
		return saida;
	}
	
	public String print() {
		String saida = null; 
		if (this.contador == 0) {
			saida = VAZIO;
		} else {
			saida = "";
			for (int i = 0; i < this.contador; i++) {
				saida += this.array[i];
				if(i!=contador-1) {
					saida += " ";
				}
			}
		}
		return saida;
	}
	
	public String peek() {
		String saida = null;
		if (contador == 0) {
			saida = VAZIO;
		} else {
			saida = Integer.toString(array[this.contador-1]);
		}
		return saida;
	}
	
}
