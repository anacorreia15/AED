package aulasPraticas;

public class Lista {
	private int nElementos;
	private No cabeca;

	private class No {
		No prox;
		Carta item;

		public No (Carta c) {
			item = c; //o item passa a ser ser o elemento
			prox = null; // o prox nó é inicializado a null
			// não  há proximo nó
		}
	}

	public Lista( ){
		cabeca = null;
		nElementos = 0;
	}

	public void inserirCabeca( Carta c ){
		No novoNo = new No( c );
		novoNo.prox = cabeca;
		cabeca = novoNo;
		nElementos++;
	}

	public void inserirCauda( Carta c ){
		No novoNo = new No( c );
		if( cabeca == null ) {
			cabeca = novoNo;
			nElementos++;
			return;
		}
		No ultimo = cabeca;
		while( ultimo.prox != null )
			ultimo = ultimo.prox;
		ultimo.prox = novoNo;
		nElementos++;
	}

	public boolean eIndiceValido (int idx) {
		return idx >= 0 && idx < nElementos;
	}

	public void inserirOrdem( Carta c ) {
		No novoNo = new No( c );
		No actual = cabeca;
		No anterior = null;
		// procurar o local onde inserir
		while( actual != null && actual.item.compareTo( c ) < 0 ) {
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

	public int procurar (Carta c) { //Procurar um elemento numa lista nao ordenada
		No actual = cabeca;
		int pos = 0;
		while( actual != null && actual.item.verValorOrdem()!= c.verValorOrdem() ) { //Se a comparacao com o valor ordem for 
			actual = actual.prox;													//diferente com a outra carta,
			pos++;																	// entao sao cartas diferentes															
		}
		return actual == null ? -1: pos;
	}

	public void retirar( int idx ){
		if( !eIndiceValido( idx ) )
			throw new ArrayIndexOutOfBoundsException( idx
					);
		No actual = cabeca;
		No anterior = null;
		int pos = 0;
		while( actual != null && pos < idx ) {
			anterior = actual;
			actual = actual.prox;
			pos++;
		}
		if( anterior != null )
			anterior.prox = actual.prox;
		else
			cabeca = actual.prox;
		nElementos--;
	}

	public int getnElementos() {
		return nElementos;
	}

	public Object get( int idx ) {
		if( !eIndiceValido( idx ) ) 
			throw new ArrayIndexOutOfBoundsException( idx );
		No actual = cabeca;
		int pos = 0;
		while( pos < idx ) {
			pos++;
			actual = actual.prox;
		}
		return actual.item;
	}
}
