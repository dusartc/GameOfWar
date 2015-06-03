package gameOfWar.affichage;

import gameOfWar.config.Constante;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ac implements ActionListener {

  private JPanel to;
  private String defx = Constante.X_CHOICE + "";
  private String defy = Constante.Y_CHOICE + "";
  private String defob = Constante.OBSTACLES_CHOICE + "";
  private JTextField tx;
  private JTextField ty;
  private JTextField ob;
  private Fenetre fenetre;
  
  public ac(Fenetre f) {
    setFenetre(f);
  }
  
  public ac(JPanel jPanel, Fenetre f) {
    this(f);
    this.to = jPanel;
  }
  
  public ac(JPanel jPanel, JTextField tx, JTextField ty, JTextField ob, Fenetre j) {
    this(j);
    this.to = jPanel;
    this.tx = tx;
    this.ty = ty;
    this.ob = ob;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Play")) {
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
    } else if (e.getActionCommand().equals("Jeu")) {
      JOptionPane.showMessageDialog(null, "Banane !");
    } else if (e.getActionCommand().equals("Parametre")) {
      JOptionPane.showMessageDialog(null, "Noisette !");
    } else if (e.getActionCommand().equals("Option")) {
      to.setVisible(false);
      fenetre.changePanel(new Option(fenetre));
    } else if (e.getActionCommand().equals("Retour")) {
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
            //JOptionPane.showMessageDialog(null, "Retour au menu principal !");
          } else {
            JOptionPane.showMessageDialog(null, s);
          }

        } catch (Exception e1) {
          tx.setText(defx);
          ty.setText(defy);
          ob.setText(defob);
          JOptionPane.showMessageDialog(null, "Champ Incorrect");
        }
        this.initilisationPlateau();
        to.setVisible(false);
        fenetre.changePanel(new Menu(fenetre));
    }
    
    else if (e.getActionCommand().equals("X")) {
      int retour = JOptionPane.showConfirmDialog(null, "Quitter ?");
      if (retour == JOptionPane.OK_OPTION) {
        System.exit(0);
      } else if (retour == JOptionPane.NO_OPTION) {
        JOptionPane.showMessageDialog(null, "Fait pas de connerie Billy !");
      } else {
        JOptionPane.showMessageDialog(null, "OUF !");
      }
    }

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
  }

  public JFrame getFenetre() {
    return fenetre;
  }

  public void setFenetre(Fenetre fenetre) {
    this.fenetre = fenetre;
  }

}
