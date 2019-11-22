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
		panelPersonajes.setLayout(new GridLayout(0, 1, 0, 0));
		panelIzq.add(panelPersonajes);
		panelIzq.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 7, Color.black));
		
		JButton btnPersonaje1 = new JButton(controller.GetIcon(1));
		btnPersonaje1.setBackground(Color.BLACK);
		btnPersonaje1.addActionListener(new btn1AL()); 
		panelPersonajes.add(btnPersonaje1);
		
		JButton btnPersonaje2 = new JButton(controller.GetIcon(2));
		btnPersonaje2.setBackground(Color.BLACK);
		btnPersonaje2.addActionListener(new btn2AL());
		panelPersonajes.add(btnPersonaje2);
		
		JButton btnPersonaje3 = new JButton(controller.GetIcon(3));
		btnPersonaje3.setBackground(Color.BLACK);
		btnPersonaje3.addActionListener(new btn3AL());
		panelPersonajes.add(btnPersonaje3);
		
		JButton btnPersonaje4 = new JButton(controller.GetIcon(4));
		btnPersonaje4.setBackground(Color.BLACK);
		btnPersonaje4.addActionListener(new btn4AL());
		panelPersonajes.add(btnPersonaje4);
		
		JButton btnPersonaje5 = new JButton(controller.GetIcon(5));
		btnPersonaje5.setBackground(Color.BLACK);
		btnPersonaje5.addActionListener(new btn5AL());
		panelPersonajes.add(btnPersonaje5);
		
		JButton btnPersonaje6 = new JButton("Vender");
		btnPersonaje6.addActionListener(new btn6AL());
		
		BackgroundPanel panelScore = new BackgroundPanel(transparent);
		panelScore.setBounds(0, 300, 170, 100);
		
		lblScore = new JLabel("Score: 0");
		lblScore.setBackground(Color.BLACK);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.WHITE);
		lblScore.setBounds(0, 0, 170, 40);
		panelScore.add(lblScore);
		
		JLabel lblGold = new JLabel("Gold: " + controller.GetCurrentMoney());
		lblGold.setBackground(Color.BLACK);
		lblGold.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGold.setForeground(Color.WHITE);
		lblGold.setHorizontalAlignment(SwingConstants.CENTER);
		lblGold.setBounds(0, 40, 170, 49);
		panelScore.add(lblGold);
		
		panelIzq.add(panelScore);
		
		BackgroundPanel panelPlay = new BackgroundPanel(transparent);
		panelPlay.setSize(170, 40);
		panelPlay.setLocation(0, 500);
		
		JPanel panelObjetos = new BackgroundPanel(transparent);
		panelObjetos.setBounds(0, 400, 170, 100);
		panelObjetos.setLayout(new GridLayout(3, 2, 0, 0));
		JButton btno1 = new JButton("caja");
		btno1.addActionListener(new btnObject1());
		panelObjetos.add(btno1);
		JButton btno2 = new JButton("shield");
		btno2.addActionListener(new btnObject2());
		panelObjetos.add(btno2);
		JButton btno3 = new JButton("squan");
		btno3.addActionListener(new btnObject3());
		panelObjetos.add(btno3);
		JButton btno4 = new JButton("moab");
		btno4.addActionListener(new btnObject4());
		panelObjetos.add(btno4);
		JButton btno5 = new JButton("cong");
		btno5.addActionListener(new btnObject5());
		panelObjetos.add(btno5);
		panelObjetos.add(btnPersonaje6);
		panelIzq.add(panelObjetos);
		
		
		btnPlay = new JButton("Play");
		btnPlay.setLocation(0, 0);
		btnPlay.setSize(170, 40);
		btnPlay.addActionListener(new btnPlayAL());
		panelPlay.add(btnPlay);
		panelIzq.add(panelPlay);
		
		
		panelMapa = new BackgroundPanel(image);
		panelMapa.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(!controller.Empty()) {
					controller.Invoke(e.getX(), e.getY());
					lblGold.setText("Gold: " + controller.GetCurrentMoney());
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
		
		for(int i = controller.Size() - 1; i >= 0 ; i--) {
			
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
			if(controller.CanPurchase(2)) {
				controller.Purchase(2);
			}
		}
	}

	/**
	 * Clase oyente del boton 4
	 *
	 */
	private class btn4AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(controller.CanPurchase(3)) {
				controller.Purchase(3);
			}
		}
	}
	
	/**
	 * Clase oyente del boton 5
	 *
	 */
	private class btn5AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		   if(controller.CanPurchase(4)) {
				controller.Purchase(4);
			}
		}
	}
	/**
	 * Clase oyente del boton 6
	 *
	 */
	private class btn6AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			controller.PurchasePowerUp(5);
			controller.sell();
		}
	}
	private class btnPlayAL implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			controller.ToggleRound();
			btnPlay.setEnabled(false);
			ActualizarGrafica();
		}
		
	}
	
	/**
	 * Muestra al jugador que gano
	 */
	public void ShowWin() {
		JOptionPane.showMessageDialog(new JFrame(), "Ganaste","Winner",JOptionPane.PLAIN_MESSAGE);
		btnPlay.setEnabled(true);
	}
	
	/**
	 * Muestra al jugador que perdio
	 */
	public void showLose() {
		JOptionPane.showMessageDialog(new JFrame(), "Perdiste la partida","Perdedor",JOptionPane.ERROR_MESSAGE);
		btnPlay.setEnabled(true);
	}
	
	private class btnObject1 implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(controller.CanPurchasePowerUp(0))
				controller.PurchasePowerUp(0);
		}
	}
	
	private class btnObject2 implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(controller.CanPurchasePowerUp(1))
				controller.PurchasePowerUp(1);
		}
	}
	
	private class btnObject3 implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(controller.CanPurchasePowerUp(2))
				controller.PurchasePowerUp(2);
		}
	}
	
	private class btnObject4 implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(controller.CanPurchasePowerUp(3))
				controller.PurchasePowerUp(3);
		}
	}
	
	private class btnObject5 implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(controller.CanPurchasePowerUp(4))
				controller.PurchasePowerUp(4);
		}
	}
}
