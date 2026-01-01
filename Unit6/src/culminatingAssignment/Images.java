package culminatingAssignment;
// Sean Lee-Wah
// 12/18/2023
// Adds all files as images into class 
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Images {
	
		// import images and set them to an Image variable with a width and height
		public static Image starBG = loadImage("C:\\Users\\tiluser\\Desktop\\ICS4U\\Unit6\\culminatingAssignment\\stars.jpg", 350, 600);

		public static Image PShip = loadImage("C:\\Users\\tiluser\\Desktop\\ICS4U\\Unit6\\culminatingAssignment\\playership.png", 70, 70);

		public static Image EShip = loadImage("C:\\Users\\tiluser\\Desktop\\ICS4U\\Unit6\\culminatingAssignment\\enemyship.png", 50, 50);

		public static Image missile = loadImage("C:\\Users\\tiluser\\Desktop\\ICS4U\\Unit6\\culminatingAssignment\\missile.png", 50, 50);

		// protected means it can be used in any shared class
	    protected int x; // x coordinate for getting x bounds of image 
	    protected int y; // y coordinate for getting y bounds of image
	    protected int width; // width coordinate for getting width of image 
	    protected int height; // height coordinate for getting height of image 
	    protected boolean visible; // changes visibility of image to true or false 
	    protected Image image; // image varable that can be returned when getImage is called 

	    public Images(int x, int y) {
	        this.x = x;
	        this.y = y;
	        visible = true;
	    }
	    // Purpose: return image when called 
		// Pre: accesses image variable 
		// Post: returns image 
	    public Image getImage() {
	        return image;
	    }

	    // Purpose: return x variable
		// Pre: accesses x variable
		// Post: returns x variable of image
	    public int getX() {
	        return x;
	    }

	    // Purpose: return y variable
		// Pre: accesses y variable
		// Post: returns y variable of image
	    public int getY() {
	        return y;
	    }

	    // Purpose: checks if image is visible or not 
	    // Pre: accesses visible variable 
	 	// Post: returns true or false for visibility
	    public boolean isVisible() {
	        return visible;
	    }
	    // Purpose: changes visibility of image 
	    // Pre: accesses image variable
	 	// Post: sets image visiblity to true or false
	    public void setVisible(Boolean visible) {
	        this.visible = visible;
	    }
	    // Purpose: creates image of file in java 
	    // Pre: accesses location of image file 
	 	// Post: creates image using file name with a set width and height
	    public static Image loadImage(String name, int width, int height) {
			return new ImageIcon(name).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); 
		}
	}


