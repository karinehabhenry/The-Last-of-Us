package views;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
public class occupied  extends JFrame {
	public occupied() {
		 JFrame frame = new JFrame();
	   frame.setSize(1600, 900);
		JLabel  label=new  JLabel();
		 label.setIcon(new ImageIcon("YouCantMoveToAnOccupiedCell.jpg"));
		//	Icon nn= new ImageIcon("ChooseYourTarget.jpg");
		 label.setVisible(true);

		 frame.add(label);
        frame.setVisible(true);
        frame.setLocation(600, 450);

        JButton b = new JButton("ok");
        label. setLayout(new FlowLayout(500));
    //    b = new JButton("START GAME") ;
        frame.setSize(400,200 );


	}
}
