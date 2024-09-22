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



public class noActions extends JFrame  {
	
	public noActions() {
		 JFrame frame = new JFrame();
	   //frame.setSize(1600, 900);
	   frame.setBackground(Color.BLACK);
		JLabel  label=new  JLabel();
		 label.setIcon(new ImageIcon("NoEnoughActionPoints.jpg"));
		//	Icon nn= new ImageIcon("ChooseYourTarget.jpg");
			//Icon nn= new ImageIcon("NoEnoughActionPoints.jpg");
		   frame.setSize(400,200 );
	         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	          frame.setLocation(500, 450);

		 frame.add(label);
        frame.setVisible(true);
			
	}

}