package tp1;

import java.util.concurrent.ThreadLocalRandom;

/*
 * CLASSE PRINCIPAL
 * 
 * SO DEVEM ADICIONAR CODIGO NAS ZONAS IDENTIFICADAS COM COMENTARIOS
 * E ACONSELHA-SE A SEGUIREM OS ALGORITMOS ESPECIFICADOS
 */
public class Main {
	//-----------------------------------------------------------------------------	
	public static void main(String[] args) {	
		Carta baralho[]=criarBaralho();
		Carta j1[]=new Carta[10]; //mao de cada jogador
		Carta j2[]=new Carta[10];
		Carta j3[]=new Carta[10];
		Carta j4[]=new Carta[10];		

		System.out.println("--# BARALHO CRIADO #--\n");
		imprimirCartas(baralho);	

		baralho=retirar_8_9_10(baralho);
		System.out.println("\n\n--# BARALHO SEM 8, 9 E 10 #--\n");
		imprimirCartas(baralho);

		embaralhar(baralho);		
		System.out.println("\n\n--# BARALHO EMBARALHADO #--\n");
		imprimirCartas(baralho);		

		darCartas(baralho,j1,j2,j3,j4);
		System.out.println("\n\n--# BARALHO DISTRIBUIDO PELOS JOGADORES #--\n");		
		System.out.println("\n\n --# MÃO DO JOGADOR: 1 #--\n");
		imprimirCartas(j1);
		System.out.println("\n\n --# MÃO DO JOGADOR: 2 #--\n");
		imprimirCartas(j2);
		System.out.println("\n\n --# MÃO DO JOGADOR: 3 #--\n");
		imprimirCartas(j3);
		System.out.println("\n\n --# MÃO DO JOGADOR: 4 #--\n");
		imprimirCartas(j4);

		ordenar_jog1(j1);
		ordenar_jog2(j2);
		ordenar_jog3(j3);
		ordenar_jog4(j4, 0, j4.length-1);
		System.out.println("\n\nMÃO ORDENADA DO JOGADOR: 1 #--\n");
		imprimirCartas(j1);
		System.out.println("\n\nMÃO ORDENADA DO JOGADOR: 2 #--\n");
		imprimirCartas(j2);
		System.out.println("\n\nMÃO ORDENADA DO JOGADOR: 3 #--\n");
		imprimirCartas(j3);
		System.out.println("\n\nMÃO ORDENADA DO JOGADOR: 4 #--\n");
		imprimirCartas(j4);
	}
	//-----------------------------------------------------------------------------	
	public static Carta[] criarBaralho(){
		Carta bar[]=new Carta[52];
		int i=0;
		for(int n=Carta.COPAS;n<=Carta.PAUS;n++)
			for(int f=Carta.AZ;f<=Carta.REI;f++){
				bar[i]=new Carta(f,n);
				i++;
			}
		return bar;
	}
	//-----------------------------------------------------------------------------		
	public static void imprimirCartas(Carta car[]){
		for(int i=0;i<car.length;i++)System.out.println(car[i]);
	}
	//-----------------------------------------------------------------------------	
	public static void embaralhar(Carta bar[]){
		/*
		 *  IMPLEMENTAR ESTE ALGORITMO DE PREFER�NCIA QUE REFLITA 
		 *  A FORMA COMO BARALHAMOS NA PR�TICA
		 */

		//SUGEST�O 2
		//repete 30x
		//divide o baralho em dois montes iguais esq/dir
		//retira um numero aleatorio de cartas (entre 2 e 5) 
		//de cada monte e coloca no baralho
		//at� este ter as 40 cartas novamente

		final int repeticoes = 30;
		final int tamanhoBaralho = bar.length;
		final int metadeTamanho = tamanhoBaralho / 2;

		for (int i = 0; i < repeticoes; i++) {
			int totalCartas = 0; // Guardar total de cartas já postas no baralho
			final Carta[] esq = new Carta[metadeTamanho]; // baralho da esquerda
			final Carta[] dir = new Carta[metadeTamanho]; // baralho da direita

			// Divide o baralho em 2, esquerda e direita e coloca as cartas nos arrays esq e dir
			// j é o contador para esq, k é o contador para a direita
			for(int j = 0, k = 0; j < tamanhoBaralho; j++) {
				if (j < metadeTamanho) { // primeira metade na esquerda
					esq[j] = bar[j].clone();
				} else { // segunda metade na direita
					dir[k] = bar[j].clone();
					k++;
				}
			}

			// Guarda ultimo indice utilizado das metades (esq e dir);
			// Esta variavel evita que se use outros ciclos para puxar as cartas para a frente (posição 0) cada vez
			//  que são retiradas das metades e colocadas no final
			int ultimoIndice = 0;
			// Retira cartas da esq e dir e coloca num "novo" baralho, repete o processo até o baralho estar completo
			while(totalCartas < tamanhoBaralho) {
				// Número de cartas a retirar de ambos os baralhos (2 a 5 cartas)
				// minimo inclusivo, máximo exclusivo
				int cartasARetirar = ThreadLocalRandom.current().nextInt(2,6);

				// Se o tamanho x 2 (como retira da esquerda e da direita) >= tamanho baralho, então vai buscar o resto
				// 	das cartas que faltam e divide por 2
				if (totalCartas + cartasARetirar * 2 >= tamanhoBaralho) {
					// Vai buscar o que falta, exemplo: 52 - 48 = 4, ou seja, vamos que fazer 2 baralhos de 2 cartas
					cartasARetirar = (tamanhoBaralho - totalCartas) / 2;
				}

				// OBS: soma de dois números iguais é sempre par

				// Coloca primeiro as cartas do baralho da direita e depois as cartas do baralho da esquerda.
				// Em vez de usar dois ciclos para colocar primeiro as cartas da direita e depois outro for
				//  para colocar as cartas da esquerda ele coloca ambas em simultâneo, pois se der adicionar-mos o gap
				//  de cartasARetirar ele não coloca a carta da esquerda numa posição da direita
				for (int z = 0; z < cartasARetirar; z++, ultimoIndice++) {
					bar[totalCartas+z] = dir[ultimoIndice];
					// somar cartasARetirar para dar o "gap" das cartas da direita
					bar[totalCartas+z+cartasARetirar] = esq[ultimoIndice];
				}

				// Incrementa total cartas com as cartas retiradas de cada metade (esq e dir)
				totalCartas += cartasARetirar * 2;
			}
		}
	}
	//-----------------------------------------------------------------------------	
	public static Carta[] retirar_8_9_10(Carta bar[]){
		/*
		 *	CRIAR UM VECTOR DE CARTAS NOVO
		 *	COM EXCLUS�O DOS 8, 9 E 10
		 *	ADICIONAR A ESTE VECTOR TODAS AS CARTAS DO BARALHO 		 
		 *	DEVOLVER O VECTOR NOVO
		 */
		final Carta[] barSem_8_9_10 = new Carta[40];
		int n = 0;

		for (Carta c : bar) {
			if (c.getFace() < 8 || c.getFace() > 10) {
				barSem_8_9_10[n] = c.clone();
				n++;
			}
		}

		return barSem_8_9_10;
	}
	//-----------------------------------------------------------------------------	
	public static void darCartas(Carta bar[],Carta j1[],Carta j2[],Carta j3[],Carta j4[]){
		/*
		 * ENQUANTO N�O CHEGAR AO FIM DO BARALHO
		 *   DAR UMA CARTA A CADA JOGADOR
		 */
		for( int i = 0,n = 0; i<j1.length; i++,n+=3 ){
			j1[i]=bar[i+n];
			j2[i]=bar[i+1+n];
			j3[i]=bar[i+2+n];
			j4[i]=bar[i+3+n];		
		}
	}
	//-----------------------------------------------------------------------------	
	/*
	 * IMPLEMENTAR EM CADA UM DESTES M�TODOS UM ALGORITMO DE ORDENAÇÃO
	 * DIFERENTE
	 *
	 * PARA COMPARAR DUAS CARTAS USAR A FUNÇÃO compareTo() 
	 *
	 */
	public static void ordenar_jog1(Carta j1[]){
		// Seleção
		for( int i = 0; i < j1.length - 1; i++ ) {
			int min = i;
			for( int j = i + 1; j < j1.length; j++ )
				if( j1[min].compareTo(j1[j]) > 0 )
					min = j;
			Carta aux = j1[min];
			j1[min] = j1[i];
			j1[i] = aux;
		}
	}
	//-----------------------------------------------------------------------------	
	public static void ordenar_jog2(Carta j2[]){
		// Permutação
		boolean ordenado = false;
		int i = 0;
		while( i < j2.length-1 && !ordenado ) {
			ordenado = true;
			for( int j = j2.length-1; j > i; j-- ) {
				if( j2[j-1].compareTo(j2[j] ) > 0 ) {
					Carta aux = j2[j-1];
					j2[j-1] = j2[j];
					j2[j] = aux;
					ordenado = false;
				}
			}
			i++;
		}			
	}
	//-----------------------------------------------------------------------------	
	public static void ordenar_jog3(Carta j3[]){
		// Shell sort 
		int h;
		// primeiro calcular o maior incremento (h) possivel
		for( h = 1; h < j3.length; h = 3*h + 1);
		do{
			h /= 3; // actualizar o h para esta iteração
			for( int i = h; i < j3.length; i+= h ) {
				Carta x = j3[i];
				int j = i;
				while( j > 0 && j3[j-h].compareTo(x) > 0 ){
					j3[j] = j3[j-h];
					j-=h;
				}
				j3[j] = x;
			}
		} while( h > 1 );
	}
	//-----------------------------------------------------------------------------	
	/*
	 * Metodos do QuickSort (troca, dividirVetor e ordenar_jog4)
	 */
	public static void troca(Carta[] v, int i, int j) {
		Carta temp = v[i];
		v[i] = v[j];
		v[j] = temp;
	}

	public static int dividirVetor(Carta[] v, int ini, int fim) { 
		Carta pivot = v[fim];
		// Índice do elemento menor e indica a posição correta
		// do pivô encontrado até agora
		int i = (ini - 1);

		for(int j = ini; j <= fim - 1; j++) {
			// Se o elemento atual for menor do que o pivô
			if (v[j].compareTo(pivot) < 0) {
				// Incrementa o indice do elemento menor 
				i++;
				troca(v, i, j);
			}
		}
		troca(v, i + 1, fim);
		return (i + 1);
	}

	public static void ordenar_jog4(Carta j4[], int ini, int fim){
		// QuickSort
		if (ini < fim)
		{
			/* pivot é o índice da partição arr[pi] 
			 * agora no lugar certo */
			int pivot = dividirVetor(j4, ini, fim);

			// ordenar ambas as partes dos vetores 
			ordenar_jog4(j4, ini, pivot-1);  // Antes do pivot
			ordenar_jog4(j4, pivot+1, fim); // Depois do pivot
		}
	}
	//-----------------------------------------------------------------------------	
}
