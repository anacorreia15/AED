package aulasPraticas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ficha6 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int  opcao = 0;

//		Lista baralho = new Lista();

		do {
			imprimirMenu();
			opcao = read.nextInt();
			switch(opcao) {
			case 1:
				lerFicheiro();
				break;
			case 2:
				procurarPalavra();
				break;
			case 3:
				apagarPalavra();
				break;
			case 4:
				gravarFicheiro();
				break;

			default:
			}

		} while(opcao != 0);
		read.close();
	}
	
	public static void imprimirMenu() {
		System.out.println("Opções: ");
		System.out.println("1. Ler ficheiro");
		System.out.println("2. Procurar uma palavra");
		System.out.println("3. Apagar uma palavra");
		System.out.println("4. Gravar ficheiro");
		System.out.println("0. Terminar");
	}
	
	public static void lerFicheiro() {
		String palavra;
		File file = new File("palavras.txt");
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine())
				palavra = sc.nextLine();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void procurarPalavra() {
		
	}
	
	public static void apagarPalavra() {
		
	}

	public static void gravarFicheiro() {
		try {
			PrintWriter writer = new PrintWriter("nome_do_ficheiro.txt");
			writer.println("escreve uma linha no ficheiro");
			writer.println("escreve outra linha no ficheiro");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void medirTempo() {
		long inicio, fim, duracao;
		inicio=System.nanoTime();
		//chamar metodo
		fim=System.nanoTime();
		duracao=fim-inicio;
		System.out.println("Duração: " + duracao + " nanosegundos");
	}
	
}
