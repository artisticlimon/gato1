package gato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AL implements ActionListener {
	Ventana ventana; 
	
	public AL(Ventana v) {
		ventana = v;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String ac= arg0.getActionCommand();
		switch(ac) {
			case "0,0":
				ventana.hacerJugada(0, 0);
				break;
			case "0,1":
				ventana.hacerJugada(0, 1);
				break;
			case "0,2":
				ventana.hacerJugada(0, 2);
				break;
			case "1,0":
				ventana.hacerJugada(1, 0);
				break;
			case "1,1":
				ventana.hacerJugada(1, 1);
				break;
			case "1,2":
				ventana.hacerJugada(1, 2);
				break;
			case "2,0":
				ventana.hacerJugada(2, 0);
				break;
			case "2,1":
				ventana.hacerJugada(2, 1);
				break;
			case "2,2":
				ventana.hacerJugada(2, 2);
				break;		
			case "reiniciar":
				ventana.reiniciar();
		}

		
	}

}
