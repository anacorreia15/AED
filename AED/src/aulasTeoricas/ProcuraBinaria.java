package aulasTeoricas;

import java.util.Scanner;

public class ProcuraBinaria {
	
//	este metedo também pode ser int se quisermos saber a posicao
	static boolean procuraBinaria (int oVector[], int x) {
		boolean encontrou =  false;
		int esq = 0, dir = oVector.length-1, meio = 0;
		
		while(esq <= dir && !encontrou) {
			meio = (esq + dir) / 2;
			if(oVector[meio]==x)
				encontrou = true;
			else if (oVector[meio] < x)
				esq = meio+1;
			else
				dir = meio-1;
		}
		
		if(!encontrou)
			return false;
		return true;	
	}
	
//	fazer metedos que procuram a primeira ocorrencia de x e a ultima

	public static void main(String[] args) {
		
		Scanner input = new Scanner( System.in );
		int oVector[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		System.out.print("Número a procurar: ");
		int x = input.nextInt();
		
		System.out.println(procuraBinaria(oVector, x));
		
		input.close();
	}

}
