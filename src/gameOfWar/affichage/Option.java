package gameOfWar.affichage;

import gameOfWar.config.Constante;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Option extends JPanel {

  private static final long serialVersionUID = 1L;

  private JLabel sousTitre;
  private JLabel tailleDuPlateau;
  private JLabel nombreRobot;
  private Slider valeurNombreRobo;
  private JLabel X;
  private JLabel Y;
  private Slider valeurX;
  private Slider valeurY;
  private JLabel musicTexte;
  private JButton music;
  private JLabel sonText;
  private JButton son;
  private JLabel pourcentageObstacles;
  private Slider valeurObstacles;
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
    this.option.put("x", 15);
    this.option.put("y", 15);
    this.option.put("o", 15);
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
    valeurNombreRobo = new Slider(1, Constante.NB_MAX_ROBOTS_PAR_EQUIPE, 530, 225, 50, 150);
    valeurNombreRobo.setBounds(480, 185, 150, 150);
    // valeurNombreRobo.setDocument(new JTextFieldLimit(1));
    // valeurNombreRobo.setBounds(530, 225, 50, 50);
    X = new JLabel("X");
    X.setBounds(493, 110, 40, 40);
    X.setForeground(Color.WHITE);
    X.setFont(new Font("Deja vu", Font.BOLD, 24));
    valeurX = new Slider(Constante.Y_MIN, Constante.Y_MAX, 480, 149, 50, 100);
    // valeurX = new Slider(UNDEFINED_CONDITION, ERROR, ALLBITS, ABORT, WIDTH, HEIGHT)
    // valeurX.setDocument(new JTextFieldLimit(2));
    valeurX.setBounds(480, 115, 150, 150);

    Y = new JLabel("Y");
    Y.setBounds(593, 110, 40, 40);
    Y.setForeground(Color.WHITE);
    Y.setFont(new Font("Deja vu", Font.BOLD, 24));
    // valeurY = new JTextField();
    // valeurY.setDocument(new JTextFieldLimit(2));
    // valeurY.setBounds(580, 149, 50, 50);
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
    pourcentageObstacles.setBounds(180, 450, 380, 50);
    pourcentageObstacles.setForeground(Color.WHITE);
    pourcentageObstacles.setFont(new Font("Deja vu", Font.BOLD, 24));
    valeurObstacles =
        new Slider(Constante.OBSTACLES_MIN, Constante.OBSTACLES_MAX, 530, 449, 50, 100);
    // valeurObstacles.setDocument(new JTextFieldLimit(2));
    valeurObstacles.setBounds(580, 400, 190, 150);
    retour = new Retour(f);
    retour.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        option.clear();
        option.put("x", valeurX.getValue());
        option.put("y", valeurX.getValue());
        option.put("o", valeurObstacles.getValue());
        option.put("robot", valeurNombreRobo.getValue());
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
    // this.add(valeurY);
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

  public Map<String, Integer> getOption() {
    return this.option;
  }
}
