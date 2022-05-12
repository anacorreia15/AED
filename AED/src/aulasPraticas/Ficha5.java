package aulasPraticas;
import java.util.Scanner;

public class Ficha5 {
	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		int  opcao = 0, indice = 0;

		Lista baralho = new Lista();

		do {
			imprimirMenu();
			opcao = read.nextInt();
			switch(opcao) {
			case 1:
				adicionarCartas(baralho);
				break;
			case 2:
				imprimirLista(baralho);
				break;
			case 3:
				indice = pedirIndice();
				imprimirCarta(indice, baralho);
				break;
			case 4:
				indice = pedirIndice();
				removerCartaIndice(indice, baralho);
				break;

			default:
			}

		} while(opcao != 0);
		read.close();

	}

	public static void imprimirMenu() {
		System.out.println("Opções: ");
		System.out.println("1. Adicionar cartas ");
		System.out.println("2. Imprimir lista ");
		System.out.println("3. Imprimir uma carta ");
		System.out.println("4. Remover uma carta por índice");
		System.out.println("0. Sair");
	}

	public static int pedirIndice() {
		Scanner read = new Scanner(System.in);
		System.out.println("Indique um índice à escolha: ");
		int indice = read.nextInt();

		return indice;
	}

	public static void adicionarCartas(Lista baralho) {
		//inserir 10 cartas de cada vez
		for(int j=0; j < 10; j++) {
			Carta carta = new Carta();
			if(baralho.procurar(carta)==-1) {
				baralho.inserirOrdem(carta);
			}
		}
	}

	public static void imprimirLista(Lista baralho) {
		for (int i = 0 ; i<baralho.getnElementos(); i++) {
			System.out.println(baralho.get(i) + " ");
		}
		System.out.println();
	} 

	public static void imprimirCarta(int indice, Lista baralho) {
		System.out.println(baralho.get(indice-1));
	}

	public static void removerCartaIndice(int indice, Lista baralho) {
		baralho.retirar(indice-1);
	}
}
