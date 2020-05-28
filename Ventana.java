// Marianne Peña Wust

package gato;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	Controlador controlador;
	JButton[][] matriz;
	JButton btnReiniciar;
	
	public Ventana(Controlador c) {
		controlador = c;
	
	//Inicializar ventana
		setBounds(10, 10, 500, 500);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	AL al = new AL(this);
	
	// Matriz de botones
	matriz= new JButton[3][3];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j]= new JButton(" ");
				matriz[i][j].setBounds(j*50+50, i*50+50, 50, 50);
				matriz[i][j].setActionCommand(i+","+j);
				matriz[i][j].addActionListener(al);
				add(matriz[i][j]);
			}
		}
		
	// Boton de reiniciar
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBounds(260, 50, 100, 50);
		btnReiniciar.setActionCommand("reiniciar");
		btnReiniciar.addActionListener(al);
		add(btnReiniciar);
		
	}

	public void anunciarGanador() {
		//en algun lbl poner el "ganador es el jugador n"
		
	}
	
	//Llenar el tablero
	public void hacerJugada(int x, int y) {
		controlador.hacerJugada(x, y);
	}

	public void cambiarCaracter(int x, int y, char c) {
		matriz[x][y].setText(Character.toString(c));
		
	}
	
	//Reiniciar
	public void reiniciar() {
		controlador.reiniciar();
		
	}
	
	public void redibujarMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j].setText(" ");
			}
		}
	}

}
