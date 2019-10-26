package gui;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import gameObjects.GameObject;
import logicas.Controller;
import logicas.Pair;

import java.awt.Color;
import java.awt.Font;

public class Gui {

	private JFrame frame;
	private BackgroundPanel panelMapa, panelGeneral;
	private Controller controller;
	private JLabel lblScore;
	private ArrayList<JLabel> objetos;
	JButton btnPlay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Gui window = new Gui();
		
		window.frame.setVisible(true);
	}
	

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		controller = Controller.GetInstance(this);
		objetos = new ArrayList<JLabel>();
		
		Image bg = new ImageIcon(this.getClass().getResource("/img/BG.png")).getImage();
		panelGeneral = new BackgroundPanel(bg);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 975, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panelGeneral);
		frame.getContentPane().setLayout(null);
		
		Image transparent = new ImageIcon(this.getClass().getResource("/img/transparent.png")).getImage();
		Image image = new ImageIcon(this.getClass().getResource("/img/Map.png")).getImage();
		
		BackgroundPanel panelIzq = new BackgroundPanel(transparent);
		panelIzq.setBounds(0, 0, 180, 540);
		panelGeneral.add(panelIzq);
		panelIzq.setLayout(null);
		
		BackgroundPanel panelPersonajes = new BackgroundPanel(transparent);
		panelPersonajes.setBounds(0, 0, 170, 300);
		panelIzq.add(panelPersonajes);
		panelIzq.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 7, Color.black));
		
		JButton btnPersonaje1 = new JButton("Seleccionar aliado");
		btnPersonaje1.addActionListener(new btn1AL()); 
		panelPersonajes.setLayout(new GridLayout(0, 1, 0, 0));
		panelPersonajes.add(btnPersonaje1);
		
		JButton btnPersonaje2 = new JButton("Spawnear enemigo");
		btnPersonaje2.addActionListener(new btn2AL());
		panelPersonajes.add(btnPersonaje2);
		
		JButton btnPersonaje3 = new JButton("Eliminar enemigo");
		btnPersonaje3.addActionListener(new btn3AL());
		panelPersonajes.add(btnPersonaje3);
		
		JButton btnPersonaje4 = new JButton("4");
		btnPersonaje4.addActionListener(new btn4AL());
		panelPersonajes.add(btnPersonaje4);
		
		JButton btnPersonaje5 = new JButton("5");
		btnPersonaje5.addActionListener(new btn5AL());
		panelPersonajes.add(btnPersonaje5);
		
		
		BackgroundPanel panelScore = new BackgroundPanel(transparent);
		panelScore.setBounds(0, 300, 170, 200);
		
		lblScore = new JLabel("Score: 0");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.WHITE);
		lblScore.setBounds(0, 0, 170, 40);
		panelScore.add(lblScore);		
		JLabel lblGold = new JLabel("Gold: 4400");
		lblGold.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGold.setForeground(Color.WHITE);
		lblGold.setHorizontalAlignment(SwingConstants.CENTER);
		lblGold.setBounds(0, 40, 170, 40);
		panelScore.add(lblGold);
		
		panelIzq.add(panelScore);
		
		BackgroundPanel panelPlay = new BackgroundPanel(transparent);
		panelPlay.setSize(170, 30);
		panelPlay.setLocation(0, 500);
		panelScore.setBounds(0, 300, 170, 200);
		btnPlay = new JButton("Play");
		btnPlay.setLocation(0, 0);
		btnPlay.setSize(170, 30);
		btnPlay.addActionListener(new btnPlayAL());
		panelPlay.add(btnPlay);
		panelIzq.add(panelPlay);
		
		
		panelMapa = new BackgroundPanel(image);
		panelMapa.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(!controller.Empty()) {
					controller.InvokeAlly(e.getX(), e.getY());
					ActualizarGrafica();
				}
			}
		});
		
		panelMapa.setBounds(180, 0, 780, 540);
		panelMapa.setLayout(null);
		controller.SetMapWidth(panelMapa.getWidth());
		frame.getContentPane().add(panelMapa);
		
		
	}
	
	/**
	 * Actualiza la grafica
	 */
	public void ActualizarGrafica() {
		
		try {
			panelMapa.removeAll();
			JLabel jl;
		
		for(int i = 0; i < controller.Size(); i++) {
			
			Pair<ImageIcon, Rectangle> p = controller.GetSpriteAndHitbox(i);
			jl = new JLabel(p.getX());
			jl.setBounds(p.getY());
			panelMapa.add(jl);
		}
		
		controller.ControlBounds();
		panelMapa.repaint();
		} catch ( NullPointerException | ArrayIndexOutOfBoundsException e ) {
			//Esto esta porque el hilo arranca antes que el resto de cosas
			System.out.println("GUI::"+ e.getMessage());
		}
		
	}
	
	/**
	 * Inserta un objeto a la grafica
	 * @param img sprite del objeto a insertar
	 */
	public void Insertar(ImageIcon img) {
		JLabel jl = new JLabel(img);		
		objetos.add( jl );
		ActualizarGrafica();
	}
	
	/**
	 * Clase oyente del boton 1
	 *
	 */
	private class btn1AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(controller.CanPurchase(0)) {
				controller.Purchase(0);
			}
		}
	}
	
	/**
	 * Clase oyente del boton 2
	 *
	 */
	private class btn2AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			//PlaceHolder para el verdadero oyente
			if(controller.CanPurchase(1)) {
				controller.Purchase(1);
			}
		}
	}
	
	/**
	 * Clase oyente del boton 3
	 *
	 */
	private class btn3AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			// PlaceHolder para el verdadero oyente
			   if(controller.CanPurchase(2)) {
					controller.Purchase(2);
				}
			 
			
			//nivel.Eliminar(ObjetoDelJuego o);
			// nivel.EliminarTodosLosEnemigos();
			panelMapa.repaint();
		}
	}

	/**
	 * Clase oyente del boton 4
	 *
	 */
	private class btn4AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// PlaceHolder para el verdadero oyente
			   if(controller.CanPurchase(3)) {
					controller.Purchase(3);
				}
			   panelMapa.repaint();
		}
	}
	
	/**
	 * Clase oyente del boton 5
	 *
	 */
	private class btn5AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// PlaceHolder para el verdadero oyente
			   if(controller.CanPurchase(4)) {
					controller.Purchase(4);
				}
			 
			   panelMapa.repaint();
		}
	}
	
	private class btnPlayAL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			controller.ToggleRound();
			btnPlay.setEnabled(false);
			ActualizarGrafica();
		}
		
	}

	public void showLose() {
		JOptionPane.showMessageDialog(new JFrame(), "Perdiste la partida","Perdedor",JOptionPane.ERROR_MESSAGE);
		btnPlay.setEnabled(true);
	}
}
