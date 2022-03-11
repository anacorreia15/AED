package aulasPraticas;

import java.util.Scanner;

public class Ficha1 {
	//	exercicio1
	static int [] criarVetorOrdenado(int nElementos) {

		int vect[]= new int [nElementos];

		for(int i = 0; i<vect.length; i++)
			vect[i] = i;
		
		return vect;
	}

	//	exercicio2
	static void imprimirVetor(int vect[]) {
		for(int i = 0; i < vect.length && i<=20; i++) 
			System.out.printf("v[%d]=%d\n", i, vect[i]);
		
		if(vect.length>20)
			System.out.println("...");
	}

	//	exercicio3
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

	//	exercicio4
	static int determinarSoma(int[] vect) {
		int soma=0;
		for(int i=1; i<vect.length;i++) {
			soma+=vect[i];
		}
		return soma;
	}
	
	static int determinarMinimo(int[] vect) {
		int min = vect[0];
		for(int i=0; i< vect[20]; i++) {
			if(vect[i]<min)
				min = vect[i];
		}
		return min;
	}

	static int determinarMaximo(int[] vect) {
		int max = vect[0];
		for(int i=0; i < vect[20]; i++) {
			if(vect[i]>max)
				max = vect[i];
		}
		return max;
	}

	//	exercicio5
	static int procuraLinear(int vect[], int x) {
		int i = 0;
		while(i<vect.length && vect[i] != x)
			i++;

		if(i>= vect.length)
			return -1;
		return i;
	}

	//	exercicio6
	static int procuraBinaria(int []vect, int x) {
		boolean encontrou = false;
		int esq = 0, dir = vect.length-1, meio = 0;

		while(esq <= dir && !encontrou) {
			meio =(esq + dir)/2;
			if(vect[meio]==x)
				encontrou = true;
			else if (vect[meio]<x)
				esq = meio+1;
			else
				dir = meio-1;
		}

		if(!encontrou)
			return -1;
		return meio;
	}

	//	exercicio7
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

	//	exercicio8
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

	//	exercicio9
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
	
	// exercicio extra 1
	static void shellSort(int v[]) {
		int n= v.length;
		for( int h = n/ 2; h >0; h = h/2 ) {
			for( int i = h; i < n; i++ ) {
				int x = v[ i ];
				int j = i;
				while( j >=h && v[ j-h ] > x ){
					v[ j ] = v[ j-h ];
					j -= h;
				}
				v[ j ] = x;
			}
		}
	}
	
	// exercicio extra 2
	static void ordenaShellMelhor(int v[]) {
		int h;
		// primeiro calcular o maior incremento (h) possível
		for( h = 1; h < v.length; h = 3*h + 1);
		do{
			h /= 3; // actualizar o h para esta iteração
			for( int i = h; i < v.length; i+= h ) {
				int x = v[ i ];
				int j = i;
				while( j > 0 && v[ j-h ] > x ){
					v[ j ] = v[ j-h ];
					j -= h;
				}
				v[ j ] = x;
			}
		} while( h > 1 );
	}

	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		
		int [] teste = criarVetorOrdenado(20);
//		imprimirVetor(teste);

		int [] embaralhado = embaralharVetor(teste, 50);
		imprimirVetor(embaralhado);

//		Ex 4
//		System.out.println("O minimo do vetor é " + determinarMinimo(embaralhado));
//		System.out.println("O maximo do vetor é " + determinarMaximo(embaralhado));
//		System.out.println("Soma: " + determinarSoma(embaralhado));
		
//		System.out.println("Que número pretende procurar? ");
//		int num = read.nextInt();
		
//		PROCURA LINEAR - Ex 5
//		int res = procuraLinear(embaralhado, num);
//		if(res != -1)
//			System.out.println("O valor existe no vetor, na posicao " + res);
//		else
//			System.out.println("O valor não existe!");
		
//		PROCURA BINÁRIA - Ex 6
//		int res1 = procuraBinaria(embaralhado, num);
//		if(res1 != -1)
//			System.out.println("O valor existe no vetor, na posicao " + res1);
//		else
//			System.out.println("O valor não existe!");
		
//		ORDENAR POR SELECAO - Ex 7
//		ordenaSeleccao(embaralhado);
//		System.out.println("\nVETOR ORDENADO:");
//		imprimirVetor(embaralhado);
		
//		ORDENAR POR INSERECAO - Ex 8
//		ordenaInsercao(embaralhado);
//		System.out.println("\nVETOR ORDENADO:");
//		imprimirVetor(embaralhado);
		
//		ORDENAR POR PERMUTACAO - Ex 9
//		ordenaPermutacao(embaralhado);
//		System.out.println("\nVETOR ORDENADO:");
//		imprimirVetor(embaralhado);
		
//		ORDENAÇÃO SHELLSORT versao 1
		shellSort(embaralhado);
		System.out.println("\nVETOR ORDENADO:");
		imprimirVetor(embaralhado);
		
//		ORDENAÇÃO SHELLSORT versao 2
//		ordenaShellMelhor(embaralhado);
//		System.out.println("\nVETOR ORDENADO:");
//		imprimirVetor(embaralhado);
		
		read.close();
	}
}

