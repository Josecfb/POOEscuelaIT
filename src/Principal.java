

public class Principal {

	public static void main(String[] args) {
		Intervalo intervaloAntiguo=new Intervalo(1.0,5.0);
		intervaloAntiguo.mostrar();
		System.out.println(intervaloAntiguo.incluye(new Intervalo(2.0,3.0)));
		Fecha fecha=new Fecha("25/10/2020");
		new GestorIO().out(fecha.toString()+"\n");
		fecha.incrementar(365);
		System.out.println(fecha);
		System.out.println("Es bosoesto "+Fecha.bisiesto(2024));
	}

}
