package tsteda.filacomarray;

import java.util.Scanner;

class FilaComArray {
	private int contador;
	private int[] array;
	private static final String CHEIO = "full";
	private static final String VAZIO = "empty";
	
	public FilaComArray(int tamanho) {
		this.contador = 0;
		this.array = new int[tamanho];
	}
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		int tamanho = rdr.nextInt(); rdr.nextLine();
		FilaComArray fila = new FilaComArray(tamanho);
		
		while(true) {
			String[] entrada = rdr.nextLine().split(" ");
			if (entrada[0].equals("end")) {
				break;
			}
			String result;
			if (entrada[0].equals("add")) {
				result = fila.recebeComando(entrada[1]);
			} else {
				result = fila.recebeComando(entrada[0]);
			}
			if (result != null) {
				System.out.println(result);
			}
		}
		
		rdr.close();
	}

	public String recebeComando(String comando) {
		if (comando.equals("element")) {
			return this.element();
		} else if (comando.equals("remove")) {
			return this.remove();
		} else if (comando.equals("print")) {
			return this.print();
		} else {
			return this.add(Integer.parseInt(comando));
		}
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

	public String add(int numero) {
		String retorno = null;
		if (this.contador == array.length) {
			retorno = CHEIO;
		} else {
			array[this.contador] = numero;
			this.contador++;
		}
		return retorno;
	}
	
	public String remove() {
		String retorno = null;
		if (this.contador == 0) {
			retorno = VAZIO;
		} else {
			swapBack();
			this.contador--;
		}
		return retorno;
	}
	
	public String element() {
		String retorno = null;
		if (this.contador == 0) {
			retorno = VAZIO;
		} else {
			retorno = Integer.toString(this.array[0]);
		}
		return retorno;
	}
	
	private void swapBack() {
		for (int i = contador-1; 0 < i; i--) {
			swap(i, i-1);
		}
	}

	private void swap(int i, int j) {
		int aux = this.array[i];
		this.array[i] = this.array[j];
		this.array[j] = aux;
	}
	
}
