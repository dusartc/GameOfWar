package gameOfWar.affichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class MusiquePlayer implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {

    int retour = JOptionPane.showConfirmDialog(null, "Jouer la musique ?");
    if (retour == JOptionPane.OK_OPTION) {
      try {
        Son.jouer();
      } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
        e1.printStackTrace();
      }
    } else if (retour == JOptionPane.NO_OPTION) {
      try {
        Son.arreter();
      } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
        exception.printStackTrace();
      }
    } else {
      JOptionPane.showMessageDialog(null, "Chocolat !");
    }
  }

}
