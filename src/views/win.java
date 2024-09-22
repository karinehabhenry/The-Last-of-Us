package views;

import java.awt.Panel;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Panel;

public class win  extends JFrame{
	
	public win() {
		
		Icon w= new ImageIcon("background.jpg");
	   JLabel p= new JLabel(w);
	   this.getContentPane().add(p);
	}

}
