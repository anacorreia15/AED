package tp1;

public class ExPreparacao {

	public static void main(String[] args) {
		Carta baralho[]=criarBaralho();
//		Carta j1[]=new Carta[10]; //mao de cada jogador
//		Carta j2[]=new Carta[10];
//		Carta j3[]=new Carta[10];
//		Carta j4[]=new Carta[10];
		
		System.out.println("###### BARALHO COMPLETO####");
		imprimirCartas(baralho);

		System.out.println("###### BARALHO COM CARACTERES####");
		imprimirCaracteres(baralho);
	}

	public static Carta[] criarBaralho(){
		Carta bar[]=new Carta[52];
		int i=0;
		for(int n=Carta.COPAS;n<=Carta.PAUS;n++)
			for(int f=Carta.AZ;f<=Carta.REI;f++){
				bar[i]=new Carta(f,n);
				i++;
			}
		return bar;
	}
	//-----------------------------------------------------------------------------		
	public static void imprimirCartas(Carta car[]){
		for(int i=0;i<car.length;i++)
			System.out.println(car[i]);
	}
	
	public static void imprimirCaracteres(Carta car[]){
		for(int i=0;i<car.length;i++)
			if(car[i].getNaipe()== Carta.COPAS)
				System.out.println(" # " + car[i]);
			else if(car[i].getNaipe()== Carta.ESPADAS)
				System.out.println(" $ " + car[i]);
			else if(car[i].getNaipe()== Carta.OUROS)
				System.out.println(" % " + car[i]);
			else if(car[i].getNaipe()== Carta.PAUS)
				System.out.println(" & " + car[i]);
			else
				System.out.println(car[i]);
	}
	
	public static void imprimirValorOrdem(Carta car[]) {
		
	}
}
