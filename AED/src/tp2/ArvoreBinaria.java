//package tp2;
//
//public class ArvoreBinaria {
//
//	private No raiz; // raiz da árvore
//	private int nElems; // nº de elementos da árvore
//
//	public ArvoreBinaria( ) {
//		nElems = 0;
//		raiz = null;
//	}
//
//	private class No {
//		int chave; // elemento opcional
//		Object oItem;
//		int oElemento;
//		No esq;
//		No dir;
//		No pai;
//
//		//		No( int chv, Object novo ) {
//		//			esq = null;
//		//			dir = null;
//		//			pai = null;
//		//			chave = chv;
//		//			oItem = novo;
//		//		}
//
//		No(int novo){
//			esq = null;
//			dir = null;
//			pai = null;
//			oElemento = novo;
//		}
//	}
//
//	public void inserir( int novo ) {
//		No novoNo = new No( novo );
//		No anterior = null;
//		No actual = raiz;
//
//		while( actual != null ) {
//			anterior = actual;
//			if( novo > actual.oElemento )
//				actual = actual.dir;
//			else
//				actual = actual.esq;
//		}
//		if( raiz == null )
//			raiz = novoNo;
//		else if( novo > anterior.oElemento )
//			anterior.dir = novoNo;
//		else
//			anterior.esq = novoNo;
//		novoNo.pai = anterior;
//		nElems++;
//	}
//
//	public boolean procura( int x ) {
//		No actual = raiz;
//
//		while( actual != null && actual.oElemento != x ){
//			if( x > actual.oElemento )
//				actual = actual.dir;
//			else
//				actual = actual.esq;
//		}
//		return actual != null;
//	}
//
//	public No procuraNo (int x) {
//		No actual = raiz;
//		if(procura(x)) {
//			if( x > actual.oElemento )
//				actual = actual.dir;
//			else
//				actual = actual.esq;
//		}
//		return actual;		
//	}
//
//	public int menor(  ) {
//		No actual = raiz;
//		if( raiz == null )
//			return 0;
//		while( actual.esq != null )
//			actual = actual.esq;
//		return actual.oElemento;
//	}
//
//	public int maior( ){
//		No actual = raiz;
//		if( raiz == null )
//			return 0;
//		while( actual.dir != null )
//			actual = actual.dir;
//		return actual.oElemento;
//	}
//
//	public int sucessor( int valor ) {
//		No pos = procuraNo( valor );
//		return sucessor( pos );
//	}     
//
//	private int sucessor( No pos ) {
//		if( pos.dir != null )
//			return menor( pos.dir );
//		No actual = pos;
//		No ancestral = actual.pai;
//		while( ancestral != null && ancestral.dir == actual ) {
//			actual = ancestral;
//			ancestral = ancestral.pai;
//		}
//		return ancestral.oElemento;
//	}
//
//	public int predecessor( int valor ) {
//		No pos = procuraNo( valor );
//		return predecessor( pos );
//	}
//
//	public int predecessor( No pos ) {
//		if( pos.esq != null )
//			return maior( pos.esq );
//		No actual = pos;
//		No ancestral = actual.pai;
//		while( ancestral != null && ancestral.esq == actual ) {
//			actual = ancestral;
//			ancestral = ancestral.pai;
//		}
//		return ancestral.oElemento;
//	}
//
//	public void eliminar( int x ){
//		No actual, aApagar, filho, pai ;
//		actual = procuraNo( x );
//		// descobrir qual o que se apaga: o actual ou o seu sucessor?
//		if( actual.esq == null || actual.dir == null ) 
//			aApagar = actual;
//		else 
//			aApagar = sucessor( actual );
//
//		if( aApagar.esq != null ) 
//			filho = aApagar.esq;
//		else 
//			filho = aApagar.dir;
//		pai = aApagar.pai;
//
//		if( filho != null ) 
//			filho.pai = pai;
//		if( pai == null ) 
//			raiz = filho;
//		else if( pai.esq == aApagar ) 
//			pai.esq = filho;
//		else pai.dir = filho;
//		if( aApagar != actual )
//			actual.oElemento = aApagar.oElemento; // copiar também a chave se houver
//		nElems--;
//	}
//
//	public void limpar( ) {
//		limparRec( raiz );
//	}
//
//	private void limparRec( No no ) {
//		if( no == null )
//			return;
//		limparRec( no.esq );
//		limparRec( no.dir );
//		no = null;
//	}
//
//	public void listarOrdem( ){
//		listarOrdem( raiz );
//	}
//
//	private void listarOrdem( No no ){
//		if( no == null )
//			return;
//		listarOrdem( no.esq );
//		System.out.println( no.oElemento );
//		listarOrdem( no.dir );
//	}
//
//	public void listarOrdemIterativa( ){
//		if( raiz == null )
//			return;
//		No proximo = menor( );
//		while( proximo != null ){
//			System.out.println( proximo.oElemento );
//			proximo = sucessor( proximo );
//		}
//	}
//
//	private void listarPreOrdem( No no ){
//		if( no == null )
//			return;
//		System.out.println( no.oElemento );
//		listarPreOrdem( no.esq );
//		listarPreOrdem( no.dir );
//	}
//	private void listarPosOrdem( No no ){
//		if( no == null )
//			return;
//		listarPosOrdem( no.esq );
//		listarPosOrdem( no.dir );
//		System.out.println( no.oElemento );
//	}
//}
