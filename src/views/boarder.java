package views;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class boarder {
	public boarder() {
		 JFrame frame = new JFrame();
		 frame.setSize(400,200 );
		   //frame.setSize(1600, 900);
			JLabel  label=new  JLabel();
			 label.setIcon(new ImageIcon("YouCantMoveOutsideTheBoarders.jpg"));
			//	Icon nn= new ImageIcon("ChooseYourTarget.jpg");
			 label.setVisible(true);

			 frame.add(label);
	        frame.setVisible(true);
	        frame.setLocation(400, 450);

	        JButton b = new JButton("ok");
	        label. setLayout(new FlowLayout(400));
	    //    b = new JButton("START GAME") ;
	        frame.setSize(400,200 );
	}

}
