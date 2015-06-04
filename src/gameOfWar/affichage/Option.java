package gameOfWar.affichage;

import gameOfWar.config.Constante;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Option extends JPanel {

  private static final long serialVersionUID = 1L;

  private JLabel sousTitre;
  private JLabel tailleDuPlateau;
  private JLabel nombreRobot;
  private JTextField valeurNombreRobo;
  private JLabel X;
  private JLabel Y;
  private JTextField valeurX;
  private JTextField valeurY;
  private JLabel musicTexte;
  private JButton music;
  private JLabel sonText;
  private JButton son;
  private JLabel pourcentageObstacles;
  private JTextField valeurObstacles;
  private JButton retour = new Bouton("Retour");
  protected Fenetre f;
  protected Map<String, Integer> option;

  public Option() {
    this.setLayout(null);
    this.setPreferredSize(new Dimension(900, 600));
    this.setOpaque(false);
    this.setLocation(60, 77);
    this.initComponent();
  }

  public Option(Fenetre f) {
    // this();
    this.option = new HashMap<String, Integer>();
    this.option.put("x", 10);
    this.option.put("y", 10);
    this.option.put("o", 10);
    this.setF(f);
    this.setLayout(null);
    this.setPreferredSize(new Dimension(900, 600));
    this.setOpaque(false);
    this.setLocation(60, 77);
    this.initComponent();
  }

  private void initComponent() {
    sousTitre = new JLabel("Option");
    sousTitre.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 45));
    sousTitre.setBounds(410, 45, 190, 50);
    tailleDuPlateau = new JLabel("Taille du Plateau :");
    tailleDuPlateau.setBounds(180, 150, 280, 50);
    tailleDuPlateau.setForeground(Color.WHITE);
    tailleDuPlateau.setFont(new Font("Deja vu", Font.BOLD, 24));
    nombreRobot = new JLabel("Nombre de robot :");
    nombreRobot.setBounds(180, 225, 280, 50);
    nombreRobot.setForeground(Color.WHITE);
    nombreRobot.setFont(new Font("Deja vu", Font.BOLD, 24));
    valeurNombreRobo = new JTextField(5);
    valeurNombreRobo.setBounds(530, 225, 50, 50);
    X = new JLabel("X");
    X.setBounds(493, 110, 40, 40);
    X.setForeground(Color.WHITE);
    X.setFont(new Font("Deja vu", Font.BOLD, 24));
    valeurX = new JTextField(Constante.X_CHOICE + "");
    valeurX.setBounds(480, 149, 50, 50);
    Y = new JLabel("Y");
    Y.setBounds(593, 110, 40, 40);
    Y.setForeground(Color.WHITE);
    Y.setFont(new Font("Deja vu", Font.BOLD, 24));
    valeurY = new JTextField(Constante.Y_CHOICE + "");
    valeurY.setBounds(580, 149, 50, 50);
    musicTexte = new JLabel("Musique :");
    musicTexte.setBounds(180, 300, 190, 50);
    musicTexte.setForeground(Color.WHITE);
    musicTexte.setFont(new Font("Deja vu", Font.BOLD, 24));
    music = new JButton("Musique");
    music.setBounds(450, 300, 220, 50);
    music.addActionListener(new MusiquePlayer());
    sonText = new JLabel("Son :");
    sonText.setBounds(180, 375, 80, 50);
    sonText.setForeground(Color.WHITE);
    sonText.setFont(new Font("Deja vu", Font.BOLD, 24));
    son = new JButton("Son");
    son.setBounds(450, 375, 220, 50);
    son.setActionCommand("Son");
    son.addActionListener(new ac(f));
    pourcentageObstacles = new JLabel("Pourcentage d'obstacles :");
    pourcentageObstacles.setBounds(180, 450, 320, 50);
    pourcentageObstacles.setForeground(Color.WHITE);
    pourcentageObstacles.setFont(new Font("Deja vu", Font.BOLD, 24));
    valeurObstacles = new JTextField(Constante.OBSTACLES_CHOICE + "");
    valeurObstacles.setBounds(530, 449, 50, 50);
    retour = new JButton();
    retour.setBounds(750, 500, 50, 50);
    try {
      File fond = new File("ressources/Images/retour.png");
      Image img = ImageIO.read(fond);
      retour.setIcon(new ImageIcon(img));
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    retour.setActionCommand("Retour");
    retour.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        option.clear();
        option.put("x", Integer.parseInt(valeurX.getText()));
        option.put("y", Integer.parseInt(valeurY.getText()));
        option.put("o", Integer.parseInt(valeurObstacles.getText()));
        f.showMenu();
      }
    });

    this.add(sousTitre);
    this.add(tailleDuPlateau);
    this.add(nombreRobot);
    this.add(valeurNombreRobo);
    this.add(X);
    this.add(valeurX);
    this.add(Y);
    this.add(valeurY);
    this.add(musicTexte);
    this.add(music);
    this.add(sonText);
    this.add(son);
    this.add(pourcentageObstacles);
    this.add(valeurObstacles);
    this.add(retour);
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

  public Fenetre getF() {
    return f;
  }

  public void setF(Fenetre f) {
    this.f = f;
  }
  
  public Map<String, Integer> getOption(){
    return this.option;
  }
}
