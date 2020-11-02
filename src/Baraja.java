import java.util.Random;

public class Baraja extends Mazo{
	
	public static final int NUM_PALOS = 4;
	public static final int NUM_NUMEROS = 13;
	
	public Baraja() {
		super(NUM_PALOS*NUM_NUMEROS,"Baraja");
		for (int i = 0; i < NUM_PALOS; i++) {
			for (int j = 0; j < NUM_NUMEROS; j++) {
				this.poner(new Carta(i,j));
			}
		}
		this.barajar();
	}

	private void barajar() {
		Random aleatorio=new Random();
		for (int i=0;i<1000;i++) {
			int origen=aleatorio.nextInt(NUM_PALOS*NUM_NUMEROS);
			int destino=aleatorio.nextInt(NUM_PALOS*NUM_NUMEROS);
			Carta carta=cartas[origen];
			cartas[origen]=cartas[destino];
			cartas[destino]=carta;
		}
	}
	

	public void poner(Carta carta) {
		assert carta!=null;
		assert !carta.bocaArriba();
		assert !this.completa();
		cartas[ultima]=carta;
		ultima++;
	}

	
	@Override
	public void mostrarContenido() {
		this.cima().mostrar();
	}

	public void moverA(Descarte descarte) {
		if (this.vacia()) {
			new GestorIO().out("Error!!! No hay cartas en la baraja");
		}else {
			int contador=3;
			while (contador>0 && !this.vacia()) {
				Carta carta=this.sacar();
				carta.voltear();
				descarte.poner(carta);
				contador--;
			}
		}
	}

}
