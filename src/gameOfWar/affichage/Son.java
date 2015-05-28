package gameOfWar.affichage;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Son extends Thread {

	private static Clip clip;
	private static boolean joue;
	private static AudioInputStream audioln;
	private static File song;
	private static int lancement = 0;

	public static void load() {
		song = new File("src/gameOfWar/jeux/Sons/Test.wav");
		try {
			audioln = AudioSystem.getAudioInputStream(song);
			clip = AudioSystem.getClip();
		} catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e) {
			e.printStackTrace();
		}

	}

	public static void jouer() throws UnsupportedAudioFileException,
			IOException, LineUnavailableException {
	      load();
		if (!joue) {
			clip.open(audioln);
			clip.start();
			joue = true;
		} else {
			JOptionPane.showMessageDialog(null,
					"Une musique est deja en cours !");
		}
	}

	public static void arreter() throws UnsupportedAudioFileException,
			IOException, LineUnavailableException {
		if (joue) {
			clip.close();
			clip.stop();
			joue = false;
		} else {
			JOptionPane.showMessageDialog(null, "Rien est en cours !");
		}
	}

}
