// Marianne Peña Wust

package gato;

public class Controlador{
	Modelo modelo; 
	Ventana ventana;
	public Controlador() {
		modelo = new Modelo(this);
		ventana = new Ventana(this);	
	}
	 
	//Llenar el tablero
	public void hacerJugada(int x, int y) {
		modelo.hacerJugada(x, y);
	}
	
	public void enviarCaracter(int x, int y, char c) {
		ventana.cambiarCaracter(x, y, c);
	}
	
	//Reiniciar
	public void reiniciar() {
		modelo.reiniciar();
		ventana.redibujarMatriz();
	}
	
	public static void main(String[] args) {
		Controlador controlador = new Controlador();
	}
	
	// Ver ganador 
	public String recibirSimb(int x, int y) {
		String simbolo = ventana.mandarSimb(x, y);
		return simbolo;
	}
	
	public void ganaUno() {
		ventana.ganaUno();
		
	}
	
	public void ganaDos() {
		ventana.ganaDos();
		
	}

	public void empate() {
		ventana.empate();
		
	}

}
