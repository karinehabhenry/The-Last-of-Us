package views;
import javax.swing.*;
import javax.print.DocFlavor.URL;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;

public class attackgif extends JFrame {
    private JLabel gifLabel;
    private Clip audioClip;

 public attackgif() {
        ImageIcon gifIcon = new ImageIcon("/Users/karin/OneDrive/Desktop/EVAL/Team109 - Karin Ehab Henry/Milestone2-Solution/attGIF.gif");
        JLabel gifLabel = new JLabel(gifIcon);

        getContentPane().add(gifLabel);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      //  setSize(500, 400);
        setBounds(600, 300, 500, 400);
        setVisible(true);

        // Set a timer to close the window after 6 seconds
        Timer timer = new Timer(2000, e -> {
            dispose(); // Close the window
        });
        timer.setRepeats(false); // Only fire the timer once
        timer.start();
        try {
            File audioFile = new File("/Users/karin/OneDrive/Desktop/EVAL/Team109 - Karin Ehab Henry/Milestone2-Solution/Untitled video - Made with Clipchamp (2).wav");
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
            new attackgif();
        });
    }
}