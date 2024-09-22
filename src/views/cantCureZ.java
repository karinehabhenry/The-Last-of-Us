package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




public class cantCureZ extends JFrame {
	 JFrame frame;
		public cantCureZ() {
		   frame = new JFrame();
		   frame.setSize(400,200 );
		 //  frame.setBackground(Color.BLACK);
			JLabel  label=new  JLabel();
			 label.setIcon(new ImageIcon("CantCureZombies.jpg"));
			//	Icon nn= new ImageIcon("ChooseYourTarget.jpg");
          frame.setLocation(600, 450);
			 frame.add(label);
	         frame.setVisible(true);
	         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	         JButton b = new JButton("ok");
	        // label. setLayout(new FlowLayout(500));
	     //    b = new JButton("START GAME") ;
	      //   label.setBounds(0, 0, 1300, 700);

		}
}




