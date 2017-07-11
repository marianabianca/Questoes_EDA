package tsteda.invertepilhasemfila;

import java.util.Scanner;

class InvertePilhaSemFila {
	private int[] pilha;
	private int top;

	public InvertePilhaSemFila(int tamanho) {
		this.pilha = new int[tamanho];
		this.top = -1;
	}

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		int tamanho = rdr.nextInt();rdr.nextLine();
		InvertePilhaSemFila pilha = new InvertePilhaSemFila(tamanho);
		
		String[] sequencia = rdr.nextLine().split(" ");
		int[] numeros = criaArrayDeInteiros(sequencia);
		System.out.println(pilha.pilhaInvertida(numeros));
		
		rdr.close();
	}
	
	private String pilhaInvertida(int[] sequencia) {
		String saida = "";
		
		int atual = pilha.length-1;
		while (atual >= 0) {
			push(sequencia[atual]);
			atual--;
		}
		
		saida += pop();
		while (!isEmpty()) {
			saida += "\n";
			saida += pop();
		}
		
		
		return saida;
	}

	private boolean isEmpty() {
		return top == -1;
	}
	
	private void push(int num) {
		top++;
		pilha[top] = num;
		
	}
	
	private int pop() {
		int aux = pilha[top];
		top--;
		return aux;
	}
	
	static int[] criaArrayDeInteiros(String[] frase) {
		int[] retorno = new int[frase.length]; 
		
		for (int i = 0; i < frase.length; i++) {
			retorno[i] = Integer.parseInt(frase[i]);
		}
		
		return retorno;
	}
	
}
