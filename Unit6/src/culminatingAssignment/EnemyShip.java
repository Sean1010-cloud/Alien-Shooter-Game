package culminatingAssignment;
// Sean Lee-Wah
// 12/23/2023
// Tracks all enemyships that are created 
import java.awt.Image;

public class EnemyShip extends Images{

	private final int originalY = 0; // repositions enemyship at top of screen 
	int speed = 1; // speed that enemyships move at
	Image EnemyShip; // creates image of enemy ship 
	
	public EnemyShip(int x, int y) {
		super(x, y);
		
	EnemyImage(); // creates instance of enemyship when EnemyShip is called 

}

	// Purpose: takes image of enemyship from images class  
	// Pre: sets variable to image 
	// Post: images of enemyship can be created using method
	private void EnemyImage() {
	
		EnemyShip = Images.EShip; // sets image as image of enemyship created in images class 
	}
	
	// Purpose: move each enemyship automatically and respawns them 
	// Pre: changes y variable constantly 
	// Post: each enemyship moves downwards and moves back to top of screen after reaching the bottom
	public void move() {
		y += speed; // moves enemy ships downward 

		if(y > 500 && y < 1000) { // if enemyship reaches bottom of screen 
			y = originalY; // moves enemyship back to top of screen
		}
	}
	// Purpose: return x variable
	// Pre: accesses x variable
	// Post: returns x variable of enemyship  
	public int getX() {
		 return x;
	 }
	// Purpose: return y variable
	// Pre: accesses y variable 
	// Post: returns y variable of enemyship 
	 public int getY() {
		 return y;
	 }
	}
	
	