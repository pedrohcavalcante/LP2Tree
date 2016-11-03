package br.imd;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Screen extends JFrame {
	
	private MyCanvas canvas = new MyCanvas();
	
	int screenHeight = 800;
	int screenWidth = 800;
	
	public Screen() {
		
		
		
		
		setTitle("Vamo lá");
		setSize(screenWidth, screenHeight);
		setLayout(new BorderLayout());
		
		add("Center", canvas);
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class MyCanvas extends Canvas {
		
		@Override
		public void paint(Graphics g) {
			g.fillOval(10, 10, 40, 40);
		}
	}
	
}
