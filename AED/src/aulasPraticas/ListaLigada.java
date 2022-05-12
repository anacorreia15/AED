package aulasPraticas;

public class ListaLigada {
	
	private int nElementos;
	private No cabeca;

	private class No {
		No prox;
		String item;

		public No( String s ) {
			item = s; // o item passa a ser o elemento
			prox = null; // o nó é inicializado com
			// prox a null (não há próximo)
		}
	}

	public ListaLigada( ){
		cabeca = null;
		nElementos = 0;
	}

	public boolean eIndiceValido (int idx) {
		return idx >= 0 && idx < nElementos;
	}

	public void inserirOrdem( String s ) {
		No novoNo = new No( s );
		No actual = cabeca;
		No anterior = null;
		// procurar o local onde inserir
		while( actual != null && actual.item.compareTo( s ) < 0 ) {
			anterior = actual;
			actual = actual.prox;
		}
		novoNo.prox = actual;
		if( anterior == null )
			cabeca = novoNo;
		else
			anterior.prox = novoNo;
		nElementos++;
	}

	public int procurar( String s ) {
		No actual = cabeca;
		int pos = 0;
		while( actual != null && actual.item.compareTo( s ) < 0 ) {
			actual = actual.prox;
			pos++;
		}
		if( actual != null && actual.item.equals( s ) )
				return pos;
		return -1;
	}
	
	
	
}
