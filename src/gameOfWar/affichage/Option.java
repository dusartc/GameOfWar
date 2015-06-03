package gameOfWar.affichage;

import gameOfWar.affichage.Son;
import gameOfWar.config.Constante;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Option extends JPanel {
  
  private static final long serialVersionUID = 1L;

  private JLabel sousTitre;
  private JLabel tailleDuPlateau;
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
  private Fenetre f;

  public Option(){
    this.setLayout(null);
    this.setPreferredSize(new Dimension(900,600));
    this.setOpaque(false);
    this.initComponent();
  }

  public Option(Fenetre f) {
    this();
    this.setF(f);
  }
  
  public void initComponent() {
    sousTitre = new JLabel("Option");
    sousTitre.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 45));
    sousTitre.setBounds(410, 45, 150,50);
    tailleDuPlateau = new JLabel("Taille du Plateau :");
    tailleDuPlateau.setBounds(180,150,280,50);
    tailleDuPlateau.setForeground(Color.WHITE);
    tailleDuPlateau.setFont(new Font("Deja vu", Font.BOLD, 24));
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
    musicTexte.setBounds(180, 250, 120, 50);
    musicTexte.setForeground(Color.WHITE);
    musicTexte.setFont(new Font("Deja vu", Font.BOLD, 24));
    music = new JButton("Musique");
    music.setBounds(450, 250, 220, 50);
    music.setActionCommand("Play");
    music.addActionListener(new ac());
    sonText = new JLabel("Son :");
    sonText.setBounds(180, 350, 80, 50);
    sonText.setForeground(Color.WHITE);
    sonText.setFont(new Font("Deja vu", Font.BOLD, 24));
    son = new JButton("Son");
    son.setBounds(450, 350, 220, 50);
    son.setActionCommand("Son");
    son.addActionListener(new ac());
    pourcentageObstacles = new JLabel("Pourcentage d'obstacles :");
    pourcentageObstacles.setBounds(180,450,320,50);
    pourcentageObstacles.setForeground(Color.WHITE);
    pourcentageObstacles.setFont(new Font("Deja vu", Font.BOLD, 24));
    valeurObstacles = new JTextField(Constante.OBSTACLES_CHOICE + "");
    valeurObstacles.setBounds(530, 449, 50, 50);
    retour = new Bouton();
    retour.setBounds(750, 500,50,50);
    try {
      File fond = new File("ressources/Images/retour.png");
      Image img = ImageIO.read(fond);
      retour.setIcon(new ImageIcon(img));
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    retour.setActionCommand("Retour");
    retour.addActionListener(new ac(this, valeurX, valeurY, valeurObstacles));

    this.add(sousTitre);
    this.add(tailleDuPlateau);
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

  /*private void getJpanel(GridBagConstraints constraints, int x, int y, int fill, int insetsTop,
      int gridx, int gridy) {

      retour.setPreferredSize(new Dimension(120, 100));
      toutLesPanel.add(retour);
      retour.setActionCommand("Retour");
      retour.addActionListener(new ac());/*new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          b3ActionPerformed(evt);
        }
      });
  }

  /*private void b3ActionPerformed(ActionEvent evt) {
    String s = "";

    try {
      Constante.X_CHOICE = Integer.parseInt(tx.getText());
      Constante.Y_CHOICE = Integer.parseInt(ty.getText());
      Constante.OBSTACLES_CHOICE = Integer.parseInt(ob.getText());

      if (Constante.X_CHOICE > Constante.X_MAX || Constante.X_CHOICE < Constante.X_MIN
          || Constante.Y_CHOICE > Constante.Y_MAX || Constante.Y_CHOICE < Constante.Y_MIN) {
        s =
            s + "La taille du plateau doit etre comprise entre " + Constante.X_MIN + " et "
                + Constante.X_MAX + "\n";
        tx.setText(defx);
        ty.setText(defy);
      }
      if (Constante.OBSTACLES_CHOICE > Constante.OBSTACLES_MAX
          || Constante.OBSTACLES_CHOICE < Constante.OBSTACLES_MIN) {
        s =
            s + "Le pourcentage d'obstacles doit etre compris entre " + Constante.OBSTACLES_MIN
                + " et " + Constante.OBSTACLES_MAX;
        ob.setText(defob);
      }
      if (s.equals("")) {
        JOptionPane.showMessageDialog(null, "Retour au menu principal !");
      } else {
        JOptionPane.showMessageDialog(null, s);
      }

    } catch (Exception e) {
      tx.setText(defx);
      ty.setText(defy);
      ob.setText(defob);
      JOptionPane.showMessageDialog(null, "Champ Incorrect");
    }
    this.initilisationPlateau();
    
  }*/

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D graphics2d = (Graphics2D)g;
    GradientPaint gradientPaint = new GradientPaint(0, -(180), new Color(80, 80, 80), 0, 90, new Color(40, 40, 40), true);
    graphics2d.setPaint(gradientPaint);
    graphics2d.fillRoundRect(100, 30, 740, 550, 20, 20);
    GradientPaint gradientPaint2 = new GradientPaint(0, 0, new Color(0xFF, 0xFF, 0xFF), 0, 90,  new Color(110, 110, 110), true);
    graphics2d.setPaint(gradientPaint2);
    graphics2d.fillRoundRect(100, 30, 740, 80, 20, 20);
  }

  public Fenetre getF() {
    return f;
  }

  public void setF(Fenetre f) {
    this.f = f;
  }
}
