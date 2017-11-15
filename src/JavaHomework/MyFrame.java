package JavaHomework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.w3c.dom.css.Rect;

public class MyFrame extends JFrame {
	static int num;
	public static void main(String[] args) {
		JFrame frame = new MyFrame();
		frame.setTitle("画同心椭圆");
		try {
			num = Integer.parseInt(JOptionPane.showInputDialog("请输入画圆的个数"));
			System.out.println(num);
			frame.setSize(1000, 1000);
			frame.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "请输入正确的数字");
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.CYAN);
		int width = getWidth() / 2;
		int height = getHeight() / 4;
		int x =getWidth() / 4;;
		int y = getHeight() / 4;
		g.drawRect(x, y, width, height);
		for (int i = 0; i < num; i++) {
			g.drawOval(x, y, width, height);
			height-=20;width-=20;
			y+=10;x+=10;
		}
	}

}
