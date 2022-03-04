package brickBracker;

import java.io.IOException;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class Main extends JFrame{
	private static final long serialVersionUID = 8186731400141124813L;
	private Gameplay gamePlay;
	private BufferedImage img;
	private static Main game;

	public Main() {
		importImag();
		
		gamePlay = new Gameplay(img); // attribuisce ad una variabile la classe Gameplay
		setBounds(10, 10, 710, 600);	// set Bounds serve per dimensionare la finestra
		setTitle("Breakout Ball");	//serve per dare il nome alla finestra
		setResizable(false);	// se false impedisce di modificare la grandezza della finestra
		setVisible(true);	// permette di vedere la finestra
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// permette di chiudere la finestra quando si schiaccia sull X
		add(gamePlay); 	// aggiunge alla finestra la classe Gameplay passando la variabile a cui avevamo attribuito la classe Gameplay
	}
	
	private void importImag() {
		InputStream is = getClass().getResourceAsStream("ball.png");
		try {
			img = ImageIO.read(is);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		
		setGame(new Main());
		
	}

	public static Main getGame() {
		return game;
	}

	public static void setGame(Main game) {
		Main.game = game;
	}

}

