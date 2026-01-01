package culminatingAssignment;
// Sean Lee-Wah
// 1/3/2024
// Plays music for game 
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Music {

	// Purpose: plays background music   
	// Pre: takes audio file from device 
	// Post: outputs audio of background music while game is going 
	public static void playMusic(String location) {
		
		try 
		{
			
			File musicPath = new File(location); // creates new file given the location of the file 
			
			if(musicPath.exists()) { // runs if file is found
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath); // obtains the audio file 
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput); // takes the audio from the given file 
				clip.loop(20); // loops music so it does not stop in middle of game 
				clip.start(); // plays the background music 
			}
		}
		catch(Exception e){
			System.out.println("Error"); // catches error and outputs it to console to notify 
	}
	}
}

