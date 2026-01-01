package culminatingAssignment;
// Sean Lee-Wah
// 1/3/2024
// Plays sound effect for missile being shot 
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MissileShot {

	// Purpose: plays missile sound effect  
	// Pre: takes audio file from device 
	// Post: outputs audio of missile when one is shot 
	public static void SoundEffect(String location) {
		
		try 
		{
			
			File musicPath = new File(location); // creates new file given the location of the file 
			
			if(musicPath.exists()) { // runs if file is found 
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath); // obtains the audio file 
				Clip clip = AudioSystem.getClip(); 
				clip.open(audioInput); // takes the audio from the given file 
				clip.start(); // plays the sound effect 
			}
		}
		catch(Exception e){
			System.out.println("Error"); // catches error and outputs it to console to notify 
	}
	}
}

