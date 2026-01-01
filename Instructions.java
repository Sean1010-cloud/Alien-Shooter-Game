package culminatingAssignment;
//Sean Lee-Wah
//1/4/2024
//Shows the instructions screen
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Instructions extends JPanel implements ActionListener{

	JButton back = new JButton("Back"); // button to go back to menu screen 
	JLabel instructions = new JLabel("Instructions"); // shows instructions for game 
	
	// images to be shown in the instructions screen 
	ImageIcon pship = new ImageIcon ("C:\\Users\\tiluser\\Desktop\\ICS4U\\Unit6\\culminatingAssignment\\playership.png"); 
	Image img1 = pship.getImage();   
	Image newimg1 = img1.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH ); 
	ImageIcon pshippic = new ImageIcon(newimg1);
	JLabel pshiplbl = new JLabel(pshippic);	
	
	ImageIcon eship = new ImageIcon ("C:\\Users\\tiluser\\Desktop\\ICS4U\\Unit6\\culminatingAssignment\\enemyship.png"); 
	Image img2 = eship.getImage();   
	Image newimg2 = img2.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH ); 
	ImageIcon eshippic = new ImageIcon(newimg2);
	JLabel eshiplbl = new JLabel(eshippic);
	
	ImageIcon missile = new ImageIcon ("C:\\Users\\tiluser\\Desktop\\ICS4U\\Unit6\\culminatingAssignment\\missile.png"); 
	Image img3 = missile.getImage() ;   
	Image newimg3 = img3.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon missilepic = new ImageIcon(newimg3);
	JLabel missilelbl = new JLabel(missilepic);
	
	
	public Instructions() {
		super();
		setLayout(null);
		back.addActionListener(this);
		back.setBounds(250, 420, 80, 30);
		JLabel pshipt = new JLabel("Ship that player controls");
		JLabel eshipt = new JLabel("Enemies for player to shoot");
		JLabel missilet = new JLabel("Missiles shot using spacebar");
		pshipt.setBounds(80, 150, 500, 100);
		eshipt.setBounds(80, 250, 500, 100);
		missilet.setBounds(80, 350, 500, 100);
		pshiplbl.setBounds(-10, 150, 100, 100);
		eshiplbl.setBounds(-10, 250, 100, 100);
		missilelbl.setBounds(-10, 350, 100, 100);
		add(back);
		add(pshiplbl);
		add(eshiplbl);
		add(missilelbl);
		add(pshipt);
		add(eshipt);
		add(missilet);

		instructions.setText("<html>"
				   + "The objective of the game is to destroy all of the <br>"
				   + "enemy ships with missiles. You can move your <br>"
				   + "ship using the left, right, up, and down arrow keys. <br>"
				   + "Only one missile can be shot at a time and you will <br>"
				   + "get 300 points after destroying an enemy ship. <br>"
				   + "Hitting an enemy ship with your ship will result <br>"
				   + "in a life being lost and will not reward points. <br> " 
				   + "Good luck!"); // using html line break to write instructions 
		
		add(instructions);
		instructions.setBounds(15, -120, 600, 400);
	}
		// Purpose: change screen if back button is clicked   
		// Pre: accesses back button 
 		// Post: goes back to menu screen when back button is clicked
        public void actionPerformed(ActionEvent e) {
        	if(e.getSource() == back) { // if back button is clicked 
        	Main.Layout.show(Main.Panel, "Menu"); // returns to menu 
            }
        }
	}
