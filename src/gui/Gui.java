package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

import logicas.Controller;

import java.awt.Color;
import java.awt.Rectangle;

public class Gui {

	private JFrame frame;
	private JPanel panelMapa;
	private Controller controller;
	private JLabel lblScore;
	private ArrayList<JLabel> objetos;

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
		
		controller = new Controller(this);
		
		objetos = new ArrayList<JLabel>();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelPersonajes = new JPanel();
		panelPersonajes.setBounds(0, 0, 141, 318);
		frame.getContentPane().add(panelPersonajes);
		
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
		btnPersonaje3.addActionListener(new btn4AL());
		panelPersonajes.add(btnPersonaje4);
		
		JButton btnPersonaje5 = new JButton("5");
		btnPersonaje3.addActionListener(new btn5AL());
		panelPersonajes.add(btnPersonaje5);
		panelMapa = new JPanel();
		
		
		panelMapa.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(!controller.Empty()) {
					controller.InvokeAlly(e.getX(), e.getY());
				}
			}
		});
		
		
		
		panelMapa.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMapa.setBounds(192, 0, 692, 551);
		panelMapa.setLayout(null);
		
		JPanel panelScore = new JPanel();
		panelScore.setBounds(0, 338, 141, 213);
		frame.getContentPane().add(panelScore);
		frame.getContentPane().add(panelMapa);
		
		lblScore = new JLabel("Score: 0");
		panelScore.add(lblScore);
		
	}
	
	/**
	 * Actualiza la grafica
	 */
	public void ActualizarGrafica() {
		
		int i = 0;
		
		for(Rectangle hb : controller.GetHitboxes())
			objetos.get(i++).setBounds(hb);

		panelMapa.repaint();
	}
	
	/**
	 * Inserta un objeto a la grafica
	 * @param img sprite del objeto a insertar
	 */
	public void Insertar(ImageIcon img) {
		objetos.add( new JLabel(img) );
	}
	
	/**
	 * Clase oyente del boton 1
	 *
	 */
	private class btn1AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(controller.CanPurchase(1)) {
				controller.Purchase(1);
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
			
			/* PlaceHolder para el verdadero oyente
			   if(controller.CanPurchase(2)) {
					controller.Purchase(2);
				}
			 */
			
			JLabel jl = new JLabel();
			jl.setIcon(( controller.InvokeEnemy(0)));
			objetos.add( jl );
			ActualizarGrafica();
			
		}
	}
	
	/**
	 * Clase oyente del boton 3
	 *
	 */
	private class btn3AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			/* PlaceHolder para el verdadero oyente
			   if(controller.CanPurchase(3)) {
					controller.Purchase(3);
				}
			 */
			
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
			
			/* PlaceHolder para el verdadero oyente
			   if(controller.CanPurchase(4)) {
					controller.Purchase(4);
				}
			 */
			
		}
	}
	
	/**
	 * Clase oyente del boton 5
	 *
	 */
	private class btn5AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			/* PlaceHolder para el verdadero oyente
			   if(controller.CanPurchase(5)) {
					controller.Purchase(5);
				}
			 */
			
		}
	}
}
