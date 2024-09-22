package views;

import javax.swing.*;

public class GIF extends JFrame {
    public GIF() {
        ImageIcon gifIcon = new ImageIcon("/Users/karin/OneDrive/Desktop/EVAL/Team109 - Karin Ehab Henry/Milestone2-Solution/ezgif.com-video-to-gif.gif");
        JLabel gifLabel = new JLabel(gifIcon);

        getContentPane().add(gifLabel);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1600, 900);
        setVisible(true);

        // Set a timer to close the window after 6 seconds
        Timer timer = new Timer(6000, e -> {
            dispose(); // Close the window
        });
        timer.setRepeats(false); // Only fire the timer once
        timer.start();
    }}