

public class Klondike {
	
	private Baraja baraja;
	private Descarte descarte;
	private Palo[] palos;
	private Columna[] columnas;
	private static final int NUM_COLUMNAS=7;
	
	private Klondike() {
		baraja=new Baraja();
		descarte=new Descarte();
		palos=new Palo[Baraja.NUM_PALOS];
		for (int i = 0; i < palos.length; i++) {
			palos[i]=new Palo();
		}
		columnas=new Columna[NUM_COLUMNAS];
		for (int i = 0; i < columnas.length; i++) {
			columnas[i]=new Columna(i+1,baraja);
		}
	}
	
	private void jugar() {
		GestorIO gestorIO=new GestorIO();
		Menu menu=new Menu();
		int opcion;
		do {
			this.mostrar();
			menu.mostrar();
			opcion=menu.getOpcion();
			switch (opcion) {
			case 1: 
				baraja.moverA(descarte);
				break;
			case 2: 
				descarte.moverA(this.recogerPalo("A"));
				break;
			case 3: 
				descarte.moverA(columnas);
				break;
			case 4: 
				gestorIO.out("De cual palo? [1-4]: ");
				Palo palo= palos[gestorIO.inInt()-1];
				gestorIO.out("A cual columna? [1-7]: ");
				Columna columna= columnas[gestorIO.inInt()-1];
				palo.moverA(columna);
				break;
			case 5: 
				break;
			case 6: 
				break;
			case 7: 
				break;
			case 8: 
				break;
			}
		}while (opcion!=9);
	}
	
	private Palo recogerPalo(String prefijo) {
		GestorIO gestorIO=new GestorIO();
		int palo;
		boolean error;
		do {
			gestorIO.out("¿"+prefijo+" que palo? [1-"+Baraja.NUM_PALOS+"]: ");
			palo=gestorIO.inInt();
			error=new Intervalo(1, Baraja.NUM_PALOS).incluye(palo);
			if (error) {
				gestorIO.out("Error!!! Debe ser un nnúmero entre 1 y "+Baraja.NUM_PALOS);
			}
		}while (error);
		return palos[palo-1];
	}

	private void mostrar() {
		baraja.mostrar();
		descarte.mostrar();
		for (int i = 0; i < palos.length; i++) {
			palos[i].mostrar();
		}
		//columnas=new Columna[NUM_COLUMNAS];
		for (int i = 0; i < columnas.length; i++) {
			columnas[i].mostrar();
		}
	}

	public static void main(String[] args) {
		new Klondike().jugar();
	}
}
