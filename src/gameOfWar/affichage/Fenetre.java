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
//import javax.swing.JToggleButton;

public class Fenetre extends JFrame {


  private static final long serialVersionUID = 1L;
  
  protected JPanel menu = new Menu();
  protected JPanel option = new Option(); 

  public Fenetre(String nom, JPanel jPanel, boolean visibleOption, boolean visibleMenu){
   testFenetre(nom, jPanel, visibleOption, visibleMenu);
  }
  
  public Fenetre(){
    this.testFenetre("Game of War.", menu, false, true);
  }
  
  public void testFenetre(String nom, JPanel jPanel, boolean visibleOption, boolean visibleMenu){
    this.setTitle(nom);
    this.setPreferredSize(new Dimension(1024, 720));
    this.pack();
    /*try {
      Son.jouer();
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception1) {
      // TODO Auto-generated catch block
      exception1.printStackTrace();
    }*/
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setContentPane(new Fond());
    this.afficheLabelTitre("Game of War");
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
      this.getContentPane().add(music);
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
      this.getContentPane().add(quitter);
    }
    this.setLayout(null);
    //this.changePanel(menu);
    this.changePanel(jPanel);
    //this.changePanel(jPanel, (jPanel instanceof Option)? true : false, (jPanel instanceof Menu)? true : false);
    this.setVisible(true);
  }
  
  /*public void changePanel(JPanel jPanel, boolean visibleOption, boolean visibleMenu){
    this.getContentPane().add(jPanel);
    jPanel.setBounds(0, 75, this.getWidth(), this.getHeight());
    this.dispose();
    this.revalidate();
    jPanel.setVisible(true);
  }*/
  
  public void changePanel(JPanel jPanel){
    this.getContentPane().add(jPanel);
    jPanel.setBounds(0, 75, this.getWidth(), this.getHeight());
    this.dispose();
    this.revalidate();
    jPanel.setVisible(true);
  }
  
  public void afficheLabelTitre(String titre) {
    JLabel gameOfWar = new JLabel(titre);
    gameOfWar.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 52));
    gameOfWar.setBounds(380, 5, 500, 80);
    this.getContentPane().add(gameOfWar);
  }

}
