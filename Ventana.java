// Marianne Peña Wust

package gato;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	
	Controlador controlador;
	JButton[][] matriz;
	JButton btnReiniciar;
	JLabel lblGanador;
	JTextField txtGanador;
	
	public Ventana(Controlador c) {
		controlador = c;
	
	//Inicializar ventana
		this.setTitle("Gato de Marianne Peña Wust");
		setBounds(10, 10, 500, 500);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
	// Label de quién es el ganador
		lblGanador = new JLabel("El ganador es");
		lblGanador.setBounds(50, 260, 150, 30);
		add(lblGanador);
		
	// Anuncio del ganador 
		txtGanador = new JTextField(" ");
		txtGanador.setBounds(50, 300, 150, 30);
		add(txtGanador);
		
		setVisible(true);
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
		txtGanador.setText(" ");
	}
	
	// Anunciar ganador o empate
	public String mandarSimb(int x, int y) {
		String simbolo = matriz[x][y].getText();		
		return simbolo;
	}
	
	public void ganaUno() {
		txtGanador.setText("Jugador 1");
	}
	
	public void ganaDos() {
		txtGanador.setText("Jugador 2");
	}
	
	public void empate() {
		txtGanador.setText("Empate");
	}

}
