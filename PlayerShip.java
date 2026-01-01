package culminatingAssignment;
// Sean Lee-Wah
// 12/19/2023
// Allows playership to be created in other classses
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayerShip extends Images{

 	Image PlayerShip; // creates image for playership 
 	
	public PlayerShip(int x, int y) {
    	super(x, y);
    	
    	PlayerShipImage(); // creates instance of playership when PlayerShip is called 
	}
	
	// Purpose: takes image of playership from images class  
	// Pre: sets variable to image 
	// Post: image of playership can be created using method
	private void PlayerShipImage() {
		PlayerShip = Images.PShip; // image is set to image from images class 
	 
	}
	
	// Purpose: return x variable
	// Pre: accesses x variable
	// Post: returns x variable of playership
	public int getX() {
		return x;
	}
	// Purpose: return y variable
	// Pre: accesses y variable
	// Post: returns y variable of playership
	public int getY() {
		return y;
	}
}

