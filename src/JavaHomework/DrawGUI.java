package JavaHomework;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

import javax.jws.WebParam.Mode;
import javax.swing.JFrame;

public class DrawGUI extends JFrame {
	public static void main(String[] args) {
		JFrame frame = new DrawGUI();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setTitle("javaª≠Õº");
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		// g.drawRect(x, y, width, height);
		g.drawRect(100, 100, 200, 100);
		//ª≠Õ÷‘≤
		g.setColor(Color.GREEN);
		g.drawOval(100, 100, 200, 100);
	}

}
