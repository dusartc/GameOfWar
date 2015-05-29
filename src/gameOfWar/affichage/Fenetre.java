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
import javax.swing.JPanel;

public class Fenetre {


  private static final long serialVersionUID = 1L;
  
  private static JFrame jFrame = new JFrame();
  protected JPanel menu = new Menu();
  protected JPanel option = new Option(); 

  public Fenetre(String nom, JPanel jPanel){
   testFenetre(nom, jPanel);
  }
  
  public Fenetre(){
    Fenetre.testFenetre("Game of War.", menu);
  }
  
  public static void testFenetre(String nom, JPanel jPanel){
    jFrame.setTitle(nom);
    jFrame.setPreferredSize(new Dimension(1024, 720));
    jFrame.pack();
    /*try {
      Son.jouer();
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception1) {
      // TODO Auto-generated catch block
      exception1.printStackTrace();
    }*/
    jFrame.setResizable(false);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setLocationRelativeTo(null);
    jFrame.setContentPane(new Fond());
    Fenetre.afficheLabelTitre("Game of War");
    if (jPanel instanceof Menu) {
      JButton music = new Bouton();
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
      jFrame.getContentPane().add(music);
      JButton quitter = new Bouton();
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
      jFrame.getContentPane().add(quitter);
    }
    jFrame.setLayout(null);
    Fenetre.changePanel(jPanel);
    jFrame.setVisible(true);
  }
  
  public static void changePanel(JPanel jPanel){
    jFrame.getContentPane().add(jPanel);
    jPanel.setBounds(0, 75, jFrame.getWidth(), jFrame.getHeight());
    jFrame.dispose();
    jFrame.revalidate();
    jFrame.repaint();
    jFrame.setVisible(true);
  }
  
  public static JFrame getJFrame(){
    return jFrame;
  }
  
  public static void afficheLabelTitre(String titre) {
    JLabel gameOfWar = new JLabel(titre);
    gameOfWar.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 52));
    gameOfWar.setBounds(380, 5, 500, 80);
    jFrame.getContentPane().add(gameOfWar);
  }

}
