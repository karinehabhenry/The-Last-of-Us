package views;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import engine.Game;
import model.characters.Explorer;
import model.characters.Fighter;
import model.characters.Hero;
import model.characters.Medic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chooseHero extends JFrame implements ActionListener {
	
	private JButton h1;
	private JButton h2;
	private JButton h3;
	private JButton h4;
	private JButton h5;
	private JButton h6;
	private JButton h7;
	private JButton h8;
	private JLabel  label1;
	private JLabel  titleLabel;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel he1;
	private JLabel he2;
	private JLabel he3;
	private JLabel he4;
	private JLabel he5;
	private JLabel he6;
	private JLabel he7;
	private JLabel he8;


	
	
	public chooseHero() {
		//Background
        Icon backgroundIcon = new ImageIcon("background.jpg");
        label1 = new JLabel(backgroundIcon);
        label1.setBounds(0, 0, 1600, 900);
        label1.setLayout(null);
        this.getContentPane().add(label1);
        //Title
        titleLabel = new JLabel("-CHOOSE YOUR HERO-");
        titleLabel.setBounds(600, 50, 300, 50);
        titleLabel.setFont(new Font("Press Gothic", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        label1.add(titleLabel);
        
        //Button labels 
        label2 = new JLabel(check(Game.availableHeroes.get(0))+"    "+Game.availableHeroes.get(0).getName());
        label2.setBounds(140, 400, 300, 50);
        label2.setFont(new Font("Press Gothic", Font.BOLD, 20));
        label2.setForeground(Color.WHITE);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label1.add(label2);
        
        label3 =new JLabel(check(Game.availableHeroes.get(1))+"    "+Game.availableHeroes.get(1).getName());
        label3.setBounds(440, 400, 300, 50);
        label3.setFont(new Font("Press Gothic", Font.BOLD, 20));
        label3.setForeground(Color.WHITE);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label1.add(label3);
        
        label4 = new JLabel(check(Game.availableHeroes.get(2))+"    "+Game.availableHeroes.get(2).getName());
        label4.setBounds(740, 400, 300, 50);
        label4.setFont(new Font("Press Gothic", Font.BOLD, 20));
        label4.setForeground(Color.WHITE);
        label4.setHorizontalAlignment(JLabel.CENTER);
        label1.add(label4);
        
        label5 = new JLabel(check(Game.availableHeroes.get(3))+"    "+Game.availableHeroes.get(3).getName());
        label5.setBounds(1040, 400, 300, 50);
        label5.setFont(new Font("Press Gothic", Font.BOLD, 20));
        label5.setForeground(Color.WHITE);
        label5.setHorizontalAlignment(JLabel.CENTER);
        label1.add(label5);
        
        label6 = new JLabel(check(Game.availableHeroes.get(4))+"    "+Game.availableHeroes.get(4).getName());
        label6.setBounds(140, 700, 300, 50);
        label6.setFont(new Font("Press Gothic", Font.BOLD, 20));
        label6.setForeground(Color.WHITE);
        label6.setHorizontalAlignment(JLabel.CENTER);
        label1.add(label6);
        
        label7 = new JLabel(check(Game.availableHeroes.get(5))+"    "+Game.availableHeroes.get(5).getName());
        label7.setBounds(440, 700, 300, 50);
        label7.setFont(new Font("Press Gothic", Font.BOLD, 20));
        label7.setForeground(Color.WHITE);
        label7.setHorizontalAlignment(JLabel.CENTER);
        label1.add(label7);
        
        label8 = new JLabel(check(Game.availableHeroes.get(6))+"    "+Game.availableHeroes.get(6).getName());
        label8.setBounds(740, 700, 300, 50);
        label8.setFont(new Font("Press Gothic", Font.BOLD, 20));
        label8.setForeground(Color.WHITE);
        label8.setHorizontalAlignment(JLabel.CENTER);
        label1.add(label8);
        
        label9 = new JLabel(check(Game.availableHeroes.get(7))+"    "+Game.availableHeroes.get(7).getName());
        label9.setBounds(1040, 700, 300, 50);
        label9.setFont(new Font("Press Gothic", Font.BOLD, 20));
        label9.setForeground(Color.WHITE);
        label9.setHorizontalAlignment(JLabel.CENTER);
        label1.add(label9);
        	
    		
        //Buttons
        Icon icon = new ImageIcon("elliee.jpg");
        h1 = new JButton(icon);
        h1.setBounds(200, 200, 200, 200);
        label1.add(h1);

        Icon icon2 = new ImageIcon("joell.jpg");
        h2 = new JButton(icon2);
        h2.setBounds(500, 200, 200, 200);
        label1.add(h2);


        Icon icon3 = new ImageIcon("rileyy.jpg");
        h3 = new JButton(icon3);
        h3.setBounds(800, 200, 200, 200);
        label1.add(h3);


        Icon icon4 = new ImageIcon("Tommy.jpg");
        h4 = new JButton(icon4);
        h4.setBounds(1100, 200, 200, 200);
        label1.add(h4);


        Icon icon5 = new ImageIcon("henry.jpg");
        h5 = new JButton(icon5);
        h5.setBounds(200, 500, 200, 200);
        label1.add(h5);


        Icon icon6 = new ImageIcon("tess.jpg");
        h6 = new JButton(icon6);
        h6.setBounds(500, 500, 200, 200);
        label1.add(h6);


        Icon icon7 = new ImageIcon("bill.jpg");
        h7 = new JButton(icon7);
        h7.setBounds(800, 500, 200, 200);
        label1.add(h7);


        Icon icon8 = new ImageIcon("abby.jpg");
        h8 = new JButton(icon8);
        h8.setBounds(1100, 500, 200, 200);
        label1.add(h8);
        


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1600, 900);
        h1.addActionListener(this); 
        h2.addActionListener(this); 
        h3.addActionListener(this); 
        h4.addActionListener(this); 
        h5.addActionListener(this); 
        h6.addActionListener(this); 
        h7.addActionListener(this); 
        h8.addActionListener(this); 
    }

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==h1)
	    Game.startGame(Game.availableHeroes.get(0));
		
		if(e.getSource()==h2)
	    Game.startGame(Game.availableHeroes.get(1));
	    
		if(e.getSource()==h3)
		Game.startGame(Game.availableHeroes.get(2));
	     
		if(e.getSource()==h4)
		Game.startGame(Game.availableHeroes.get(3));
	     
		if(e.getSource()==h5)
		Game.startGame(Game.availableHeroes.get(4));
	     
		if(e.getSource()==h6)
		Game.startGame(Game.availableHeroes.get(5));
	     
		if(e.getSource()==h7)
		Game.startGame(Game.availableHeroes.get(6));
		
		if(e.getSource()==h8)
		Game.startGame(Game.availableHeroes.get(7));
	    
		
    
	
		this.dispose();
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 start s=new start();
	
	}
	public static String check(Hero h) {
		if(h instanceof Fighter)
			return "FIGHTER";
		if(h instanceof Medic)
			return "MEDIC";
		if(h instanceof Explorer )
			return "EXPLORER";
		else
			return"";
		
	}
		
			

    public static void main(String[] args) {
    	System.out.print(Game.availableHeroes.get(0));
       
    }
	

}

