package views;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import engine.Game;

public class Home extends JFrame implements ActionListener{
	 JFrame frame;
	 JLabel label;
	 JButton b;
	 
	 public Home() throws IOException {
		 JFrame frame = new JFrame();
		 frame.setSize(1600, 900);
		 label=new  JLabel();
		 label.setIcon(new ImageIcon("459660.png"));
		 frame.add(label);
         frame.setVisible(true);
         Icon icon = new ImageIcon("the-last-of-us-generic-button-0jpg-995e90.jpeg");
         b = new JButton(icon);
         //label. setLayout(new FlowLayout(500));
        // b = new JButton("START GAME") ;
       //  b.setBackground(Color.GRAY);
       b.setOpaque(false);
       b.setContentAreaFilled(false);
       b.setBorderPainted(false);
         b.setBounds(800, 400, 300, 500);
         b.setAction(null);
         b.addActionListener(this); 
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       //b.setb
        // b.setBorder(null);
         label.add(b);
         Game.loadHeroes("Heroes.csv");
     
         try {
             File audioFile = new File("/Users/karin/OneDrive/Desktop/EVAL/Team109 - Karin Ehab Henry/Milestone2-Solution/The Last of Us (Video Game Soundtrack).wav");
             AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
             Clip audioClip = AudioSystem.getClip();
             audioClip.open(audioInputStream);
             audioClip.start();
         } catch (Exception e1) {
             e1.printStackTrace();
         }
      			 
	 }


@Override
public void actionPerformed(ActionEvent e) {
	this.dispose();
	
	 chooseHero x = new chooseHero();
     //chooseTarget ml=new chooseTarget();
	 //System.exit(0);
	
}
	 
       public static void main(String[] args) throws IOException {
        Home x=new Home();
        
       
       
       
    
       } 
       

}
