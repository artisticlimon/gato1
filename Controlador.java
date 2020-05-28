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
		if(modelo.hayGanador()) {
			ventana.anunciarGanador();
		} else {
			modelo.hacerJugada(x, y);
		}
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

}
