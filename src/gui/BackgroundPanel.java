package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BackgroundPanel extends JPanel {

	private Image img;

	public BackgroundPanel(String img) {
		this(new ImageIcon(img).getImage());
	}

	public BackgroundPanel(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	
	public void paintComponent(Graphics g) {
	  	g.drawImage(img, 0, 0, null);
	}	

}
