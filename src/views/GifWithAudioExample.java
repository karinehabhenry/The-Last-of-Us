package views;


import javax.swing.*;
import javax.print.DocFlavor.URL;
import javax.sound.sampled.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GifWithAudioExample extends JFrame {
    private JLabel gifLabel;
    private Clip audioClip;

 public GifWithAudioExample() throws IOException {
	
        ImageIcon gifIcon = new ImageIcon("/Users/karin/OneDrive/Desktop/EVAL/Team109 - Karin Ehab Henry/Milestone2-Solution/start.gif");
        JLabel gifLabel = new JLabel(gifIcon);
       
        getContentPane().add(gifLabel);

       // setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1600, 900);
        setVisible(true);

        // Set a timer to close the window after 6 seconds
        Timer timer = new Timer(12000, e -> {
        	  dispose();
        	//chooseHero x=new chooseHero();
        	 try {
				Home s=new Home();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            dispose(); // Close the window
          
        });
        timer.setRepeats(false); // Only fire the timer once
        timer.start();
       
        try {
            File audioFile = new File("/Users/karin/OneDrive/Desktop/EVAL/Team109 - Karin Ehab Henry/Milestone2-Solution/starttt.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            Clip audioClip = AudioSystem.getClip();
            audioClip.open(audioInputStream);
            audioClip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    
    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(() -> {
            try {
				new GifWithAudioExample();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
        chooseHero x=new chooseHero();
    }
}