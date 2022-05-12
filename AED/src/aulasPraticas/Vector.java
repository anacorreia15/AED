package aulasPraticas;
//ficha 4
public class Vector {

	 private int nElems, capMaxima, incremento;
	    private Object []buffer;

	    public Vector( ){
	        this( 1, 1 ); // capacidade inicial 1 e incremento 1
	    }
	    public Vector( int capInicial ) {
	        this( capInicial, capInicial/2 + 1);
	        // capacidade inicial e incremento metade da capacidade inicial
	    }

	    public Vector( int capInicial, int incre ) {
	        if( capInicial <= 0 )
	            capInicial = 1;
	        if( incre <= 0 )
	            incre = capInicial / 2 + 1;
	        nElems = 0;
	        buffer = new Object[ capInicial ];
	        capMaxima = capInicial;
	        incremento = incre;
	    }

	    public boolean estaCheio( ) { // indica se vector está cheio
	        return nElems == capMaxima;
	    }

	    public boolean estaVazio() {
	        return nElems == 0;
	    }

	    public void adicionar( Object x ) {
	        if( estaCheio() )
	            aumentar( );
	        buffer[ nElems ] = x;
	        nElems++;
	    }
	    private void aumentar( ) {
	        Object novoBuffer[] = new Object[ capMaxima + incremento ];
	        for( int i = 0; i < nElems; i++ )
	            novoBuffer[i] = buffer[i];
	        buffer = novoBuffer;
	        capMaxima += incremento;
	    }

	    public Object retirar( ) {
	       return  retirar(nElems-1);
	    }

	    Object retirar( int idx ) {
	        Object antigo = buffer[ idx ];
	        for( int i = idx + 1; i < nElems; i++)
	            buffer[i-1]=buffer[i];
	        nElems--;
	        return antigo;
	    }

	    void diminuir( ) {
	        if( nElems < capMaxima - incremento * 1.5){
	            Object [] novoBuffer = new Object[capMaxima-incremento];
	            for( int i=0; i < nElems; i++ )
	                novoBuffer[i] = buffer[ i ];
	            buffer = novoBuffer;
	            capMaxima -= incremento;
	        }
	    }

	    void inserir(Object x, int idx ) {
	        if( idx > nElems )
	            return;
	        if( estaCheio() )
	            aumentar( );
	        for( int i = nElems; i > idx; i-- )
	            buffer[ i ] = buffer[ i-1 ];
	        buffer[ idx ] = x;
	        nElems++;
	    }


	    public int procura( Object e, int posIni ){
	        for( int i = posIni; i < nElems; i++ )
	            if( buffer[ i ].equals( e ) )
	                return i;
	        return -1;
	    }
	    public int procura( Object e ) {
	        return procura( e, 0 );
	    }

	    public int procuraFim( Object e ) {
	        return procuraFim( e, nElems-1 );
	    }
	    public int procuraFim( Object e, int posFim ) {
	        for( int i = posFim; i >= 0; i-- )
	            if( buffer[ i ].equals( e ) )
	                return i;
	        return -1;
	    }

	    public boolean estaPresente( Object e ){
	        return procura( e ) != -1;
	    }

	    public int numRepeticoes( Object e ){
	        int nVezes = 0;
	        int proxIdx = procura( e );
	        while( proxIdx != -1 ) {
	            nVezes++;
	            proxIdx = procura( e, proxIdx + 1 );
	        }
	        return nVezes;
	    }

	    public void retirar( Object e ) {
	        int idx = procura( e );
	        if( idx != -1 )
	            retirar ( idx );
	    }
	    
	    public void retirarTodas( Object e ) {
	        int idx = procura( e );
	        while( idx != -1 ) {
	            retirar( idx );
	            idx = procura( e, idx );
	        }
	    }

	    public void limpar( ) {
	        nElems = 0;
	    }

	    private boolean indiceValido(int idx){
	        return idx >= 0 && idx < nElems;
	    }

	    public Object get( int idx ) {
	        if( !indiceValido(idx) )
	            throw new ArrayIndexOutOfBoundsException();
	        return buffer[ idx ];
	    }
	    public void set( int idx, Object e ){
	        if( !indiceValido(idx) )
	            throw new ArrayIndexOutOfBoundsException();
	        buffer[ idx ] = e;
	    }

	    public int getTamanho( ) { return nElems; }

	    public int getCapacidade( ) { return capMaxima; }

	    public int getEspacoLivre( ) { return getCapacidade() - getTamanho(); }

	    public void setIncremento( int novoInc ) {
	        incremento = novoInc <= 0? incremento: novoInc;
	    }

	    public void assegurarCapacidade( int capMinima ) {
	        while( capMaxima < capMinima )
	            aumentar();
	    }

	    public boolean setTamanho( int tamanho ) {
	    // se já tem mais elementos que o tamanho pedido
	    // não pode reduzir senão perde informação
	        if( tamanho < getTamanho() )
	            return false;
	        Object novoBuffer[] = new Object[ tamanho ];
	        for( int i = 0; i < nElems; i++ )
	            novoBuffer[ i ] = buffer[ i ];
	        buffer = novoBuffer;
	        capMaxima = tamanho;
	        return true;
	    }

	    public void ficarTamanhoActual( ) {
	        setTamanho( getTamanho( ) );
	    }

	    public int maiorElemento (){
	        int maior = 0;
	        for (int i = 0; i < buffer.length; i++) {
	            if((int)buffer[i] > maior){
	                maior = (int)buffer[i];
	            }
	        }
	        return maior;
	    }

	    public int menorElemento (){
	        int menor = 1000;
	        for (int i = 0; i < buffer.length; i++) {
	            if((int)buffer[i] < menor){
	                menor = (int)buffer[i];
	            }
	        }
	        return menor;
	    }
}
