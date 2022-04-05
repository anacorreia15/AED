package aulasPraticas;

public class Ficha3 {

	public static void main(String[] args) {

		//Testar algoritmo Ordena Selecao
//		int []teste1 = criarVetorOrdenado(100000);
//		int []embaralhado1 = embaralharVetor(teste1,2*100000);
//		
//		// Cronometro
//		long inicio,fim,tempo;
//		inicio=System.nanoTime();
//		//metedo que vamos medir o tempo
//		ordenaSeleccao(embaralhado1);
//		fim=System.nanoTime();
//		tempo=fim-inicio;
//		System.out.println("a tarefa demorou "+tempo+" nanosegundos");
		
		//Testar algoritmo Ordena Permutacao
//		int []teste2 = criarVetorOrdenado(100000);
//		int []embaralhado2 = embaralharVetor(teste2,2*100000);
//		
//		// Cronometro
//		long inicio,fim,tempo;
//		inicio=System.nanoTime();
//		//metedo que vamos medir o tempo
//		ordenaPermutacao(embaralhado2);
//		fim=System.nanoTime();
//		tempo=fim-inicio;
//		System.out.println("a tarefa demorou "+tempo+" nanosegundos");
		
		//Testar algoritmo Ordena Inserecao
//		int []teste3 = criarVetorOrdenado(100000);
//		int []embaralhado3 = embaralharVetor(teste3,2*100000);
//		
//		// Cronometro
//		long inicio,fim,tempo;
//		inicio=System.nanoTime();
//		//metedo que vamos medir o tempo
//		ordenaPermutacao(embaralhado3);
//		fim=System.nanoTime();
//		tempo=fim-inicio;
//		System.out.println("a tarefa demorou "+tempo+" nanosegundos");
		
		//Testar QuickSort
//		int []teste4 = criarVetorOrdenado(100000);
//		int []embaralhado4 = embaralharVetor(teste4,2*100000);
//		
//		// Cronometro
//		long inicio,fim,tempo;
//		inicio=System.nanoTime();
//		//metedo que vamos medir o tempo
//		ordenaQuickSort(embaralhado4, 0, embaralhado4.length-1);
//		fim=System.nanoTime();
//		tempo=fim-inicio;
//		System.out.println("a tarefa demorou "+tempo+" nanosegundos");
		
		//Testar MergeSort
//		int []teste5 = criarVetorOrdenado(100000);
//		int []embaralhado5 = embaralharVetor(teste5,2*100000);
//		
//		// Cronometro
//		long inicio,fim,tempo;
//		inicio=System.nanoTime();
//		//metedo que vamos medir o tempo
//		ordenaMergeSort(embaralhado5);
//		fim=System.nanoTime();
//		tempo=fim-inicio;
//		System.out.println("a tarefa demorou "+tempo+" nanosegundos");
	}

	//criar vetor ordenado
	static int [] criarVetorOrdenado(int nElementos) {

		int vect[]= new int [nElementos];

		for(int i = 0; i<vect.length; i++)
			vect[i] = i;

		return vect;
	}
//-----------------------------------------------------------------------------
	//embaralhar vetor
	public static int [] embaralharVetor(int[] vetorAEmbaralhar, int numeroDeTrocas) {
		int a, b, aux;
		for (int i=0; i<numeroDeTrocas; i++) {
			a=(int)(Math.random() * vetorAEmbaralhar.length);
			b=(int)(Math.random() * vetorAEmbaralhar.length);

			aux = vetorAEmbaralhar[a];
			vetorAEmbaralhar[a]=vetorAEmbaralhar[b];
			vetorAEmbaralhar[b]=aux;
		}
		return vetorAEmbaralhar;
	}
//-----------------------------------------------------------------------------
	//Ordenar por selecao
	static void ordenaSeleccao( int oVector[] ) {
		for( int i = 0; i < oVector.length - 1; i++ ) {
			int min = i;
			for( int j = i + 1; j < oVector.length; j++ )
				if( oVector[ min ] > oVector[ j ] )
					min = j;
			int aux = oVector[ min ];
			oVector[ min ] = oVector[ i ];
			oVector[ i ] = aux;
		}
	}
//-----------------------------------------------------------------------------
	//Ordenar por Permutacao
	static void ordenaPermutacao(int oVector[]) {
		boolean ordenado = false;
		int i = 0;
		while(i < oVector.length - 1 && !ordenado) {
			ordenado = true;
			for(int j = oVector.length - 1; j > i; j--) {
				if(oVector[j - 1] > oVector[ j ]) {
					int aux = oVector[ j - 1 ];
					oVector[ j - 1 ] = oVector[ j ];
					oVector[ j ] = aux;
					ordenado = false;
				}
			}
			i++;
		}		
	}
//-----------------------------------------------------------------------------
	//Ordenar por Inserecao
	static void ordenaInsercao(int oVector[]) {
		for( int i = 1; i < oVector.length; i++ ) {
			int x = oVector[ i ];
			int j = i;
			while( j > 0 && oVector[ j-1 ] > x ){
				oVector[ j ] = oVector[ j-1 ];
				j--;
			}
			oVector[ j ] = x;
		}
	}
//-----------------------------------------------------------------------------
	//Ordenar por Quick-Sort
	static void troca(int[] v, int i, int j) {
		int temp = v[i];
		v[i] = v[j];
		v[j] = temp;
	}

	static int dividirVetor(int[] v, int ini, int fim) { 
		int pivot = v[fim];
		// Index of smaller element and
		// indicates the right position
		// of pivot found so far
		int i = (ini - 1);

		for(int j = ini; j <= fim - 1; j++) {
			// If current element is smaller
			// than the pivot
			if (v[j] < pivot) {
				// Increment index of
				// smaller element
				i++;
				troca(v, i, j);
			}
		}
		troca(v, i + 1, fim);
		return (i + 1);
	}

	static void ordenaQuickSort(int v[], int ini, int fim) {
		if (ini < fim)
		{
			/* pi is partitioning index, arr[pi] is now
		           at right place */
			int pi = dividirVetor(v, ini, fim);

			ordenaQuickSort(v, ini, pi - 1);  // Before pi
			ordenaQuickSort(v, pi + 1, fim); // After pi
		}
	}
//-----------------------------------------------------------------------------
	//Ordenar por MergeSort
	static void ordenaMergeSort( int v[] ) {
		// criar o vector auxiliar para o reagrupamento
		int vAux[] = new int[ v.length ];
		// dividir em dois e começar a recursão
		// indicando onde começa e acaba o vector a ser ordenado
		mergeSortRec( v, vAux, 0, v.length-1);
	}

	static void mergeSortRec( int v[], int vAux[], int esq, int dir ) {
		if( esq >= dir ) // se só tem um elemento não faz nada
			return;
		// senão divide em duas partes e ordena essas partes
		int centro = (esq + dir) / 2;
		mergeSortRec( v, vAux, esq, centro ); // 1ª metade
		mergeSortRec( v, vAux, centro+1, dir ); // 2ª metade
		// as partes já estão ordenadas, reagrupá-las
		reagrupar( v, vAux, esq, centro+1, dir);
	}

	static void reagrupar( int v[], int vAux[], int i1, int i2, int fim2 ) {
		// a primeira parte do vector vai de i1 a i2-1
		int fim1 = i2-1;
		// e a segunda de i2 a fim
		// guardar o início pois vai ser preciso para a cópia final
		int inicio = i1;
		// o índice do vector auxiliar vai começar em i1
		int iAux = i1;
		// enquanto houver elementos nos dois vectores
		// copiar o menor para vAux e incrementar o i respectivo
		while( i1 <= fim1 && i2 <= fim2 ){
			if( v[ i1 ] < v[ i2 ] ) {
				vAux[iAux] = v[ i1 ];
				i1++;
			}
			else {
				vAux[iAux] = v[ i2 ];
				i2++;
			}
			iAux++;
		}
		for( ; i1 <= fim1; i1++, iAux++ ) // o 2º vector acabou
			vAux[ iAux ] = v[ i1 ];
		for( ; i2 <= fim2; i2++, iAux++ ) // o 1º vector acabou
			vAux[ iAux ] = v[ i2 ];
		// copiar novamente para origem
		for( int i = inicio; i <= fim2; i++ )
			v[i] = vAux[i];
	}

}
