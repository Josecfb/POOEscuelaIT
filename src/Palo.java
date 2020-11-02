class Palo extends Mazo{
	
	
	public Palo() {
		super(Baraja.NUM_NUMEROS,"Palo");
	}
	
	@Override
	public void mostrarContenido() {
		this.cima().mostrar();
	}

	public void moverA(Columna columna) {
		if (this.vacia()) {
			new GestorIO().out("Error!! No hay cartas en el palo");
		}else {
			Carta carta=this.sacar();
			if (columna.apilable(carta)) {
				columna.poner(carta);
			}else {
				this.poner(carta);
				new GestorIO().out("Error !!! no se puede realizar este movimiento");
			}
		}
	}

	public boolean apilable(Carta carta) {
		assert carta!=null;
		return this.vacia() && carta.esAs() ||
				!this.vacia() && carta.siguiente(this.cima()) && carta.igualPalo(this.cima());
	}

}
