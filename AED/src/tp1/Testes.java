package tp1;

public class Testes {

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
		System.out.println("\n\n --# M�O DO JOGADOR: 1 #--\n");
		imprimirCartas(j1);
		System.out.println("\n\n --# M�O DO JOGADOR: 2 #--\n");
		imprimirCartas(j2);
		System.out.println("\n\n --# M�O DO JOGADOR: 3 #--\n");
		imprimirCartas(j3);
		System.out.println("\n\n --# M�O DO JOGADOR: 4 #--\n");
		imprimirCartas(j4);

		ordenar_jog1(j1);
		ordenar_jog2(j2);
		ordenar_jog3(j3);
		ordenar_jog4(j4, 0, j4.length-1);
		System.out.println("\n\nM�O ORDENADA DO JOGADOR: 1 #--\n");
		imprimirCartas(j1);
		System.out.println("\n\nM�O ORDENADA DO JOGADOR: 2 #--\n");
		imprimirCartas(j2);
		System.out.println("\n\nM�O ORDENADA DO JOGADOR: 3 #--\n");
		imprimirCartas(j3);
		System.out.println("\n\nM�O ORDENADA DO JOGADOR: 4 #--\n");
		imprimirCartas(j4);

	}

	public static Carta[] criarBaralho(){
		Carta bar[]=new Carta[52];
		int i=0;
		for( int n=Carta.COPAS;n<=Carta.PAUS;n++ )
			for( int f=Carta.AZ;f<=Carta.REI;f++ ){
				bar[i]=new Carta(f,n);
				i++;
			}
		return bar;
	}

	public static void imprimirCartas(Carta car[]){
		for(int i=0;i<car.length;i++)System.out.println(car[i]);
	}
	//-----------------------------------------------------------------------------	
	public static void embaralhar(Carta bar[]){
		/*
		 *  IMPLEMENTAR ESTE ALGORITMO DE PREFER�NCIA QUE REFLITA 
		 *  A FORMA COMO BARALHAMOS NA PR�TICA
		 */
		final int repeticoes = 30;
		//SUGEST�O 2
		//repete 30x
		//divide o baralho em dois montes iguais esq/dir
		//retira um numero aleatorio de cartas (entre 2 e 5) 
		//de cada monte e coloca no baralho
		//at� este ter as 40 cartas novamente

		for ( int i=0; i<repeticoes; i++ ) {
			int totalCartas = 0; // Guardar cartas já colocadas no baralho
			Carta[] esq = new Carta[bar.length/2]; // baralho da esquerda
			Carta[] dir = new Carta[bar.length/2]; // baralho da direita

			// Divide o baralho em 2, esquerda e direita
			for( int j=0, k=0; j<bar.length; j++ ) {
				if ( j<bar.length/2 ) {
					esq[j]=bar[j].clone();
				} else {
					dir[k]=bar[j].clone();
					k++;
				}
			}

			while( totalCartas < bar.length ) { // Ciclo:Enquanto o baralho não está completo, ou seja, até serem colocadas 52 ou 40 cartas
				// Número de cartas a retirar de ambos os baralhos (2 a 5 cartas)
				int tamanho = (int) (Math.random() * (6-2)) + 2; // 6 = Máximo (exclusivo, ou seja, max 6 dá 5)

				// Se o tamanho*2 (tamanho da direita + tamanho da esquerda) > total cartas
				if ( totalCartas + tamanho * 2 >= bar.length ) {
					// Vai buscar as cartas que faltam no baralho inicial 
					// exemplo: 52 - 48 = 4 -> fazer 2 baralhos de 2 cartas
					tamanho = (bar.length - totalCartas) / 2;
				}

				// OBS: soma de dois números iguais é sempre par

				// Array para guardar as cartas da esquerda e da direita para colocar no baralho final
				final Carta[] temp = new Carta[tamanho*2];
				// Posicao das cartas no baralho temporario
				int separador = totalCartas / 2;

				// No array temporario, começa por colocar primeiro as cartas do baralho da direita e depois as da esquerda
				for ( int k = separador, z = 0; z < tamanho; k++, z++ ) {
					temp[z] = dir[k];
					temp[z+tamanho] = esq[k];

				}
				//agilizar
				for ( Carta carta : temp ) {
					bar[totalCartas] = carta;
					totalCartas++;
				}
			}
		}
	}

	public static Carta[] retirar_8_9_10(Carta bar[]){
		/*
		 *	CRIAR UM VECTOR DE CARTAS NOVO
		 *	COM EXCLUS�O DOS 8, 9 E 10
		 *	ADICIONAR A ESTE VECTOR TODAS AS CARTAS DO BARALHO 		 
		 *	DEVOLVER O VECTOR NOVO
		 */
		Carta barSem_8_9_10[] = new Carta[40];

		int n = 0;
		for( int i = 0; i < bar.length; i++ ) {
			if( bar[i].getFace() < 8 || bar[i].getFace() > 10 ) {
				barSem_8_9_10[n] = bar[i].clone();
				n++;
			}
		}

		return barSem_8_9_10;
	}	

	public static void darCartas(Carta bar[],Carta j1[],Carta j2[],Carta j3[],Carta j4[]){
		/*
		 * ENQUANTO NÃO CHEGAR AO FIM DO BARALHO
		 *   DAR UMA CARTA A CADA JOGADOR
		 */
		for( int i = 0,n = 0; i<j1.length; i++,n+=3 ){
			j1[i]=bar[i+n];
			j2[i]=bar[i+1+n];
			j3[i]=bar[i+2+n];
			j4[i]=bar[i+3+n];		
		}
	}

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
				Carta x = j3[ i ];
				int j = i;
				while( j > 0 && j3[ j-h ].compareTo(x) > 0 ){
					j3[ j ] = j3[ j-h ];
					j -= h;
				}
				j3[ j ] = x;
			}
		} while( h > 1 );
	}
	//-----------------------------------------------------------------------------
	/*
	 * Metodos do QuickSort (troca, dividirVetor e ordenar_jog4)
	 */
	static void troca(Carta[] v, int i, int j) {
		Carta temp = v[i];
		v[i] = v[j];
		v[j] = temp;
	}

	static int dividirVetor(Carta[] v, int ini, int fim) { 
		Carta pivot = v[fim];
		// Index of smaller element and
		// indicates the right position
		// of pivot found so far
		int i = (ini - 1);

		for(int j = ini; j <= fim - 1; j++) {
			// If current element is smaller
			// than the pivot
			if (v[j].compareTo(pivot) < 0) {
				// Increment index of
				// smaller element
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
			/* pi is partitioning index, arr[pi] is now
	           at right place */
			int pi = dividirVetor(j4, ini, fim);

			ordenar_jog4(j4, ini, pi - 1);  // Before pi
			ordenar_jog4(j4, pi + 1, fim); // After pi
		}
	}

}
