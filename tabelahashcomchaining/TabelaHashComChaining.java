package tsteda.tabelahashcomchaining;

import java.util.ArrayList;
import java.util.Scanner;

class TabelaHashComChaining {
	private ArrayList[] tabela;
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		int tamanho = rdr.nextInt(); rdr.nextLine();
		TabelaHashComChaining tabela = new TabelaHashComChaining(tamanho);
		
		String entrada = rdr.nextLine();
		
		while (!entrada.equals("end")) {
			
			String[] comando = entrada.split(" ");
			String saida = null;
			
			if (comando[0].equals("put")) {
				int chave =  Integer.parseInt(comando[1]);
				saida = tabela.put(chave, comando[2]);
			} else if (comando[0].equals("remove")) {
				int chave =  Integer.parseInt(comando[1]);
				saida = tabela.remove(chave);
			} else if (comando[0].equals("keys")) {
				saida = tabela.chaves();
			} else if (comando[0].equals("values")) {
				saida = tabela.valores();
			}
			
			System.out.println(saida);
			entrada = rdr.nextLine();
		}
		
		rdr.close();
	}
	
	
	public TabelaHashComChaining(int tamanho) {
		tabela = new ArrayList[tamanho];
	}
	
	public String put(int chave, String valor) {
		Tupla aInserir = new Tupla(chave, valor);
		int pos = getPosicao(chave);
		if (tabela[pos] == null) {
			tabela[pos] = new ArrayList<Tupla>();
		}
		if (podeInserir(chave)){
			tabela[pos].add(aInserir);
		} else {
			this.remove(chave);
			this.put(chave, valor);
		}
		
		return this.toString();
	}
	
	public String remove(int chave) {
		int pos = getPosicao(chave);
		
		for (int i = 0; i < tabela[pos].size(); i++) {
			Tupla atual = (Tupla) tabela[pos].get(i);
			if (atual.getChave() == chave) {
				tabela[pos].remove(i);
			}
		}
		
		return this.toString();
	}
	
	@Override
	public String toString() {
		String elemento = "[";
		
		for (int i = 0; i < tabela.length; i++) {
			elemento += "[";
			if (tabela[i] != null) {
				for (int j = 0; j < tabela[i].size(); j++) {
					Tupla atual = (Tupla) tabela[i].get(j);
					elemento += atual.toString();
				}
			}
			elemento += "]";
		}
		elemento += "]";
		
		return elemento;
	}
	
	public String chaves() {
		String chaves = "[";
		
		for (int i = 0; i < tabela.length; i++) {
			if (tabela[i] != null) {
				for (int j = 0; j < tabela[i].size(); j++) {
					Tupla atual = (Tupla) tabela[i].get(j);
					chaves += atual.getChave();
					if (j != tabela[i].size()-1 && i != tabela.length -1) {
						chaves += ", ";
					}
				}
			}
		}
		chaves += "]";
		
		return chaves;
	}
	
	public String valores() {
		String valores = "[";
		
		for (int i = 0; i < tabela.length; i++) {
			if (tabela[i] != null) {
				for (int j = 0; j < tabela[i].size(); j++) {
					Tupla atual = (Tupla) tabela[i].get(j);
					valores += atual.getValor();
					if (j != tabela[i].size()-1) {
						valores += ", ";
					}
				}
			}
		}
		valores += "]";
		
		return valores;
	}
	
	private boolean podeInserir(int chave) {
		boolean retorno = true;
		int pos = getPosicao(chave);
		
		for (int i = 0; i < tabela[pos].size(); i++) {
			Tupla atual = (Tupla) tabela[pos].get(i); 
			if (atual.getChave() == chave) {
				retorno = false;
			}
		}
		
		return retorno;
	}

	private int getPosicao(int chave) {
		return chave % tabela.length;
	}
	
}


class Tupla {
	private final String S;
	private final int T;
	
	public Tupla(int chave, String valor) {
		this.S = valor;
		this.T= chave;
	}
	
	public int getChave() {
		return T;
	}
	
	public String getValor() {
		return S;
	}
	
	@Override
	public String toString(){
		return ("<" + this.T + ", " + this.S + ">");
	}
}