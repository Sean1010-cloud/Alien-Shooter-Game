package culminatingAssignment;
// Sean Lee-Wah
// 12/24/2023
// Tracks and moves all missiles 
import java.awt.Image;

public class Missile extends Images{

	private final int mSpeed = 10; // speed that missiles move at 
	Image missile; // creates image for missile 
	
	public Missile(int x, int y) {
		super(x, y);
	
	MissileImage(); // creates instance of missile when Missile is called 
	
	}
	// Purpose: takes image of missile from images class  
	// Pre: sets variable to image 
	// Post: images of missile can be created using method
	private void MissileImage() {
		
		missile = Images.missile; // sets missile image to image from images class 
	}
	// Purpose: move each missile automatically 
	// Pre: changes y variable constantly 
	// Post: each missile moves upwards after being shot 
	public void move() {
		y = y - mSpeed; // moves missiles upward 
		
		if(y < 0) {
			visible = false; // removes visibility if missile reaches top of the screen 
		}
	}
	// Purpose: return x variable
	// Pre: accesses x variable
	// Post: returns x variable of missile
	public int getX() {
		return x;
	}
	// Purpose: return y variable
	// Pre: accesses y variable
	// Post: returns y variable of missile
	public int getY() {
		return y;
	}
	}
	
	
