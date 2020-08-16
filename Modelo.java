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
		if(controlador.recibirSimb(x, y).equals("X") || controlador.recibirSimb(x, y).equals("O")) {
			;
		} else {
			if(turno%2==0){
				controlador.enviarCaracter(x, y, 'X');
			} else {
				controlador.enviarCaracter(x, y, 'O');
			}
			turno++;
		}
		hayGanador();
	}
	
	public boolean tableroLleno() {
		boolean lleno = true;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if(controlador.recibirSimb(i, j)==" ") {
					lleno=false;
				}
			}
		}
		return lleno;
	}
	
	public void hayGanador() {
		// Empate
		if(tableroLleno()) {
			controlador.empate();
		}
		
		// Revisar filas 

		for (int i = 0; i < matriz.length; i++) {
			if(controlador.recibirSimb(i, 0).equals("X")
			   && controlador.recibirSimb(i, 1).equals("X")
			   && controlador.recibirSimb(i, 2).equals("X")) {
				System.out.println("ganaUno");
				controlador.ganaUno();
			} else if(controlador.recibirSimb(i, 0).equals("O")
					   && controlador.recibirSimb(i, 1).equals("O")
					   && controlador.recibirSimb(i, 2).equals("O")) {
						controlador.ganaDos();
			}
		}
		
		// Revisar columnas 
		for (int j = 0; j < matriz.length; j++) {
			if(controlador.recibirSimb(0, j).equals("X")
			   && controlador.recibirSimb(1, j).equals("X")
			   && controlador.recibirSimb(2, j).equals("X")) {
				controlador.ganaUno();
			} else if(controlador.recibirSimb(0, j).equals("O")
			   && controlador.recibirSimb(1, j).equals("O")
			   && controlador.recibirSimb(2, j).equals("O")) {
						controlador.ganaDos();
			}
		}
		
		//Revisar diagonales
		if(controlador.recibirSimb(0, 0).equals("X") 
			&& controlador.recibirSimb(1, 1).equals("X")
			&& controlador.recibirSimb(2, 2).equals("X")) {
			controlador.ganaUno();
		} else if(controlador.recibirSimb(0, 2).equals("X") 
				&& controlador.recibirSimb(1, 1).equals("X")
				&& controlador.recibirSimb(2, 0).equals("X")) {
			controlador.ganaUno();
		} else if(controlador.recibirSimb(0, 0).equals("O")
			&& controlador.recibirSimb(1, 1).equals("O")
			&& controlador.recibirSimb(2, 2).equals("O")) {
			controlador.ganaDos();
		} else if(controlador.recibirSimb(0, 2).equals("O") 
				&& controlador.recibirSimb(1, 1).equals("O")
				&& controlador.recibirSimb(2, 0).equals("O")) {
			controlador.ganaDos();
		}

		
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
