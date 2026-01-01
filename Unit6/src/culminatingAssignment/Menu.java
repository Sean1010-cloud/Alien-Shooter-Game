package culminatingAssignment;
// Sean Lee-Wah
// 12/30/2023
// Draws menu screen 
import javax.swing.JButton;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;


public class Menu extends JPanel implements ActionListener{

	JButton start = new JButton("Start");
	JButton instructions = new JButton("Instructions");
	JLabel title = new JLabel("Alien Defender");
	Image background;
	
	public Menu() {
		  super();
		  background = Images.starBG; // sets background to star image from images class 
		  setSize(600,500);
		  setLayout(null);
	  
		  title.setBounds(68, 40, 300, 100);
		  title.setForeground(Color.WHITE);
		  title.setFont(new Font("Serif", Font.BOLD, 30));
		  add(title);
		  start.addActionListener(this);
		  instructions.addActionListener(this);
		  add(start);
		  start.setBounds(105, 190, 120, 40);
		  add(instructions);
		  instructions.setBounds(105, 240, 120, 40);
		  setVisible(true);
	}

	@Override
	// Purpose: checks if start or instructions button is clicked 
    // Pre: accesses start and instructions button
 	// Post: when start button is clicked, game runs. When instructions button is clicked, navigates to instructions screen 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start) { // start button is clicked 
			Main.Panel.add(new Screen(), "Game"); // add new screen class 
			Main.Layout.show(Main.Panel, "Game"); // make screen class visible 
		}
		if(e.getSource() == instructions) { // instructions button is clicked 
			Main.Layout.show(Main.Panel, "Instructions"); // make instructions class visible
		}
	}
	 // Purpose: displays background 
     // Pre: accesses background variable 
 	 // Post: draws background over screen 
	 public void paintComponent(Graphics g) {
		 g.drawImage(background, 0, 0, this); // draws background 
	}
}
