package tp2;

import java.util.Scanner;

public class Menu {

	public static void imprimirMenu() {
		System.out.println("Opções: ");
		System.out.println("1) Inserir texto a partir de um ficheiro");
		System.out.println("2) Inserir texto a partir da consola");
		System.out.println("3) Procurar Palavras");
		System.out.println("4) Remover Palavras");
		System.out.println("5) Balancear a Árvore");
		System.out.println("0) Sair");
	}

	public static void inserirTextoFicheiro() {

	}

	public static void inserirTextoConsola() {

	}

	public static void procurarPalavras() {

	}
	
	public static void removerPalavras() {

	}
	
	public static void balancearArvore() {

	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int  opcao = 0;
		
		ArvoreBinaria ab = new ArvoreBinaria();

		do {
			imprimirMenu();
			opcao = read.nextInt();
			switch(opcao) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:
				break;

			default:
			}

		} while(opcao != 0);
		read.close();

	}
}
