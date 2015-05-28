package gameOfWar.affichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class ac extends JPanel implements ActionListener {

  Fenetre test;
  JPanel optionJPanel = new Option();
  //JPanel menu = new Menu();
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Play")) {
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
    } else if (e.getActionCommand().equals("Jeu")) {
      JOptionPane.showMessageDialog(null, "Banane !");
    } else if (e.getActionCommand().equals("Parametre")) {
      JOptionPane.showMessageDialog(null, "Noisette !");
    } else if (e.getActionCommand().equals("Option")) {
      JOptionPane.showMessageDialog(null, "Henri !");
      new Fenetre("Game of War.", optionJPanel);
    } else if (e.getActionCommand().equals("X")) {
      int retour = JOptionPane.showConfirmDialog(null, "Quitter ?");
      if (retour == JOptionPane.OK_OPTION) {
        System.exit(0);
      } else if (retour == JOptionPane.NO_OPTION) {
        JOptionPane.showMessageDialog(null, "Fait pas de connerie Billy !");
      } else {
        JOptionPane.showMessageDialog(null, "OUF !");
      }
    }

  }

}
