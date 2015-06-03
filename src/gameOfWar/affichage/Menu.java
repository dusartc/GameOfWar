package gameOfWar.affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {

  private static final long serialVersionUID = 1L;

  private JLabel sousTitre;
  private JButton music;
  private JButton quitter;
  private JButton jeu;
  private JButton parametre;
  private JButton option;
  private Fenetre f;

  public Menu() {
    this.setLayout(null);
    this.setPreferredSize(new Dimension(900, 600));
    this.setOpaque(false);
    this.initComponent();
  }

  public Menu(Fenetre f) {
    // this();
    this.setF(f);
    this.setLayout(null);
    this.setPreferredSize(new Dimension(900, 600));
    this.setOpaque(false);
    this.setLocation(60, 77);
    this.initComponent();
  }

  public void initComponent() {
    sousTitre = new JLabel("Menu");
    sousTitre.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 45));
    sousTitre.setBounds(410, 45, 150, 50);
    music = new Bouton();
    music.setBounds(770, 60, 20, 20);
    try {
      File fond = new File("ressources/Images/music.gif");
      Image img = ImageIO.read(fond);
      music.setIcon(new ImageIcon(img));
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    music.addActionListener(new MusiquePlayer());
    quitter = new Bouton();
    quitter.setBounds(750, 500, 48, 48);
    try {
      File fond = new File("ressources/Images/quitter.png");
      Image img = ImageIO.read(fond);
      quitter.setIcon(new ImageIcon(img));
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    quitter.addActionListener(new Quitter());
    jeu = new JButton("Jeu");
    jeu.setBounds(350, 150, 250, 100);
    jeu.setActionCommand("Jeu");
    jeu.addActionListener(new ac(f));
    parametre = new JButton("Parametre");
    parametre.setBounds(350, 300, 250, 100);
    parametre.setActionCommand("Parametre");
    parametre.addActionListener(new ac(f));
    option = new JButton("Option");
    option.setBounds(350, 450, 250, 100);
    option.setActionCommand("Option");
    option.addActionListener(new ac(f));

    this.add(sousTitre);
    this.add(music);
    this.add(quitter);
    this.add(jeu);
    this.add(parametre);
    this.add(option);
  }

  public Fenetre getF() {
    return f;
  }

  public void setF(Fenetre f) {
    this.f = f;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D graphics2d = (Graphics2D) g;
    GradientPaint gradientPaint =
        new GradientPaint(0, -(180), new Color(80, 80, 80), 0, 90, new Color(40, 40, 40), true);
    graphics2d.setPaint(gradientPaint);
    graphics2d.fillRoundRect(100, 30, 740, 550, 20, 20);
    GradientPaint gradientPaint2 =
        new GradientPaint(0, 0, new Color(0xFF, 0xFF, 0xFF), 0, 90, new Color(110, 110, 110), true);
    graphics2d.setPaint(gradientPaint2);
    graphics2d.fillRoundRect(100, 30, 740, 80, 20, 20);
  }
}
