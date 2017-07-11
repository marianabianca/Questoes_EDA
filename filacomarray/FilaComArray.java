package tsteda.filacomarray;

import java.util.Scanner;

class FilaComArray {
	private int contador;
	private int[] array;
	private static final String CHEIO = "full";
	private static final String VAZIO = "empty";
	
	public FilaComArray(int tamanho) {
		this.contador = -1;
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
		if (isEmpty()) {
			saida = VAZIO;
		} else {
			saida = "";
			for (int i = 0; i <= this.contador; i++) {
				saida += this.array[i];
				if(i!=contador) {
					saida += " ";
				}
			}
		}
		return saida;
	}

	public String add(int numero) {
		String retorno = null;
		if (isFull()) {
			retorno = CHEIO;
		} else {
			this.contador++;
			array[this.contador] = numero;
		}
		return retorno;
	}
	
	private boolean isEmpty() {
		return contador == -1;
	}
	
	private boolean isFull(){
		return contador == array.length-1;
	}
	public String remove() {
		String retorno = null;
		if (isEmpty()) {
			retorno = VAZIO;
		} else {
			swapBack();
			this.contador--;
		}
		return retorno;
	}
	
	public String element() {
		String retorno = null;
		if (isEmpty()) {
			retorno = VAZIO;
		} else {
			retorno = Integer.toString(this.array[0]);
		}
		return retorno;
	}
	
	private void swapBack() {
		for (int i = 0; i < contador; i++) {
			swap(i, i+1);
		}
	}

	private void swap(int i, int j) {
		int aux = this.array[i];
		this.array[i] = this.array[j];
		this.array[j] = aux;
	}
	
}
