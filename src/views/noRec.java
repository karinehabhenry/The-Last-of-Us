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

public class noRec extends JFrame  {
	
	public noRec() {
		 JFrame frame = new JFrame();
	   frame.setSize(1600, 900);
		JLabel  label=new  JLabel();
		 label.setIcon(new ImageIcon("NoEnoughResources.jpg"));
		//	Icon nn= new ImageIcon("ChooseYourTarget.jpg");
        label.setVisible(true);
		 frame.add(label);
        frame.setVisible(true);
		 label.setVisible(true);

			
        JButton b = new JButton("ok");
        label. setLayout(new FlowLayout(500));
    //    b = new JButton("START GAME") ;
        frame.setSize(500,200 );
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocation(500, 450);
        

	}


}
