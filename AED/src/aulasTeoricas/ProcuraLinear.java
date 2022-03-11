package aulasTeoricas;

import java.util.Scanner;

public class ProcuraLinear {

	static int procuraLinearPrimeiraPosicao(int oVector[], int x) {
		int i = 0;
		while(i < oVector.length && oVector[i] != x)
			i++;

		if(i >= oVector.length)
			return -1;

		return i;
	}

//	Fazer exercicio procura linear mas na ultima posicao
	static int procuraLinearUltimaPosicao(int oVector[], int x) {
		return -1;
	}
	
//	Fazer outra versão do algoritmo

	public static void main(String[] args) {

		Scanner input = new Scanner( System.in );
		int oVector[] = {10, 2, 8, 4, 2, 3, 6};

		System.out.print("Número a procurar:");
		int x = input.nextInt( );
	
//		int res = procuraLinearPrimeiraPosicao( oVector, x );
//		System.out.println("O Número "+ x + " está na posição " + res + " do vetor.");
//		
//		if( res == -1 )
//			System.out.println( x + " não foi encontrado!" );
//		else
//			System.out.println( x + " foi encontrado na posição " + res);
		
		int res1 = procuraLinearUltimaPosicao( oVector, x );
		System.out.println("O Número "+ x + " está na posição " + res1 + " do vetor.");

		input.close();
	}

}
