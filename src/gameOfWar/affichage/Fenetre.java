package gameOfWar.affichage;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame {


  private static final long serialVersionUID = 1L;
  
  private JPanel menu = new Menu();
  private JPanel option = new Option(); 

  public Fenetre(String nom, JPanel jPanel){
   testFenetre(nom, jPanel);
  }
  
  public Fenetre(){
    this.testFenetre("Game of War.", menu);
  }
  
  public void testFenetre(String nom, JPanel jPanel){
    this.setTitle(nom);
    this.setPreferredSize(new Dimension(1024, 720));
    this.pack();
    //Son.jouer();
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setContentPane(new Fond());
    this.afficheLabelTitre("Game of War");
    if (jPanel instanceof Menu) {
      JButton music = new Bouton();
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
      JButton quitter = new Bouton();
      quitter.setBounds(950,650,48,48);
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
    }
    this.changePanel(jPanel);
  }
  
  public void changePanel(JPanel jPanel){
    this.getContentPane().add(jPanel);
    this.dispose();
    this.revalidate();
    this.setVisible(true);
  }
  
  public void afficheLabelTitre(String titre) {
    JLabel gameOfWar = new JLabel(titre);
    gameOfWar.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 52));
    gameOfWar.setLocation(160, 45);
    this.getContentPane().add(gameOfWar);
  }

}
