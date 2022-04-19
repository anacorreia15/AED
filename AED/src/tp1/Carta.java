package tp1;
/*
*	CONV�M PERCEBEREM BEM ESTA CLASSE MAS 
*	N�O � NECESS�RIO NEM PERMITIDO APAGAR,
*	ACRESCENTAR OU ALTERAR C�DIGO AQUI
*
*/
public class Carta implements Cloneable{
	//-----------------------------------------------------------------------------	
	public final static int AZ=1;
	public final static int DAMA=11;
	public final static int VALETE=12;
	public final static int REI=13;
	public final static int COPAS=0;
	public final static int ESPADAS=1;
	public final static int OUROS=2;
	public final static int PAUS=3;
	//-----------------------------------------------------------------------------		
	private int face;
	private int naipe;
	//-----------------------------------------------------------------------------		
	public Carta(){
		face=1;
		naipe=0;
	}
	//-----------------------------------------------------------------------------		
	public Carta(int fac, int nai){
		setFace(fac);
		setNaipe(nai);
	}
	//-----------------------------------------------------------------------------
	public void setFace(int fac){
		fac=fac<AZ?AZ:fac;
		fac=fac>REI?REI:fac;
		face=fac;	
	}
	//-----------------------------------------------------------------------------
	public int getFace(){
		return face;
	}
	//-----------------------------------------------------------------------------
	public void setNaipe(int nai){
		nai=nai<COPAS?COPAS:nai;
		nai=nai>PAUS?PAUS:nai;
		naipe=nai;	
	}
	//-----------------------------------------------------------------------------
	public int getNaipe(){
		return naipe;
	}
	//-----------------------------------------------------------------------------	
	public String toString(){
		String faceStr[]={"","Az","2","3","4","5","6","7","8","9","10",
							"Dama","Valete","Rei"};
		String naipeStr[]={"Copas","Espadas","Ouros","Paus"};
		return faceStr[face]+" de "+naipeStr[naipe];				
	}
	//-----------------------------------------------------------------------------
	public int verValorOrdem(){
		//o valor de ordem atribui um valor sequencial a cada carta
		//calculado com o naipe e a face
		//assim as cartas podem ser ordenadas de AZ a REI
		//e por naipes de COPAS a PAUS
		return naipe*13+face;	
	}
	//-----------------------------------------------------------------------------
	public int compareTo(Carta that){
		//retorna 0 se as cartas forem iguais,
		//um valor maior que zero se o objeto que invoca o método
		//tiver um valor de ordem superior
		//e menor que zero se o valor de ordem for inferior
		return this.verValorOrdem()-that.verValorOrdem();	
	}
	//-----------------------------------------------------------------------------
	public Carta clone() {
		return new Carta(face,naipe);		
	}
	//-----------------------------------------------------------------------------
}