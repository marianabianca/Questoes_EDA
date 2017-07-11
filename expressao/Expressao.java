package tsteda.expressao;

import java.util.Scanner;

class Expressao {
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		String entrada = rdr.nextLine();
		System.out.println(calculaExpressao(entrada));
		
		rdr.close();
	}

	private static String calculaExpressao(String entrada) {
		String[] pilha = new String[entrada.length()];
		for (int i = 0; i < pilha.length; i++) {
			pilha[i] = "";
		}
		int posNaPilha = 0;
		
		for (int i = 0; i < entrada.length(); i++) {
			String caractere = Character.toString(entrada.charAt(i));
			if (caractere.equals("(")){
				posNaPilha++;
			} else if (caractere.equals(")")) {
				int resultado = resolveExpressao(pilha[posNaPilha]);
				pilha[posNaPilha] = "";
				posNaPilha--;
				pilha[posNaPilha] += resultado;
			} else {
				pilha[posNaPilha] += caractere;
			}
			
		}
		return Integer.toString(resolveExpressao(pilha[0]));
	}

	private static int resolveExpressao(String expressao) {
		String[] numeros = splitNosOperadores(expressao);
		String seqOperacoes = sequenciaDeOperacoes(expressao);
		
		int resultado = Integer.parseInt(numeros[0]);
		String operacaoAtual;
		
		for (int i = 0; i < numeros.length-1; i++) {
			operacaoAtual = Character.toString(seqOperacoes.charAt(i));
			int numDaVez = Integer.parseInt(numeros[i+1]);
			if (operacaoAtual.equals("+") || operacaoAtual.equals("-")) {
				resultado = resultado + numDaVez;
			} else if (operacaoAtual.equals("*")) {
				resultado = resultado * numDaVez;
			} else {
				resultado = resultado / numDaVez;
			}
		}
		
		return resultado;
	}
	
	private static String[] splitNosOperadores(String expressao) {
		String[] resultadoBruto = new String[expressao.length()];
		int pos = 0;
		resultadoBruto[pos] = "";
		for (int i = 0; i < expressao.length(); i++) {
			String simbolo = Character.toString(expressao.charAt(i));
			if (simbolo.equals("+") || simbolo.equals("-") || simbolo.equals("*") || simbolo.equals("/")) {
				if (!(resultadoBruto[pos].trim().equals(""))) {
					pos += 1;
				}
				if (resultadoBruto[pos] == null) {
					resultadoBruto[pos] = "";
				}
				if (simbolo.equals("-")) {
					resultadoBruto[pos] += simbolo;
				}
			} else {
				resultadoBruto[pos] += simbolo;
			}
		}
		
		String[] resultado = new String[pos+1];
		for (int i = 0; i <= pos; i++) {
			resultado[i] = resultadoBruto[i];
		}
		
		return resultado;
	}
	
	private static String sequenciaDeOperacoes(String expressao) {
		char[] array = expressao.toCharArray();
		String operacoesBasicas = "+-*/";
		String seqOperacoes = "";
		
		String aux = "";
		for (int i = 0; i < expressao.length(); i++) {
			aux += array[i];
			if (operacoesBasicas.contains(aux)) {
				if (aux.equals("-") && i != 0) {
					aux = "";
					aux += array[i-1];
					if (!operacoesBasicas.contains(aux)) {
						aux = "";
						aux += array[i];
						seqOperacoes += aux;
					}
				} else {
					seqOperacoes += aux;
				}
			}
			
			aux = "";
		}
		
		return seqOperacoes;
	}
	
	
}
