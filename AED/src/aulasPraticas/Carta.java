package aulasPraticas;

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
		setFace(1+((int)(Math.random()*13.0)));
		setNaipe((int)(Math.random()*4.0));
	}
	//-----------------------------------------------------------------------------		
	public Carta(int fac, int nai){
		setFace(fac);
		setNaipe(nai);
	}
	//-----------------------------------------------------------------------------		
	public Carta(int ord){
		ord=ord<1?1:ord;
		ord=ord>52?52:ord;
		setFace(ord%13);
		setNaipe(ord/13);
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
		return naipe*13+face;	
	}
	//-----------------------------------------------------------------------------
	public int compareTo(Carta that){
		return this.verValorOrdem()-that.verValorOrdem();	
	}
	//-----------------------------------------------------------------------------
	public Carta clone() {
		return new Carta(face,naipe);		
	}
	//-----------------------------------------------------------------------------
}

