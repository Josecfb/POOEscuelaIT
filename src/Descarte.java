

class Descarte {
	
	private Carta[] cartas;
	
	private int ultima;
	
	public Descarte() {
		ultima=0;
		cartas=new Carta[52-28];
	}

	public void mostrar() {
		GestorIO gestorIO=new GestorIO();
		gestorIO.out("\nDescarte:");
		if (this.vacia()) {
			gestorIO.out("<VACIA>");
		}else{
			int primeraVisible=ultima-3;
			if (primeraVisible<0) {
				primeraVisible=0;
			}
			for (int i=primeraVisible;i<ultima;i++) {
				cartas[i].mostrar();
			}
		}
	}

	private boolean vacia() {
		return ultima==0;
	}

	public void moverA(Palo palo) {
		
	}

	public void moverA(Columna columna) {
		// TODO Auto-generated method stub
		
	}

	public void voltear(Baraja baraja) {
		// TODO Auto-generated method stub
		
	}

	public void poner(Carta carta) {
		// TODO Auto-generated method stub
		
	}

}
