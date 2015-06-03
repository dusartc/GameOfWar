package gameOfWar.affichage;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private JLabel sousTitre;
  private JButton music;
  private JButton quitter;
  private JButton jeu;
  private JButton parametre;
  private JButton option;
  private Fenetre f;

  public Menu(Fenetre f) {
    this.setLayout(null);
    this.add(new Forme());
    if (!false) {
      initComponent();
    }
    this.f = f;
  }
  
  public void initComponent(){
    sousTitre = new JLabel("Menu");
    sousTitre.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 45));
    sousTitre.setBounds(150, 0, 150,50);
    music = new Bouton();
    music.setBounds(950, 25, 30, 30);
    try {
      File fond = new File("ressources/Images/music.gif");
      Image img = ImageIO.read(fond);
      music.setIcon(new ImageIcon(img));
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    music.setPreferredSize(new Dimension(17, 16));
    music.setActionCommand("Play");
    music.addActionListener(new ac());
    quitter = new Bouton();
    quitter.setBounds(920,620,60,60);
    try {
      File fond = new File("ressources/Images/quitter.png");
      Image img = ImageIO.read(fond);
      quitter.setIcon(new ImageIcon(img));
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    quitter.setPreferredSize(new Dimension(48, 48));
    quitter.setActionCommand("X");
    quitter.addActionListener(new ac());
    jeu = new JButton("Jeu");
    jeu.setBounds(250,100, 250, 100);
    jeu.setActionCommand("Jeu");
    jeu.addActionListener(new ac());
    parametre = new JButton("Parametre");
    parametre.setBounds(250,350, 250, 100);
    parametre.setActionCommand("JParametre");
    parametre.addActionListener(new ac());
    option = new JButton("Option");
    option.setBounds(250,600, 250, 100);
    option.setActionCommand("Option");
    option.addActionListener(new ac());
    
    this.add(sousTitre);
    this.add(music);
    this.add(quitter);
    this.add(jeu);
  }
}
