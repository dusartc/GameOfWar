package gameOfWar.affichage;

import gameOfWar.affichage.Son;
import gameOfWar.config.Constante;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Option extends JPanel {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  private JPanel jPanel = new Forme(new GridBagLayout());
  private JPanel toutLesPanel;
  private int nombreSousTitre = 0;
  private JTextField tx = new JTextField(Constante.X_CHOICE + "");
  private JTextField ty = new JTextField(Constante.Y_CHOICE + "");
  private JTextField ob = new JTextField(Constante.OBSTACLES_CHOICE + "");

  private JButton b = new Bouton("Musique");
  private JButton b2 = new Bouton("Son");
  private JButton b3 = new Bouton("Retour");

  public Option() {

    super(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    this.getJpanel(constraints, 400, 100, GridBagConstraints.VERTICAL, 50, 0, 1);
    this.getJpanel(constraints, 400, 100, GridBagConstraints.VERTICAL, 0, 0, 2);
    this.getJpanel(constraints, 400, 100, GridBagConstraints.VERTICAL, 0, 0, 3);
    this.getJpanel(constraints, 800, 100, GridBagConstraints.VERTICAL, 0, 0, 4);
    /*
     * this.getBoutonJeu(constraints, "Jeu", 250, 100, GridBagConstraints.VERTICAL, 50, 0, 1);
     * this.getBoutonJeu(constraints, "Parametre", 250, 100, GridBagConstraints.VERTICAL, 0, 0, 2);
     * this.getBoutonJeu(constraints, "Option", 250, 100, GridBagConstraints.VERTICAL, 0, 0, 3);
     * this.getBoutonJeu(constraints, "X", 50, 50, GridBagConstraints.EAST, 0, 0, 4);
     */
    this.add(jPanel);

  }

  public JPanel panel(JPanel toutLesPanel2, GridBagConstraints constraints) {

    jPanel.add(toutLesPanel2, constraints);
    jPanel.setLocation(0, 0);
    jPanel.setMinimumSize(new Dimension(500, 500));
    jPanel.setPreferredSize(new Dimension(1024, 720));
    jPanel.setMaximumSize(new Dimension(1000, 650));
    if (nombreSousTitre == 0) {
      JLabel sousTitre = new JLabel("Option");
      sousTitre.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 45));
      sousTitre.setLocation(150, 0);
      jPanel.add(sousTitre);
      nombreSousTitre++;
    }
    return jPanel;
  }


  private void getJpanel(GridBagConstraints constraints, int x, int y, int fill, int insetsTop,
      int gridx, int gridy) {
    toutLesPanel = new JPanel();
    toutLesPanel.setPreferredSize(new Dimension(x, y));
    constraints.fill = fill;
    constraints.weightx = 1;
    if (insetsTop > 0) {
      constraints.insets = new Insets(insetsTop, 40, 0, 20);
    }
    constraints.gridx = gridx;
    constraints.gridy = gridy;
    toutLesPanel.setOpaque(false);

    if (gridy == 1) {
      JLabel l = new JLabel("Taille du Plateau");
      l.setForeground(Color.white);
      l.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
      toutLesPanel.add(l);

      tx.setPreferredSize(new Dimension(40, 40));
      tx.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
      toutLesPanel.add(tx);

      JLabel l2 = new JLabel("X");
      l2.setForeground(Color.white);
      l2.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
      toutLesPanel.add(l2);

      ty.setPreferredSize(new Dimension(40, 40));
      ty.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
      toutLesPanel.add(ty);

    } else if (gridy == 2) {
      JLabel l = new JLabel("Pourcentage d'obstacle");
      l.setForeground(Color.white);
      l.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
      toutLesPanel.add(l);

      ob.setPreferredSize(new Dimension(40, 40));
      ob.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
      toutLesPanel.add(ob);
    } else if (gridy == 3) {

      b.setPreferredSize(new Dimension(120, 100));
      toutLesPanel.add(b);
      b.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          bActionPerformed(evt);
        }
      });

      b2.setPreferredSize(new Dimension(120, 100));
      toutLesPanel.add(b2);
      b2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          b2ActionPerformed(evt);
        }
      });

      b3.setPreferredSize(new Dimension(120, 100));
      toutLesPanel.add(b3);
      b3.setActionCommand("Retour");
      b3.addActionListener(new ac(jPanel, tx, ty, ob));/*new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          b3ActionPerformed(evt);
        }
      });*/

    }
    this.panel(toutLesPanel, constraints);
  }

  private void bActionPerformed(ActionEvent evt) {
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
  }

  private void b2ActionPerformed(ActionEvent evt) {
    JOptionPane.showMessageDialog(null, "Son");
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
    
  }

  public void initilisationPlateau() {
    PrintWriter writer = null;
    try {
      writer = new PrintWriter("ressources/plateau.properties", "UTF-8");
      writer.println("x: " + Constante.X_CHOICE + "\ny: " + Constante.Y_CHOICE + "\nObstacles: "
          + Constante.OBSTACLES_CHOICE);
    } catch (FileNotFoundException | UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    writer.close();
  }*/

}
