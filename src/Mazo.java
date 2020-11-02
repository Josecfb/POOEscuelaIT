
abstract class Mazo {
	
	protected Carta[] cartas;
	
	protected int ultima;
	
	protected String titulo;
	
	protected Mazo(int cantidad,String titulo) {
		ultima=0;
		cartas = new Carta[cantidad];
		this.titulo=titulo;
	}
	
	protected boolean vacia() {
		return ultima==0;
	}
	
	protected boolean completa() {
		return ultima==Baraja.NUM_NUMEROS*Baraja.NUM_PALOS;
	}
	
	protected Carta cima() {
		assert !this.vacia();
		return cartas[ultima-1];
	}
	
	protected Carta sacar() {
		assert !this.vacia();
		ultima--;
		return cartas[ultima];
	}
	
	protected void poner(Carta carta) {
		assert carta!=null;
		assert carta.bocaArriba();
		assert !this.completa();
		cartas[ultima]=carta;
		ultima++;
	}
	
	public void mostrar() {
		GestorIO gestorIO=new GestorIO();
		gestorIO.out("\n"+titulo);
		if (this.vacia()) {
			gestorIO.out("<VACIA>");
		}else {
			this.mostrarContenido();
		}
	}
	
	public abstract void mostrarContenido();

}