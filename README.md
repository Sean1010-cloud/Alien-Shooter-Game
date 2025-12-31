# Alien-Shooter
A remake of a typical alien shooter game where the player fires projectiles at enemy ships. This project was built for an assignment, but allowed me to learn a lot. The entire project was made using Java.


# Features 
- Control the player ship: You can move up, down, left, and right without exiting the screen.
- Press the spacebar to shoot missiles upwards towards spawning enemy ships.
- Earn points when an enemy ship is successfully destroyed
- Lose a life if an enemy ship collides with your ship (from total of 3 lives)

# Process 
I started by creating the individual classes for each of the different objects. They included things like the player ship, enemy ship, missiles, background, etc. Each of the classes contained constructors to create each individual piece, as well as methods for their movement and uploading the image for them. 

I then created the screen class that would contain the layout of the game. In this class, I created things like the background, the player ship,  each of the enemy ships, and a scoring system for each enemy ship destroyed. I also included a menu that appears when the class is run, which uses ActionListener to function. One of the buttons there was the instructions, where each of the objects and their purpose were outlined to the player. The other button was the play button, which ran the game when clicked. After the game was completed (player destroys all ships or loses all lives), the game stops and the score that the player achiveved is displayed on the screen. 

I then created another class that used the screen class to run the game with music in the background.

# What I Learned
I learned a lot during this project, which further developed my Java skills and overall programming logic. 

# ActionListener and EventListener 
I found out about the user of ActionListener and EventListener imports, which allowed me to code the game based on inputs from the user.

# JFrame 
I learned how to use JFrame to create the layout for the window where the game appeared, as well as positioning the different objects on the screen.

# Image Creation
I learned how to add images from my files to be used by the Java software, to be included in the game.

# Overall Growth
Every part of this project allowed me to improve my coding skills. I was able to learn new imports like ActionListener, using JFrame, etc. I came across many issues in this project, and making changes followed by testing allowed me to develop my problem solving skills. These improvements will allow me to make fewer mistakes in future works.

# Improvements
- Create a boss at the end
- Have multiple types of enemies
- Add more ablilites for the player
- Make collision detection more accurate
- Add individual directional movement for enemy ships
  
