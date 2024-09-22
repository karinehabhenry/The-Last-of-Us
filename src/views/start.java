package views;
import java.awt.Color;
import java.awt.Component;

import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import model.world.CollectibleCell;
import model.world.TrapCell;
import model.characters.Direction;
import model.characters.Explorer;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import engine.Game;

import model.world.CollectibleCell;
import model.characters.Explorer;
import model.characters.Fighter;
import model.characters.Hero;
import model.characters.Medic;
import model.characters.Zombie;
import model.collectibles.Vaccine;
import model.world.CharacterCell;
import javax.swing.Timer;

import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.WindowConstants;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class start extends JFrame implements ActionListener {
	//private static final Direction UP = null;
	public static JButton[][] map;
	private JComboBox <String> combo;
	private JPanel p1;
	private Icon icon;
	private JLabel jt;
	private JLabel k;
	 private JLabel t;
	 private JLabel ddd;
	 private JLabel s;
	 private JLabel n;
	 private JLabel a;
	 boolean special;
	 private Timer Time;
	 private Timer Tpic;
	 JFrame f;
	private JButton[][] charr;
	private Icon  c;
	private JButton move;
	private JButton endTurn;
	private JButton attack;
	private JButton CURE;
	private JButton usespecial;
	private JButton up ;
	private JButton l ;
	private JButton r ;
	private JButton dd ;
	private int xx;
	private int yy;
	private int xxz;
	private int yyz;
	private JPanel p2;
	
	
	
public start() {
   


     
	p1 = new JPanel();
	
	p1.setBounds(350, 40, 800, 800);
	p1.setBackground(Color.BLACK);
	p1.setLayout(new GridLayout(15, 15));
	this.getContentPane().add(p1);
	this.getContentPane().setBackground(Color.BLACK);
    
	
	
//	 endTurn=new JButton("ENDTURN");
//	 endTurn.setBounds(350, 840,800, 100);
//	 endTurn.setVisible(true);
//	 this.getContentPane().add(endTurn);
//	 endTurn.addActionListener(this);
//    charr=new JButton[2][4];
	map = new JButton[15][15];
	Icon vx=new ImageIcon("endturn.jpg");
	 endTurn=new JButton(vx);
	 endTurn.setBounds(10, 500,300, 100);
	 endTurn.setVisible(true);
	 this.getContentPane().add(endTurn);
	 endTurn.addActionListener(this);
	
	for (int i = 14;i > -1; i--) {
		for (int j = 0; j < map.length; j++) {
	      map[i][j] = new JButton();
			map[i][j].addActionListener(this);
			if(i==0&& j==0) {
				icon = new ImageIcon("HERO.jpg");
			    map[0][0] = new JButton(icon);
			    
				
			}
			if(Game.map[i][j] instanceof CollectibleCell )
					{
				if (((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Vaccine)
			
				      icon = new ImageIcon("vv.jpg");
				   else
					icon = new ImageIcon("sup.jpg");
					map[i][j] = new JButton(icon);}
		
			else
				if(Game.map[i][j] instanceof CharacterCell && ((CharacterCell)Game.map[i][j]).getCharacter() instanceof Zombie)
				{
					icon = new ImageIcon("zz.jpg");
				    map[i][j] = new JButton(icon);
				     }
			else 
			map[i][j].setBackground(Color.BLACK);
			map[i][j].addActionListener(this); 
		    p1.add(map[i][j]);
		}
	}    
	
	   
	     this.getContentPane().setLayout(null);
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	     this.setVisible(true);
	     this.setSize(1600, 900);
 for(int i=0;i<15;i++) {
	 for(int j=0;j<15;j++) {
		 map[i][j].setVisible(Game.map[i][j].isVisible());
		 
	 }
 }
//String[] r= {Game.heroes.get(0).getName()};
//
// combo=new JComboBox<String>(r);
// combo.setBounds(20, 300 ,200, 200);
// combo.setVisible(true);
// combo.addActionListener(this);
// this.getContentPane().add(combo);
}


@Override
public void actionPerformed(ActionEvent e) {
	if(Game.checkWin()) {
		 JLabel label=new  JLabel();
		 label.setIcon(new ImageIcon("WON.jpg"));
		this.setContentPane(label);
	   }
	 
	   if(Game.checkGameOver()) {
		   JLabel label=new  JLabel();
			 label.setIcon(new ImageIcon("LOST.jpg"));
			this.setContentPane(label);
	   }
	
	
	if(e.getSource()==usespecial) {
		special =true;
		(((Hero)((CharacterCell)Game.map[xx][yy]).getCharacter())).setSpecialAction(true);
		
		if(((Hero)((CharacterCell)Game.map[xx][yy]).getCharacter()) instanceof Medic) {
			
			chooseTarget c=new chooseTarget();
		}
		if(((Hero)((CharacterCell)Game.map[xx][yy]).getCharacter()) instanceof Explorer)
	
		
		
		try {
			((Hero)((CharacterCell)Game.map[xx][yy]).getCharacter()).useSpecial();
			for(int i=0;i<15;i++) {
				 for(int j=0;j<15;j++) {
					 map[i][j].setVisible(Game.map[i][j].isVisible());
					 
				 }
			        s.setText("Supplies:"+(((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getSupplyInventory().size()));

			 }
			if(Game.checkWin()) {
				 JLabel label=new  JLabel();
				 label.setIcon(new ImageIcon("WON.jpg"));
				this.setContentPane(label);
			   }
			 
			   if(Game.checkGameOver()) {
				   JLabel label=new  JLabel();
					 label.setIcon(new ImageIcon("LOST.jpg"));
					this.setContentPane(label);
			   }
			//t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());

		} catch (NoAvailableResourcesException | InvalidTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			if (e1.getLocalizedMessage()=="You need to have at least 1 supply in your inventory to use your special abililty.") {

//				Icon nn= new ImageIcon("NoEnoughResources.jpg");
//				JButton mm=new JButton(nn);
//				mm.setBackground(Color.BLACK);
//				mm.setBounds(1200, 50, 300, 200);
//				mm.setVisible(true);
//				this.getContentPane().add(mm);
				noRec r=new noRec();
				
			}
		}
		
		s.setText("Supplies:"+(((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getSupplyInventory().size()));
	}
	
	
	if(e.getSource()==attack) {

//		Icon nnn= new ImageIcon("ChooseYourTarget.jpg");
//		JButton mmm=new JButton(nnn);
//		mmm.setBackground(Color.BLACK);
//		mmm.setBounds(1200, 50, 300, 200);
//		mmm.setVisible(true);
//		this.getContentPane().add(mmm);
		
		
	
		
		try {
			((Hero)((CharacterCell)Game.map[xx][yy]).getCharacter()).attack();
			attackgif F=new attackgif();
			jt.setText("Actions Available:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getActionsAvailable());

		
			t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());
	//		chooseTarget ml=new chooseTarget();
		} catch (NotEnoughActionsException | InvalidTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			if (e1.getLocalizedMessage()=="You need at least 1 action point to be able to attack.") {

//				Icon nn= new ImageIcon("NoEnoughActionPoints.jpg");
//				JButton mm=new JButton(nn);
//				mm.setBackground(Color.BLACK);
//				mm.setBounds(1200, 50, 300, 200);
//				mm.setVisible(true);
//				this.getContentPane().add(mm);
				noActions y=new noActions();
//				
			}
			
			
			if (e1.getLocalizedMessage()=="You should select a target to attack first." ) {

//				Icon nn= new ImageIcon("ChooseYourTarget.jpg");
//				JButton mm=new JButton(nn);
//				mm.setBackground(Color.BLACK);
//				mm.setBounds(1200, 50, 300, 200);
//				mm.setVisible(true);
//				this.getContentPane().add(mm);
				chooseTarget t=new chooseTarget();

				
			}
			if (e1.getLocalizedMessage()=="You are only able to attack adjacent targets.") {
//
//				Icon nn= new ImageIcon("ChooseYourTarget.jpg");
//				JButton mm=new JButton(nn);
//				mm.setBackground(Color.BLACK);
//				mm.setBounds(1200, 50, 300, 200);
//				mm.setVisible(true);
//				this.getContentPane().add(mm);
				chooseTarget t=new chooseTarget();

				
			}
			if (e1.getLocalizedMessage()=="You can only attack zombies.") {

//				Icon nn= new ImageIcon("ChooseYourTarget.jpg");
//				JButton mm=new JButton(nn);
//				mm.setBackground(Color.BLACK);
//				mm.setBounds(1200, 50, 300, 200);
//				mm.setVisible(true);
//				this.getContentPane().add(mm);
				cantAttackH t=new cantAttackH();
				
			}
			
			
			
			
		}
   }
	if(e.getSource()==CURE) {
		try {
			
			((Hero)((CharacterCell)Game.map[xx][yy]).getCharacter()).cure();
			
			jt.setText("Avtions Available:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getActionsAvailable());
			ddd.setText("Vaccines:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getVaccineInventory().size());
             
			Hero h= Game.heroes.get(Game.heroes.size()-1);
			String r=h.getName();
			JButton cs=new JButton(r);
	        cs.setFont(new Font("Press Gothic", Font.BOLD, 20));
	        cs.setForeground(Color.WHITE);

			cs.setBackground(Color.BLACK);
			p2.add(cs);
			
			
			if(Game.checkWin()) {
				 JLabel label=new  JLabel();
				 label.setIcon(new ImageIcon("WON.jpg"));
				this.setContentPane(label);
			   }
			 
			   if(Game.checkGameOver()) {
				   JLabel label=new  JLabel();
					 label.setIcon(new ImageIcon("LOST.jpg"));
					this.setContentPane(label);
			   }
				 
				 
				 
				 
				 
//				Hero h= Game.heroes.get(Game.heroes.size()-1);
//				
//				JLabel x=new JLabel("Actions Available:"+(h.getActionsAvailable()));
//				x.setFont(new Font("Press Gothic", Font.BOLD, 14));
//		        x.setForeground(Color.WHITE);
//		       x.setBounds(1200, Game.heroes.size()*25, 200, 200);
//		       x.setVisible(true);
//		       // this.getContentPane().add(x);
//		          
//		        
//		        
//		        JLabel xa=new JLabel("Attack damage:"+(h.getAttackDmg()));
//				xa.setForeground(Color.WHITE);
//		        xa.setBounds(1200 ,(Game.heroes.size()*25)+25 ,200, 200);
//		        xa.setFont(new Font("Press Gothic", Font.BOLD, 14));
//		        xa.setVisible(true);
//		 //      this.getContentPane().add(xa);
//		        
//		        
//		       JLabel t=new JLabel("Current HP:"+(h.getCurrentHp()));
//		       t.setForeground(Color.WHITE);
//		       t.setBounds(1200, (Game.heroes.size()*25)+50, 200, 200);
//		       t.setFont(new Font("Press Gothic", Font.BOLD, 14));
//		       t.setVisible(true);
//		     //  this.getContentPane().add(t)
//		           ;
//		       JLabel k=new JLabel(check((h)));
//		       k.setForeground(Color.WHITE);
//		       k.setBounds(1200, (Game.heroes.size()*25)+75, 200, 200);
//		       k.setFont(new Font("Press Gothic", Font.BOLD, 14));
//		       k.setVisible(true);
//		       //this.getContentPane() .add(k);
//		        
//		        
//		        
//		        
//		       JLabel  ddd=new JLabel("Vaccines:"+(h.getVaccineInventory().size()));
//		       ddd.setForeground(Color.WHITE);
//		       ddd.setBounds(1200, (Game.heroes.size()*25)+100, 200, 200);
//		       ddd.setFont(new Font("Press Gothic", Font.BOLD, 14));
//		       ddd.setVisible(true);
//		     //  this.getContentPane().add(ddd);
//		        
//		        
//		        
//		        
//		        JLabel s=new JLabel("Supplies:"+((h.getSupplyInventory().size())));
//		        s.setForeground(Color.WHITE);
//		        s.setBounds(1200, (Game.heroes.size()*25)+125 ,200, 200);
//		        s.setFont(new Font("Press Gothic", Font.BOLD, 14));
//		        s.setVisible(true);
//		      //this.getContentPane().add(s);
//		        
//		        
//		        
//		          JLabel n=new JLabel("Name: "+(h.getName()));
//		        n.setForeground(Color.WHITE);
//		        n.setBounds(1200, (Game.heroes.size()*25)+150, 200, 200);
//		        n.setFont(new Font("Press Gothic", Font.BOLD, 14));
//		        n.setVisible(true);
//		        
//		        
//		        this.getContentPane().add(xa);
//		        this.getContentPane() .add(k);
//		        this.getContentPane().add(ddd);
//		        this.getContentPane().add(s);
//		        this.getContentPane().add(n);
//		        this.getContentPane().add(x);
//		        this.getContentPane().add(t);
//			     
		        
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
			//t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());
		} 
		catch (NotEnoughActionsException | InvalidTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			if (e1.getLocalizedMessage()=="You need to have at least 1 action point in order to cure a zombie.") {

//				Icon nn= new ImageIcon("NoEnoughActionPoints.jpg");
//				JButton mm=new JButton(nn);
//				mm.setBackground(Color.BLACK);
//				mm.setBounds(1200, 50, 300, 200);
//				mm.setVisible(true);
//				this.getContentPane().add(mm);
				
					noActions t=new noActions();
				
			}
			
			if (e1.getLocalizedMessage()=="You can only cure zombies." ) {

//				Icon nn= new ImageIcon("ChooseYourTarget.jpg");
//				JButton mm=new JButton(nn);
//				mm.setBackground(Color.BLACK);
//				mm.setBounds(1200, 50, 300, 200);
//				mm.setVisible(true);
//				this.getContentPane().add(mm);
				
				
			}
			if (e1.getLocalizedMessage()=="You are only able to cure adjacent targets.") {

//				Icon nn= new ImageIcon("ChooseYourTarget.jpg");
//				JButton mm=new JButton(nn);
//				mm.setBackground(Color.BLACK);
//				mm.setBounds(1200, 50, 300, 200);
//				mm.setVisible(true);
//				this.getContentPane().add(mm);
				
					chooseTarget t=new chooseTarget();
				
				
			}
			if (e1.getLocalizedMessage()=="You need to pick a target to cure first.") {

//				Icon nn= new ImageIcon("ChooseYourTarget.jpg");
//				JButton mm=new JButton(nn);
//				mm.setBackground(Color.BLACK);
//				mm.setBounds(1200, 50, 300, 200);
//				mm.setVisible(true);
//				this.getContentPane().add(mm);
				
					chooseTarget t=new chooseTarget();
			
			}
			
			
				
		} catch (NoAvailableResourcesException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			if (e1.getLocalizedMessage()=="You need to have at least 1 vaccine in your inventory to be able to cure zombies.") {

//				Icon nn= new ImageIcon("NoEnoughResources.jpg");
//				JButton mm=new JButton(nn);
//				mm.setBackground(Color.BLACK);
//				mm.setBounds(1200, 50, 300, 200);
//				mm.setVisible(true);
//				this.getContentPane().add(mm);
				
					noRec t=new noRec();
				
			}
			
//			Icon nn= new ImageIcon("YouCantMoveToAnOccupiedCell.jpg");
//			JButton mm=new JButton(nn);
//			mm.setBackground(Color.BLACK);
//			mm.setBounds(1200, 50, 300, 200);
//			mm.setVisible(true);
//			this.getContentPane().add(mm);
//		}
		}
		
			//occupied t=new occupied();
		
//		
//   ArrayList <JLabel> s=new ArrayList<JLabel>();
//   s=dis(Game.heroes);
//   for(int i=1;i<=s.size();i++) {
//	   s.get(i).setVisible(true);
//	 // s.get(i).setBounds(1000, i*25+25, 200, 200);
//	   this.getContentPane().add(s.get(i));
//	   
//   }
	}	
	
	
	
	
	
	//System.out.print(xx+""+yy);
	
	//if(e.getSource()==move) {
//		  Icon c = new ImageIcon("upppp.jpg");	    
//	      JButton up =  new JButton(c);
//	      up.setBounds(1320, 600, 50, 50);
//	      up.setBackground(Color.WHITE);
//	      this.getContentPane().add(up);	
//	      up.setVisible(true);
//	      
//	      Icon rb = new ImageIcon("uppp.jpg");
//	      JButton r =  new JButton(rb);
//	      r.setBounds(1250, 665, 50, 50);
//	      r.setBackground(Color.WHITE);
//	      this.getContentPane().add(r);	
//	      r.setVisible(true);
//	      
//	      Icon lb = new ImageIcon("righttt.jpg");
//	      JButton l =  new JButton(lb);
//	      l.setBounds(1390, 665, 50, 50);
//	      l.setBackground(Color.WHITE);
//	      this.getContentPane().add(l);	
//	      l.setVisible(true);
//	      
//	      Icon db = new ImageIcon("arrowww.jpg");
//	      JButton d =  new JButton(db);
//	      d.setBounds(1320, 730, 50, 50);
//	      d.setBackground(Color.WHITE);
//	      this.getContentPane().add(d);	
//	      d.setVisible(true);
//		
	
		
//	}
	//else {
	
	if(e.getSource()==up) {
		
		try {
		Direction d= Direction.UP;
	
		
		((Hero)((CharacterCell)(Game.map[xx][yy])).getCharacter()).move(d);
		if(((Game.map[xx+1][yy])) instanceof TrapCell){
			  SwingUtilities.invokeLater(() -> {
			      GIF f=  new GIF();
		

			    });
			//	t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());

		}
		xx=xx+1;
		map[xx-1][yy].setIcon(null);
		map[xx-1][yy].setBackground(Color.BLACK);
		icon = new ImageIcon("HERO.jpg");
		map[xx][yy].setIcon(icon);
		t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());

		jt.setText("Avtions Available:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getActionsAvailable());
		System.out.print(xx+""+yy);
		ddd.setText("Vaccines:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getVaccineInventory().size());
        s.setText("Supplies:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getSupplyInventory().size());
        for(int i=0;i<15;i++) {
       	 for(int j=0;j<15;j++) {
       		 map[i][j].setVisible(Game.map[i][j].isVisible());
       	 }
        }
		
        if(Game.checkWin()) {
   		 JLabel label=new  JLabel();
   		 label.setIcon(new ImageIcon("WON.jpg"));
   		this.setContentPane(label);
   	   }
   	 
   	   if(Game.checkGameOver()) {
   		   JLabel label=new  JLabel();
   			 label.setIcon(new ImageIcon("LOST.jpg"));
   			this.setContentPane(label);
   	   }
   	   
		} catch (MovementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	
		if (e1.getLocalizedMessage()=="You cannot move to an occuppied cell.") {

//				Icon nn= new ImageIcon("YouCantMoveToAnOccupiedCell.jpg");
//				JButton mm=new JButton(nn);
//				mm.setBackground(Color.BLACK);
//				mm.setBounds(1200, 50, 300, 200);
//				mm.setVisible(true);
//				this.getContentPane().add(mm);
				occupied c=new occupied();
			//	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		        
		      

		        // Set a timer to close the window after 6 seconds
//		        Timer Tpic = new Timer(6000, e1 -> {
//		            dispose(); // Close the window
//		        });
//		        Tpic.setRepeats(false); // Only fire the timer once
//		        Tpic.start();
//			
				
				
//				JLabel m=new JLabel(""+e1.getLocalizedMessage());
//				m.setForeground(Color.WHITE);
//		        m.setBounds(20, 400, 200, 200);
//		        m.setFont(new Font("Press Gothic", Font.BOLD, 14));
//		        m.setVisible(true);
//		        this.getContentPane().add(m);
		        

			}
		if (e1.getLocalizedMessage()=="You cannot move outside the borders of the map.") {

//			Icon ww= new ImageIcon("YouCantMoveOutsideTheBoarders.jpg");
//			JButton vv=new JButton(ww);
//			vv.setBackground(Color.BLACK);
//			vv.setBounds(1200, 50, 300, 200);
//			vv.setVisible(true);
//			this.getContentPane().add(vv);
			boarder b= new boarder();
		}


		} catch (NotEnoughActionsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			if (e1.getLocalizedMessage()=="You need at least 1 action point in order to move.") {
//
//				Icon ww= new ImageIcon("NoEnoughActionPoints.jpg");
//				JButton vv=new JButton(ww);
//				vv.setBackground(Color.BLACK);
//				vv.setBounds(1200, 50, 300, 200);
//				vv.setVisible(true);
//				this.getContentPane().add(vv);
				noActions a=new noActions ();
			}
			
		}
		
	}
	if(e.getSource()==l) {
		
		try {
		Direction d= Direction.RIGHT;
		
		((Hero)((CharacterCell)(Game.map[xx][yy])).getCharacter()).move(d);
		if(((Game.map[xx][yy+1])) instanceof TrapCell){
			  SwingUtilities.invokeLater(() -> {
			      GIF f=  new GIF();
		

			    });
			//	t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());

		}
		yy=yy+1;
		map[xx][yy-1].setIcon(null);
		map[xx][yy-1].setBackground(Color.BLACK);
		icon = new ImageIcon("HERO.jpg");
		map[xx][yy].setIcon(icon);
		t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());

		jt.setText("Avtions Available:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getActionsAvailable());
		System.out.print(xx+""+yy);
		ddd.setText("Vaccines:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getVaccineInventory().size());
        s.setText("Supplies:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getSupplyInventory().size());

        for(int i=0;i<15;i++) {
       	 for(int j=0;j<15;j++) {
       		 map[i][j].setVisible(Game.map[i][j].isVisible());
       	 }
        }
        if(Game.checkWin()) {
   		 JLabel label=new  JLabel();
   		 label.setIcon(new ImageIcon("WON.jpg"));
   		this.setContentPane(label);
   	   }
   	 
   	   if(Game.checkGameOver()) {
   		   JLabel label=new  JLabel();
   			 label.setIcon(new ImageIcon("LOST.jpg"));
   			this.setContentPane(label);
   	   }
	
		} catch (MovementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			
			if (e1.getLocalizedMessage()=="You cannot move to an occuppied cell.") {

//			Icon nn= new ImageIcon("YouCantMoveToAnOccupiedCell.jpg");
//			JButton mm=new JButton(nn);
//			mm.setBackground(Color.BLACK);
//			mm.setBounds(1200, 50, 300, 200);
//			mm.setVisible(true);
//			this.getContentPane().add(mm);
				occupied c=new occupied();
			}
			
			if (e1.getLocalizedMessage()=="You cannot move outside the borders of the map.") {

			//	Icon ww= new ImageIcon("YouCantMoveOutsideTheBoarders.jpg");
				
				boarder b= new boarder();

			}
			
			
		} catch (NotEnoughActionsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			if (e1.getLocalizedMessage()=="You need at least 1 action point in order to move.") {
//
//				Icon ww= new ImageIcon("NoEnoughActionPoints.jpg");
//				JButton vv=new JButton(ww);
//				vv.setBackground(Color.BLACK);
//				vv.setBounds(1200, 50, 300, 200);
//				vv.setVisible(true);
//				this.getContentPane().add(vv);
				noActions a=new noActions ();
			}
		}
		
	}
	
	if(e.getSource()==r) {
		
		try {
		Direction d= Direction.LEFT;
	
		((Hero)((CharacterCell)(Game.map[xx][yy])).getCharacter()).move(d);
		if(((Game.map[xx][yy-1])) instanceof TrapCell){
			  SwingUtilities.invokeLater(() -> {
			      GIF f=  new GIF();
		

			    });
			//	t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());

		}
		yy=yy-1;
		map[xx][yy+1].setIcon(null);
		map[xx][yy+1].setBackground(Color.BLACK);
		icon = new ImageIcon("HERO.jpg");
		map[xx][yy].setIcon(icon);
		t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());

		jt.setText("Avtions Available:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getActionsAvailable());
		System.out.print(xx+""+yy);
		ddd.setText("Vaccines:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getVaccineInventory().size());
        s.setText("Supplies:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getSupplyInventory().size());
        for(int i=0;i<15;i++) {
       	 for(int j=0;j<15;j++) {
       		 map[i][j].setVisible(Game.map[i][j].isVisible());
       	 }
        }
        if(Game.checkWin()) {
   		 JLabel label=new  JLabel();
   		 label.setIcon(new ImageIcon("WON.jpg"));
   		this.setContentPane(label);
   	   }
   	 
   	   if(Game.checkGameOver()) {
   		   JLabel label=new  JLabel();
   			 label.setIcon(new ImageIcon("LOST.jpg"));
   			this.setContentPane(label);
   	   }
   	   
		} catch (MovementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			
			if (e1.getLocalizedMessage()=="You cannot move to an occuppied cell.") {

//			Icon nn= new ImageIcon("YouCantMoveToAnOccupiedCell.jpg");
//			JButton mm=new JButton(nn);
//			mm.setBackground(Color.BLACK);
//			mm.setBounds(1200, 50, 300, 200);
//			mm.setVisible(true);
//			this.getContentPane().add(mm);
				occupied c=new occupied();
			}
			
			if (e1.getLocalizedMessage()=="You cannot move outside the borders of the map.") {

//				Icon ww= new ImageIcon("YouCantMoveOutsideTheBoarders.jpg");
//				JButton vv=new JButton(ww);
//				vv.setBackground(Color.BLACK);
//				vv.setBounds(1200, 50, 300, 200);
//				vv.setVisible(true);
//				this.getContentPane().add(vv);
				boarder b= new boarder();

			}
			
		} catch (NotEnoughActionsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			if (e1.getLocalizedMessage()=="You need at least 1 action point in order to move.") {

//				Icon ww= new ImageIcon("NoEnoughActionPoints.jpg");
//				JButton vv=new JButton(ww);
//				vv.setBackground(Color.BLACK);
//				vv.setBounds(1200, 50, 300, 200);
//				vv.setVisible(true);
//				this.getContentPane().add(vv);
				noActions a=new noActions ();
			}
		}
		
	}
	
	if(e.getSource()==dd) {
		System.out.print(xx+""+yy);
		try {
		Direction d= Direction.DOWN;
		
		((Hero)((CharacterCell)(Game.map[xx][yy])).getCharacter()).move(d);
		if(((Game.map[xx-1][yy])) instanceof TrapCell){
			  SwingUtilities.invokeLater(() -> {
			      GIF f=  new GIF();
		

			    });
			//	t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());

		}
		xx=xx-1;
		map[xx+1][yy].setIcon(null);
		map[xx+1][yy].setBackground(Color.BLACK);
		icon = new ImageIcon("HERO.jpg");
		t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());

		map[xx][yy].setIcon(icon);
		System.out.print(xx+""+yy);
		jt.setText("Avtions Available:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getActionsAvailable());
		ddd.setText("Vaccines:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getVaccineInventory().size());
        s.setText("Supplies:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getSupplyInventory().size());
        for(int i=0;i<15;i++) {
       	 for(int j=0;j<15;j++) {
       		 map[i][j].setVisible(Game.map[i][j].isVisible());
       	 }
        }
        if(Game.checkWin()) {
   		 JLabel label=new  JLabel();
   		 label.setIcon(new ImageIcon("WON.jpg"));
   		this.setContentPane(label);
   	   }
   	 
   	   if(Game.checkGameOver()) {
   		   JLabel label=new  JLabel();
   			 label.setIcon(new ImageIcon("LOST.jpg"));
   			this.setContentPane(label);
   	   }
   	   
		
		} catch (MovementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			if (e1.getLocalizedMessage()=="You cannot move to an occuppied cell.") {

//			Icon nn= new ImageIcon("YouCantMoveToAnOccupiedCell.jpg");
//			JButton mm=new JButton(nn);
//			mm.setBackground(Color.BLACK);
//			mm.setBounds(1200, 50, 300, 200);
//			mm.setVisible(true);
//			this.getContentPane().add(mm);
				occupied c=new occupied();
			
			}
			
			if (e1.getLocalizedMessage()=="You cannot move outside the borders of the map.") {

////				Icon ww= new ImageIcon("YouCantMoveOutsideTheBoarders.jpg");
//				JButton vv=new JButton(ww);
//				vv.setBackground(Color.BLACK);
//				vv.setBounds(1200, 50, 300, 200);
//				vv.setVisible(true);
//				this.getContentPane().add(vv);
				boarder b=new boarder();
			}
			
		} catch (NotEnoughActionsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			if (e1.getLocalizedMessage()=="You need at least 1 action point in order to move.") {

//				Icon ww= new ImageIcon("NoEnoughActionPoints.jpg");
//				JButton vv=new JButton(ww);
//				vv.setBackground(Color.BLACK);
//				vv.setBounds(1200, 50, 300, 200);
//				vv.setVisible(true);
//				this.getContentPane().add(vv);
				noActions a=new noActions ();
			}
		}
		
	}
	
//	
//	for (int i = 0; i < map.length; i++) {
//		for (int p = 0; p < map.length; p++) {
//			
//			
//	   if(e.getSource()==map[i][p] && Game.map[i][p] instanceof CharacterCell && (((CharacterCell)Game.map[i][p]).getCharacter())instanceof  Hero) {
//		xx=i;
//		yy=p;
//		
//		
//		jt=new JLabel();
//		jt.setText("Actions Available:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getActionsAvailable());
//		jt.setFont(new Font("Press Gothic", Font.BOLD, 14));
//        jt.setForeground(Color.WHITE);
//        jt.setBounds(20, 175, 200, 200);
//        t=new JLabel();
//        t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());
//           
//         
//         k=new JLabel();
//         k.setText(check((Hero)((((CharacterCell)Game.map[xx][yy]).getCharacter()))));
//        k.setForeground(Color.WHITE);
//        k.setBounds(20, 125, 200, 200);
//        k.setFont(new Font("Press Gothic", Font.BOLD, 14));
//        k.setVisible(true);
//        this.getContentPane().add(k);
//        
//        
//        
//        ddd=new JLabel();
//        ddd.setText("Vaccines:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getVaccineInventory().size());
//       ddd.setForeground(Color.WHITE);
//        ddd.setBounds(20, 200, 200, 200);
//        ddd.setFont(new Font("Press Gothic", Font.BOLD, 14));
//        ddd.setVisible(true);
//        this.getContentPane().add(ddd);
//        
//        
//        
//        s=new JLabel();
//        s.setText("Supplies:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getSupplyInventory().size());
//        s.setForeground(Color.WHITE);
//        s.setBounds(20, 225, 200, 200);
//        s.setFont(new Font("Press Gothic", Font.BOLD, 14));
//        s.setVisible(true);
//        this.getContentPane().add(s);
//        
//        n=new JLabel();
//        n.setText("Name: "+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getName());
//        n.setForeground(Color.WHITE);
//        n.setBounds(20, 100, 200, 200);
//        n.setFont(new Font("Press Gothic", Font.BOLD, 14));
//        n.setVisible(true);
//        this.getContentPane().add(n);
//        
//        this.getContentPane().add(jt);
//        this.getContentPane().add(t);
//        t.setForeground(Color.WHITE);
//        t.setBounds(20, 150, 200, 200);
//        t.setFont(new Font("Press Gothic", Font.BOLD, 14));
//        jt.setVisible(true);
//        t.setVisible(true);
//        Icon c = new ImageIcon("upppp.jpg");	    
//	      up =  new JButton(c);
//	      up.setBounds(1320, 600, 50, 50);
//	      up.setBackground(Color.WHITE);
//	      up.addActionListener(this);
//	      this.getContentPane().add(up);	
//	      up.setVisible(true);
//	      
//	      Icon rb = new ImageIcon("uppp.jpg");
//	      r =  new JButton(rb);
//	      r.setBounds(1250, 665, 50, 50);
//	      r.setBackground(Color.WHITE);
//	      r.addActionListener(this);
//	      this.getContentPane().add(r);	
//	      r.setVisible(true);
//	      
//	      Icon lb = new ImageIcon("righttt.jpg");
//	      l =  new JButton(lb);
//	      l.setBounds(1390, 665, 50, 50);
//	      l.setBackground(Color.WHITE);
//	      this.getContentPane().add(l);	
//	      l.addActionListener(this);
//	      l.setVisible(true);
//	      
//	      Icon db = new ImageIcon("arrowww.jpg");
//	      dd =  new JButton(db);
//	      dd.setBounds(1320, 730, 50, 50);
//	      dd.setBackground(Color.WHITE);
//	      dd.addActionListener(this);
//	      this.getContentPane().add(dd);	
//	      dd.setVisible(true);
//	      actions();
//	}	

	for (int i = 0; i < map.length; i++) {
		for (int p = 0; p < map.length; p++) {
			
	   if(e.getSource()==map[i][p] && Game.map[i][p] instanceof CharacterCell && (((CharacterCell)Game.map[i][p]).getCharacter())instanceof  Hero) {
		  
		  
				
			int xxold=xx;	
			int yyold=yy;
		
			
		xx=i;
		yy=p;
		 
	  ((Hero)(((CharacterCell)Game.map[xxold][yyold]).getCharacter())).setTarget(((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())));
	if(special==true) {
	  try {
			((Hero)((CharacterCell)Game.map[xx][yy]).getCharacter()).useSpecial();
		//	t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());
            special=false;
           ( ((CharacterCell)Game.map[xxold][yyold]).getCharacter()).setTarget(null);
          //  chooseTarget c=new chooseTarget();
		} catch (NoAvailableResourcesException | InvalidTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			if (e1.getLocalizedMessage()=="You need to have at least 1 vaccine in your inventory to be able to cure zombies.") {

//				Icon nn= new ImageIcon("NoEnoughResources.jpg");
//				JButton mm=new JButton(nn);
//				mm.setBackground(Color.BLACK);
//				mm.setBounds(1200, 50, 300, 200);
//				mm.setVisible(true);
//				this.getContentPane().add(mm);
				noRec cc=new noRec();
				
			}
			if(e1.getLocalizedMessage()=="You can only cure fellow heroes.") {
			cantCureZ z= new cantCureZ();
			}
		}
		
	  
	  
	   }
		
		  xx=i;
		  yy=p;
		if(i==0&& p==0) {
		jt=new JLabel("Actions Available:"+((Hero)(((CharacterCell)Game.map[0][0]).getCharacter())).getActionsAvailable());
		jt.setFont(new Font("Press Gothic", Font.BOLD, 14));
        jt.setForeground(Color.WHITE);
        jt.setBounds(20, 175, 200, 200);
          
        
        
		a=new JLabel("Attack damage:"+((((CharacterCell)Game.map[0][0]).getCharacter())).getAttackDmg());
		a.setForeground(Color.WHITE);
        a.setBounds(20, 250, 200, 200);
        a.setFont(new Font("Press Gothic", Font.BOLD, 14));
        a.setVisible(true);
        this.getContentPane().add(a);
        
        
        t=new JLabel("Current HP:"+((((CharacterCell)Game.map[0][0]).getCharacter())).getCurrentHp());
           
        k=new JLabel(check((Hero)((((CharacterCell)Game.map[0][0]).getCharacter()))));
        k.setForeground(Color.WHITE);
        k.setBounds(20, 125, 200, 200);
        k.setFont(new Font("Press Gothic", Font.BOLD, 14));
        k.setVisible(true);
        this.getContentPane().add(k);
        
        
        
        
         ddd=new JLabel("Vaccines:"+((Hero)(((CharacterCell)Game.map[0][0]).getCharacter())).getVaccineInventory().size());
        ddd.setForeground(Color.WHITE);
        ddd.setBounds(20, 200, 200, 200);
        ddd.setFont(new Font("Press Gothic", Font.BOLD, 14));
        ddd.setVisible(true);
        this.getContentPane().add(ddd);
        
        
        
        
         s=new JLabel("Supplies:"+((Hero)(((CharacterCell)Game.map[0][0]).getCharacter())).getSupplyInventory().size());
        s.setForeground(Color.WHITE);
        s.setBounds(20, 225, 200, 200);
        s.setFont(new Font("Press Gothic", Font.BOLD, 14));
        s.setVisible(true);
        this.getContentPane().add(s);
        
        
        
         n=new JLabel("Name: "+((((CharacterCell)Game.map[0][0]).getCharacter())).getName());
        n.setForeground(Color.WHITE);
        n.setBounds(20, 100, 200, 200);
        n.setFont(new Font("Press Gothic", Font.BOLD, 14));
        n.setVisible(true);
        this.getContentPane().add(n);
        
        this.getContentPane().add(jt);
        this.getContentPane().add(t);
        t.setForeground(Color.WHITE);
        t.setBounds(20, 150, 200, 200);
        t.setFont(new Font("Press Gothic", Font.BOLD, 14));
        jt.setVisible(true);
        t.setVisible(true);
        Icon c = new ImageIcon("upppp.jpg");	    
	      up =  new JButton(c);
	      up.setBounds(1320, 600, 50, 50);
	      up.setBackground(Color.WHITE);
	      up.addActionListener(this);
	      this.getContentPane().add(up);	
	      up.setVisible(true);
	      
	      Icon rb = new ImageIcon("uppp.jpg");
	      r =  new JButton(rb);
	      r.setBounds(1250, 665, 50, 50);
	      r.setBackground(Color.WHITE);
	      r.addActionListener(this);
	      this.getContentPane().add(r);	
	      r.setVisible(true);
	      
	      Icon lb = new ImageIcon("righttt.jpg");
	      l =  new JButton(lb);
	      l.setBounds(1390, 665, 50, 50);
	      l.setBackground(Color.WHITE);
	      this.getContentPane().add(l);	
	      l.addActionListener(this);
	      l.setVisible(true);
	      
	      Icon db = new ImageIcon("arrowww.jpg");
	      dd =  new JButton(db);
	      dd.setBounds(1320, 730, 50, 50);
	      dd.setBackground(Color.WHITE);
	      dd.addActionListener(this);
	      this.getContentPane().add(dd);	
	      dd.setVisible(true);
	      actions();
//	      String[] r= {Game.heroes.get(0).getName()};
//
//	      combo=new JComboBox<String>(r);
//	      combo.setBounds(20, 300 ,200, 200);
//	      combo.setVisible(true);
//	      combo.addActionListener(this);
//	      this.getContentPane().add(combo);
//	      JButton player=new JButton(""+Game.heroes.get(0).getName());
//	      player.setBounds(1200, 450 ,100, 100);
//	      player.setVisible(true);
//	      player.addActionListener(this);
//	      this.getContentPane().add(player);
	      JButton cs=new JButton(""+Game.heroes.get(0).getName());
	       p2 = new JPanel();
	  	
	  	p2.setBounds(1100, 60, 200, 100);
	  	p2.setBackground(Color.BLACK);
	  	p2.setLayout(new GridLayout(2, 4));
	  	this.getContentPane().add(p2);
	  	 cs.setFont(new Font("Press Gothic", Font.BOLD, 20));
	        cs.setForeground(Color.WHITE);

			cs.setBackground(Color.BLACK);
	  	p2.add(cs);
	  	//this.getContentPane().setBackground(Color.BLACK);
	      
		}
		else {
			jt.setText("Actions Available:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getActionsAvailable());
	         ddd.setText("Vaccines:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getVaccineInventory().size());
	         n.setText("Name: "+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getName());
	         s.setText("Supplies:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getSupplyInventory().size());
	         k.setText(check((Hero)((((CharacterCell)Game.map[xx][yy]).getCharacter()))));
	         t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());

		}
	}	
	
	
	  
	
		
	 else {
	   if(e.getSource()==map[i][p] && Game.map[i][p] instanceof CharacterCell && (((CharacterCell)Game.map[i][p]).getCharacter())instanceof  Zombie) {
				xxz=i;
				yyz=p;
				((Hero)((CharacterCell)Game.map[xx][yy]).getCharacter()).setTarget((((CharacterCell)Game.map[xxz][yyz])).getCharacter());
		       return;
	   }
	   
	   }   
	}
	
	}

		 if(e.getSource()==endTurn)  {
			 try {
				Game.endTurn();
				if(Game.checkWin()) {
					 JLabel label=new  JLabel();
					 label.setIcon(new ImageIcon("WON.jpg"));
					this.setContentPane(label);
				   }
				 
				   if(Game.checkGameOver()) {
					   JLabel label=new  JLabel();
						System.out.println("lost");
					   // label.setIcon(new ImageIcon("LOST.jpg"));
						this.setContentPane(label);
				   }
				   
					 
						
				for (int ii =0;ii < 15; ii++) {
					for (int jj = 0; jj <15; jj++) {
							if(Game.map[ii][jj] instanceof CharacterCell && ((CharacterCell)Game.map[ii][jj]).getCharacter() instanceof Zombie && map[ii][jj].getIcon()==null)
							{
								icon = new ImageIcon("zz.jpg");
							    map[ii][jj].setIcon(icon);
					           	t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());
								jt.setText("Avtions Available:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getMaxActions());
								 for(int i=0;i<15;i++) {
									 for(int j=0;j<15;j++) {
										 map[i][j].setVisible(Game.map[i][j].isVisible());
									 }
								 }
							
									
							    return;
							     }
					}
				}
				
				
				
			 		
				
				
		 //  (((CharacterCell)Game.map[xx][yy]).getCharacter()).setCurrentHp(((((CharacterCell)Game.map[xx][yy]).getCharacter())).getCurrentHp());			
           //	t.setText("Current HP:"+((((CharacterCell)Game.map[xx][yy]).getCharacter())).getMaxHp());
				
		//	j.setText("Avtions Available:"+((Hero)(((CharacterCell)Game.map[xx][yy]).getCharacter())).getMaxActions());

			} catch (NotEnoughActionsException | InvalidTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		 
	
		 }
	   }
    

	
	


	
	public  void actions() {
//		 move=new JButton( "MOVE");
//		 move.setBounds(20, 125, 75, 50);
//		 move.setVisible(true);
//		 this.getContentPane().add(move);
//		 move.addActionListener(this);
//		
		
//		 attack=new JButton("ATTACK");
//		 attack.setBounds(20, 135, 85, 50);
//		 attack.setVisible(true);
//		 this.getContentPane().add(attack);
//		 attack.addActionListener(this);
//		 
//		 
//		 CURE=new JButton( "CURE");
//	     CURE.setBounds(100, 135, 75, 50);
//		 CURE.setVisible(true);
//		 this.getContentPane().add(CURE);
//		 CURE.addActionListener(this);
//		 
//		 
//		 usespecial=new JButton("USE SPECIAL");
//		 usespecial.setBounds(20,50,155, 75);
//		 usespecial.setVisible(true);
//		 this.getContentPane().add(usespecial);
//		 usespecial.addActionListener(this);
		 Icon y=new ImageIcon("attack.png");
		 attack=new JButton(y);
		 attack.setBounds(20, 135, 85, 50);
		 attack.setVisible(true);
		 this.getContentPane().add(attack);
		 attack.addActionListener(this);
		 
		 Icon z=new ImageIcon("cure.png");
		 CURE=new JButton(z);
	     CURE.setBounds(100, 135, 75, 50);
		 CURE.setVisible(true);
		 this.getContentPane().add(CURE);
		 CURE.addActionListener(this);
		 
		 Icon w=new ImageIcon("use.png");
		 usespecial=new JButton(w);
		 usespecial.setBounds(20,50,160, 75);
		 usespecial.setVisible(true);
		 this.getContentPane().add(usespecial);
		 usespecial.addActionListener(this);
	   
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

	
	
	
	
//public static ArrayList <JLabel> dis(ArrayList<Hero> a) {
//	ArrayList<JLabel> p=new ArrayList<JLabel>();
//	for(int i=1;i<=a.size();i++) {
//		JLabel x=new JLabel("Actions Available:"+(Game.heroes.get(i)).getActionsAvailable());
//		x.setFont(new Font("Press Gothic", Font.BOLD, 14));
//        x.setForeground(Color.WHITE);
//       x.setBounds(1200, i*25, 200, 200);
//      //  x.setVisible(true);
//        p.add(x);
//          
//        
//        
//        JLabel xa=new JLabel("Attack damage:"+(Game.heroes.get(i)).getAttackDmg());
//		xa.setForeground(Color.WHITE);
//        xa.setBounds(1200 ,(i*25)+25 ,200, 200);
//        xa.setFont(new Font("Press Gothic", Font.BOLD, 14));
//       // xa.setVisible(true);
//       p.add(xa);
//        
//        
//       JLabel t=new JLabel("Current HP:"+(Game.heroes.get(i)).getCurrentHp());
//       t.setForeground(Color.WHITE);
//       t.setBounds(1200, (i*25)+50, 200, 200);
//       t.setFont(new Font("Press Gothic", Font.BOLD, 14));
//      // t.setVisible(true);
//       p.add(t)
//           ;
//       JLabel k=new JLabel(check((Game.heroes.get(i))));
//        k.setForeground(Color.WHITE);
//       k.setBounds(1200, (i*25)+75, 200, 200);
//        k.setFont(new Font("Press Gothic", Font.BOLD, 14));
//      //  k.setVisible(true);
//       p .add(k);
//        
//        
//        
//        
//       JLabel  ddd=new JLabel("Vaccines:"+(Game.heroes.get(i).getVaccineInventory().size()));
//        ddd.setForeground(Color.WHITE);
//       ddd.setBounds(20, (i*25)+100, 200, 200);
//        ddd.setFont(new Font("Press Gothic", Font.BOLD, 14));
//      //  ddd.setVisible(true);
//       p.add(ddd);
//        
        
        
        
//        JLabel s=new JLabel("Supplies:"+((Game.heroes.get(i)).getSupplyInventory().size()));
//        s.setForeground(Color.WHITE);
//        s.setBounds(1200, (i*25)+125 ,200, 200);
//        s.setFont(new Font("Press Gothic", Font.BOLD, 14));
//       // s.setVisible(true);
//      p.add(s);
//        
//        
//        
//          JLabel n=new JLabel("Name: "+((Game.heroes.get(i).getName())));
//        n.setForeground(Color.WHITE);
//        n.setBounds(1200, (i*25)+150, 200, 200);
//        n.setFont(new Font("Press Gothic", Font.BOLD, 14));
//        //n.setVisible(true);
//        p.add(n);
//        
//       
//        
//      
//		
//	}
//	return p;
//}

}
