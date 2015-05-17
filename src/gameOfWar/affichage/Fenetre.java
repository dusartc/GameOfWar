package gameOfWar.affichage;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fenetre extends JFrame {


  private static final long serialVersionUID = 1L;

  public Fenetre(String nom) throws UnsupportedAudioFileException, IOException,
      LineUnavailableException {
    this.setTitle(nom);
    this.setPreferredSize(new Dimension(1024, 720));
    this.pack();
    Son.jouer();
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setContentPane(new Fond());
    this.afficheLabelTitre("Game of War");
    JButton music = new Bouton("Play", 900, 20);
    try {
      File fond = new File("src/gameOfWar/jeux/Images/music.gif");
      Image img = ImageIO.read(fond);
      music.setIcon(new ImageIcon(img));
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    music.setPreferredSize(new Dimension(17, 16));
    music.setActionCommand("Play");
    music.addActionListener(new ac());
    this.getContentPane().add(music);
    JButton quitter = new Bouton("X", 920, 20);
    try {
      File fond = new File("src/gameOfWar/jeux/Images/quitter.png");
      Image img = ImageIO.read(fond);
      quitter.setIcon(new ImageIcon(img));
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    quitter.setPreferredSize(new Dimension(48, 48));
    quitter.setActionCommand("X");
    quitter.addActionListener(new ac());
    this.getContentPane().add(quitter);
    this.add(new Menu());
    this.setVisible(true);
  }

  public void afficheLabelTitre(String titre) {
    JLabel gameOfWar = new JLabel(titre);
    gameOfWar.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 52));
    gameOfWar.setLocation(160, 45);
    this.getContentPane().add(gameOfWar);
  }


}
