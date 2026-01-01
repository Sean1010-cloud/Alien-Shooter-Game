package culminatingAssignment;
// Sean Lee-Wah
// 12/21/2023
// Puts game together using other classes 
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Screen extends JPanel implements KeyListener, Runnable{

	Thread thread; // thread to run the game 
	PlayerShip playership; // creates image of player ship 
	Image background, missile; // creates image for background and missile
	int ship_x = 150; // starting x position of player ship 
	int ship_y = 400; // starting y position of player ship
	int shipSpeed = 5; // speed at which player ship moves 
	int missile_x; // x position for missile 
	int missile_y = 375; // y position for missile 
	int missileSpeed = 10; // speed at which missiles move
	public int points; // records number of points that the user gets 
	private int lives = 3; // user starts with 3 lives 
	boolean left, right, up, down, missileUp, visible; // allows movement for player ship and missile, as well as visibility for missile and other images
	// creates the starting positions of all the enemy ships
	private final int [][] position = {{20, -1000}, {80, -1000}, {140, -1000}, {200, -1000}, {260, -1000}, {50, -910}, {110, -910}, {170, -910}, {230, -910}, {20, -850}, {80, -850}, {140, -850}, {200, -850}, {260, -850},{50, -700}, {110, -700}, {170, -700}, {230, -700}, {50, -200}, {110, -200}, {170, -200}, {230, -200}, {20, -150}, {80, -150}, {140, -150}, {200, -150}, {260, -150}, {50, -100}, {110, -100}, {170, -100}, {230, -100}}; // x and y positions of enemy ships
	ArrayList<EnemyShip> enemies; // creates list to store enemies 
	ArrayList<PlayerShip> pship; // list that stores player ship 
	ArrayList<Missile> missiles; // arraylist that stores missiles shot 
	JLabel pointsCount = new JLabel(); // displays current amount of points during game
	JLabel livesCount = new JLabel(); // displays current number of lives during game
	
	public Screen() {
		
		initScreen(); 
		
	}
	
	// Purpose: sets up all aspects of games
	// Pre: accesses multiple variables 
	// Post: does things like play background music and draw background  
	private void initScreen() { // init = initialize
		setLayout(null);
		setPreferredSize(new Dimension(550,500));	
		background = Images.starBG; // sets background image to image from images class 
 		visible = true;	// makes everything visible 
		playership = new PlayerShip(ship_x, ship_y); // creates new player ship from PlayerShip class 
		pship = new ArrayList<PlayerShip>(); // creates new arraylist from PlayerShip class 
		missiles = new ArrayList<Missile>(); // creates new arraylist from Missile class
		enemies = new ArrayList<>(); // creates new arraylist to store enemies in 
		pship.add(playership); // adds player ship image to arraylist from PlayerShip class 
		addKeyListener(this); // allows movement for playership and to shoot missiles 
		initEnemy(); // creates enemies in "enemies" ArrayList 
		
		pointsCount.setText("Points: " + points);
		pointsCount.setBounds(5, -5, 100, 100);
		pointsCount.setForeground(Color.WHITE);
		pointsCount.setFont(new Font("Arial", Font.BOLD, 14)); // changes size of text 
		
		livesCount.setText("Lives: " + lives);
		livesCount.setBounds(5, 10, 100, 100);
		livesCount.setForeground(Color.WHITE);
		livesCount.setFont(new Font("Arial", Font.BOLD, 14)); // changes size of text 
		
		add(livesCount);
		add(pointsCount);
		Music.playMusic("C:\\Users\\tiluser\\Desktop\\ICS4U\\Unit6\\culminatingAssignment\\music.wav"); // plays music when program starts
		thread = new Thread(this);
		thread.start(); // runs thread for program
		
		
	}
	// Purpose: add enemies to arraylist 
	// Pre: accesses "enemies" list 
	// Post: all enemies are added to arraylist 
	public void initEnemy() {
		
		for(int [] positions: position) { // for each enemy position in 2D array, creates an instance of enemy ship image 
			enemies.add(new EnemyShip(positions[0], positions[1])); // x and y position of enemy ship
	}
	}
	
	// Purpose: draw images  
	// Pre: accesses visible variable 
	// Post: draws any image that has visible set to true 
	public void paintComponent(Graphics g) {

		if(visible) { // if an image is visible 
			drawObjects(g); // draws it 
			
		}
		
		Toolkit.getDefaultToolkit().sync(); // helps make movement of images smooth
	}
	
	// Purpose: draws images 
	// Pre: accesses multiple variables 
	// Post: draws background, playership, missiles, and enemyships 
	private void drawObjects(Graphics g) {
		// updates images using each method 
		isVisible();

		ifCollision();

		updateMissiles();

		updateEnemies();
		
		
		g.drawImage(background, 0, 0, this); // draws background 
		
		if(playership.isVisible()) {
			g.drawImage(Images.PShip, playership.getX(), playership.getY(), this); // draws player ship 			
		}
		

		List<Missile> mis = missiles; // creates list to store missiles in 
		
			for(Missile missile : mis) { // when a missile is added to the list, it is drawn on the screen 
				if(missile.isVisible()) {
				g.drawImage(Images.missile, missile.getX(), missile.getY(), this);
				}
			}
				if(missile_y < 0) { // when missile reaches the top of the screen 
					missile_y = 1000; // moves missile off of screen so it does not collide with another enemy ship 
					missileUp = false; // stops that missile from moving upward
				}
				
		for(EnemyShip enemy : enemies) { // for each of the enemies in the arraylist, draws each of them 
			if(enemy.isVisible()) {
			g.drawImage(Images.EShip, enemy.getX(), enemy.getY(), this);
			enemy.move(); // moves the enemy ships downward 
 			}
		}
			}

		// Purpose: adds missile to list  
		// Pre: accesses missiles list 
		// Post: adds new missile to list when method is called 
		public void shoot() {
		
		List<Missile> mis = missiles; // creates new list based on missiles list 
		
		for(int i = 0; i < mis.size(); i++) { 

				mis.remove(i); // removes any previous missiles that were shot before a new one is shot 
			}
        missiles.add(new Missile(missile_x, missile_y)); // creates new missile 
    }
		// Purpose: draws after player wins game  
		// Pre: creates new JLabels 
		// Post: displays that player won, number of lives left, and number of points accumilated  
		public void drawGameWin() { // screen is drawn when user destroys all enemy ships
			JLabel win = new JLabel("You Win!");
			JLabel numLives = new JLabel("Lives left: " + lives);
			JLabel numPoints = new JLabel("Points: " + points);
			setLayout(null); // keeps JLabels in same position if screen is minimized 
			win.setBounds(125, 150, 100, 100);
			numLives.setBounds(117, 170, 100, 100);
			numPoints.setBounds(115, 200, 100, 100);
			win.setForeground(Color.WHITE);
			win.setFont(new Font("Arial", Font.BOLD, 15));
			numLives.setForeground(Color.WHITE);
			numLives.setFont(new Font("Arial", Font.BOLD, 15));
			numPoints.setForeground(Color.WHITE);
			numPoints.setFont(new Font("Arial", Font.BOLD, 15));
			add(win);
			add(numLives);
			add(numPoints);
			setVisible(true);
			pointsCount.setText("");
			livesCount.setText("");
		}
		// Purpose: draws after player loses game  
		// Pre: creates new JLabels 
		// Post: displays that player lost, number of lives left, and number of points accumilated
		public void drawGameLoss() { // screen is drawn when user loses all lives 
			JLabel loss = new JLabel("You Lost");
			JLabel numLives = new JLabel("Lives left: " + lives);
			JLabel numPoints = new JLabel("Points: " + points); 
			setLayout(null); 
			loss.setBounds(128, 150, 100, 100);
			numLives.setBounds(122, 170, 100, 100);
			numPoints.setBounds(119, 200, 100, 100);
			loss.setForeground(Color.WHITE);
			loss.setFont(new Font("Arial", Font.BOLD, 15));
			numLives.setForeground(Color.WHITE);
			numLives.setFont(new Font("Arial", Font.BOLD, 15));
			numPoints.setForeground(Color.WHITE);
			numPoints.setFont(new Font("Arial", Font.BOLD, 15));
			add(loss);
			add(numLives);
			add(numPoints);
			setVisible(true);
			pointsCount.setText("");
			livesCount.setText("");
		}
			// Purpose: updates missiles list when called 
			// Pre: accesses missiles list 
			// Post: creates new missile and adds it to the missiles list  
			private void updateMissiles() {
			
				List<Missile> mis = missiles;
				
				for(int i = 0; i < mis.size(); i++) { // for each missile found in arraylist 
					
					Missile m = mis.get(i);
					
					if(m.isVisible()) {
						m.move(); // moves the missile if it is set to visible (has not collided with a ship or has not reached the top of the screen)
					}
					else {
						mis.remove(i); // if the missile is invisible, remove it from the arraylist 
					}
			}
			}
		
			// Purpose: move visible enemies and check if all enemies have been destroyed 
			// Pre: accesses multiple variables 
			// Post: moves visible enemies, removes invisible enemeies, and draws game win/loss based on all enemyships status 
			private void updateEnemies() {
			
				if(enemies.isEmpty() && lives == 0) { // if all enemy ships are destroyed at same time player loses all lives 
					playership.setVisible(false); 
					playership.x = 5000;
					drawGameLoss();
					return;
				}
				if(enemies.isEmpty()) { // if all enemy ships are destroyed 
					playership.setVisible(false); 
					playership.x = 5000;
					drawGameWin();
					return;
				}
				
				for(int i = 0; i < enemies.size(); i++) { // for each enemy ship found in arraylist 
					
					EnemyShip e = enemies.get(i);
					
					if(e.isVisible()) {
						e.move(); // moves them if they are visible (has not been hit by missile or playership)
				}	
					else {
						enemies.remove(i); // removes them if they are invisible 
					}
					}
				}

			// Purpose: checks collisions between certain images 
			// Pre: accesses multiple variables 
			// Post: makes changes if playership collides with enemyship or if missile collides with enemyship
			public void ifCollision() {
				// collision between playership and enemyship 
				Rectangle r = new Rectangle(playership.getX(), playership.getY(), 40, 40); // creates rectangle around player ship  
				
				for(EnemyShip enemy: enemies) { // for each of the enemies found in the arraylist 
				
					Rectangle r1 = new Rectangle(enemy.getX() - 5, enemy.getY(), 30, 50); // creates rectangle around each enemy ship 
				
					if(r.intersects(r1) || r1.intersects(r)) { // if player ship intersects with any enemy ship 
					
						enemy.setVisible(false); // enemy turns invisible 
						lives = lives - 1; // live is lost 
						livesCount.setText("Lives: " + lives); // updates number of lives 
						
						if(lives == 0) { // if user loses all lives 
							playership.setVisible(false);
							playership.x = 5000; // move playership out of screen
							drawGameLoss();
							
							for(int i = 0; i < enemies.size(); i++) { // for each enemy left in arraylist
								
								EnemyShip e = enemies.get(i);
								
								if(e.isVisible()) {
									e.x = 4000; // moves all enemy ships out of screen 
							}
							}
						}
				}
				}
				// collision between missile and enemyship 
				for(Missile missile : missiles) { // for each missile in the arraylist 
					
					Rectangle r2 = new Rectangle(missile.getX(), missile.getY(), 20, 50); // creates rectangle around each missile 
	
					
					for(EnemyShip enemy: enemies) { // for each enemy ship in the arraylist 
					
						Rectangle r3 = new Rectangle(enemy.getX() - 5, enemy.getY(), 30, 50); // creates rectangle around each enemy ship 
						
						if(r2.intersects(r3) || r3.intersects(r2)) { // if a missile intersects an enemy ship

							enemy.y = 1100; // moves enemy out of screen 
							missile.setVisible(false); // missile visibility set to false 
							enemy.setVisible(false); // enemy visibility set to false 
							points += 300; // adds points
							pointsCount.setText("Points: " + points); // updates amount of points
						}
					}
					}
				}
			
			
			@Override
			// Purpose: allows movement for playership and missiles   
			// Pre: accesses multiple variables 
			// Post: moves playership based on keys pressed (e.g. left key moves playership left) and moves missiles when shot 
			public void run() {
				Thread CThread = Thread.currentThread(); // allows movement of playership in another task without interrupting main code
				while(thread == CThread) {
					
					if(left && !right) { // when left arrow key is pressed 
						playership.x -= shipSpeed; // moves player ship to the left 
					}
					if(right && !left) { // when right arrow key is pressed 
						playership.x += shipSpeed; // moves player ship to the right
					}
					if(up && !down) { // when up arrow key is pressed 
						playership.y -= shipSpeed; // moves player ship to the left 
					}
					if(down && !up) { // when down arrow key is pressed 
						playership.y += shipSpeed; // moves player ship to the right
					}
					if(missileUp) {	
						for(Missile missile: missiles) {
							missile.move(); // moves missile upwards 
						}
					}

					repaint(); // repaints images when they are moving 
		            requestFocusInWindow(); // puts immediate focus on playership and missiles, allowing them to move 
		            try { Thread.sleep(50); } // makes thread sleep for certain number of milleseconds, allowing the program to run smoothly and at an appropriate speed 
		            catch (InterruptedException e) {} // try and catch is necessary for Thread.sleep. It makes it so the code will continute running even if the Thread.sleep is interrupted by another thread by throwing the interrupted exception
				}
			}
			
				@Override
				// Purpose: changes directions of playership movement 
				// Pre: accesses multiple variables 
				// Post: sets certain direction to true based on key pressed (e.g. left key sets left to true) 
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_LEFT) { // when left arrow key is pressed
						left = true;
					}
					if(e.getKeyCode() == KeyEvent.VK_RIGHT) { // when right arrow key is pressed
						right = true;
					}
					if(e.getKeyCode() == KeyEvent.VK_UP) { // when up arrow key is pressed
						up = true; 
					}
					if(e.getKeyCode() == KeyEvent.VK_DOWN) { // when down arrow key is pressed
						down = true;	
					}
					if(e.getKeyCode() == KeyEvent.VK_SPACE) { // when spacebar is pressed
						shoot(); // creates new missile 
						for(Missile missile: missiles) {
							missile.y = playership.y; // missile y position is set to playership y position
							missile.x = playership.x; // missile x position is set to playership x position
							missileUp = true;
							if(playership.x < 5000) { // only plays sound effect if game is not over yet 
							MissileShot.SoundEffect("C:\\Users\\tiluser\\Desktop\\ICS4U\\Unit6\\culminatingAssignment\\missileshot.wav");
					}
					}
				}
			}
				@Override
				// Purpose: resets directions of playership movement and keeps playership inside screen 
				// Pre: accesses multiple variables 
				// Post: when any key is released, sets the boolean variable associated with it back to false. Sets playership back to original position if moved outside of screen 
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_LEFT) {
						left = false; // resets left boolean variable 
						if(playership.x < 5) { // keeps playership from moving off screen to the left, moves it back into the screen
							playership.x = 5;
					}
					}

					if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
						right = false; // resets right boolean variable
					if(playership.x > 270 && playership.x < 4000) { // keeps playership from moving off screen to the right, moves it back into the screen
						playership.x = 270;
					}
					}
					
					if(e.getKeyCode() == KeyEvent.VK_UP) {
						up = false; // resets up boolean variable
						if(playership.y < 5) { // keeps playership from moving off screen at the top, moves it back into the screen
							playership.y = 5;
					}
					}
					
					if(e.getKeyCode() == KeyEvent.VK_DOWN) {
						down = false; // resets down boolean variable
					if(playership.y > 400) { // keeps playership from moving off screen at the bottom, moves it back into the screen
						playership.y = 400;
					}
					}
					}
					
			
			@Override
			public void keyTyped(KeyEvent e) {	// despite not being used, must be overrided since keylistener is used		
			}
			
			public static void main(String [] args) {
			JFrame d = new JFrame("Alien Defender");
			d.setSize(350,600);
			d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
			d.setVisible(true);
			}
			}
			
	
			
		
	
