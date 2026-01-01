package culminatingAssignment;
// Sean Lee-Wah
// 12/31/2024
// Sets up window for game and draws main screen with instructions and menu 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.CardLayout;

import javax.swing.*;


public class Main{
	
		public static final CardLayout Layout = new CardLayout(); // creates new CardLayout
		public static JPanel Panel;
	
	public static void main(String [] args) {
		JFrame frame = new JFrame("Menu");
		frame.setLayout(new BorderLayout());
		frame.setSize(350, 500);
		
		frame.setTitle("Alien Defender");
		frame.setLocationRelativeTo(null); // game window pops up in middle of screen
		frame.setResizable(false); // game cannot be resized 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel = new JPanel(Layout); // creates panel for card layout 
        Panel.add(new Menu(), "Menu"); // add new menu class 
        Panel.add(new Instructions(), "Instructions"); // add new instructions class 
        frame.add(Panel); 

        Layout.show(Panel, "Menu"); // makes menu class visible 
        frame.setVisible(true); 
	}
	}
	

