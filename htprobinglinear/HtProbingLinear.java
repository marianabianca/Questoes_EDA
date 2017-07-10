package tsteda.htprobinglinear;

import java.util.Arrays;
import java.util.Scanner;

class HtProbingLinear {
	private Tupla[] ht;
	private int qtd;

	public HtProbingLinear(int size) {
		ht = new Tupla[size];
		qtd = 0;
	}

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);

		int size = rdr.nextInt();
		rdr.nextLine();
		HtProbingLinear hashTable = new HtProbingLinear(size);

		String[] entrada = rdr.nextLine().split(" ");
		String saida = null;

		while (!entrada[0].equals("end")) {

			saida = null;
			if (entrada[0].equals("put")) {
				int key = Integer.parseInt(entrada[1]);
				saida = hashTable.push(key, entrada[2]);

			} else if (entrada[0].equals("remove")) {
				int key = Integer.parseInt(entrada[1]);
				saida = hashTable.pop(key);

			} else if (entrada[0].equals("keys")) {
				saida = hashTable.keys();

			} else if (entrada[0].equals("values")) {
				saida = hashTable.values();

			}

			System.out.println(saida);
			entrada = rdr.nextLine().split(" ");
		}

		rdr.close();
	}

	public String push(int key, String value) {
		if (!isFull()) {
			Tupla atual = new Tupla(key, value);
			int hash = key % ht.length;
			int cont = 0;
			while (ht[hash] != null && cont < ht.length) {
				if (ht[hash].getKey() == key) {
					break;
				}
				hash++;
				hash = hash % ht.length;
				cont++;
			}

			if (ht[hash] == null) {
				ht[hash] = atual;
				qtd++;
				
			} else if (ht[hash].getKey() == key) {
				ht[hash].setValue(value);
			}
		}
		return this.toString();
	}

	private boolean isFull() {
		return qtd == ht.length;
	}

	public String pop(int key) {
		int hash = key % ht.length;
		int cont = 0;
		while (cont < ht.length) {
			if (ht[hash] != null) {
				if (ht[hash].getKey() == key) {
					break;
				}
			}
			hash++;
			hash = hash % ht.length;
			cont++;
		}
		
		if (cont != ht.length) {
			ht[hash] = null;
		}
		qtd--;
		return this.toString();
	}

	public String keys() {
		int[] keys = new int[qtd];
		int cont = 0;
		for (Tupla tuple : ht) {
			if (tuple != null) {
				keys[cont] = tuple.getKey();
				cont++;
			}
		}

		Arrays.sort(keys);
		return Arrays.toString(keys);
	}

	public String values() {
		String[] values = new String[qtd];
		int cont = 0;
		for (Tupla tuple : ht) {
			if (tuple != null) {
				values[cont] = tuple.getValue();
				cont++;
			}
		}

		Arrays.sort(values);
		return Arrays.toString(values);
	}

	@Override
	public String toString() {
		return Arrays.toString(ht);
	}
}

class Tupla {
	private int key;
	private String value;

	public Tupla(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return this.key;
	}

	public String getValue() {
		return this.value;
	}
	
	public void setValue(String newValue) {
		this.value = newValue;
	}

	@Override
	public String toString() {
		return ("<" + this.key + ", " + this.value + ">");
	}

}