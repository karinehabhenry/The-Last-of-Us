package views;

import javax.swing.*;

public class GIF2 extends JFrame {
    public GIF2() {
        ImageIcon gifIcon = new ImageIcon("/Users/karin/OneDrive/Desktop/EVAL/Team109 - Karin Ehab Henry/Milestone2-Solution/attGIF.gif");
        JLabel gifLabel = new JLabel(gifIcon);

        getContentPane().add(gifLabel);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);

        // Set a timer to close the window after 6 seconds
        Timer timer = new Timer(6000, e -> {
            dispose(); // Close the window
        });
        timer.setRepeats(false); // Only fire the timer once
        timer.start();
    }}