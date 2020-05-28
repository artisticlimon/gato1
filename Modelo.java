// Marianne Peña Wust

package gato;

public class Modelo {
	char matriz[][];
	int turno; 
	Controlador controlador;
	
	public Modelo(Controlador c) {
	    controlador = c;
		matriz = new char[3][3];
		turno = 0;
		reiniciar();
		
	}

	//Llenar el tablero
	public void hacerJugada(int x, int y) {
		if(turno%2==0){
			controlador.enviarCaracter(x, y, 'X');
		} else {
			controlador.enviarCaracter(x, y, 'O');
		}
		turno++;
	}
	
	public boolean hayGanador() {
		boolean ganador = false;
		//revisar filas
		//for 
		
		//revisar columnas 
		//for 
		
		//revisar diagonales
		//manualmente
		
		return ganador;
	}
	
	public boolean tableroLleno() {
		boolean lleno = false;
		//doble for para recorrer
		return lleno;
	}

	public void reiniciar() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j]= ' '; 
			}
		turno= 0;
			
		}
	}
}
