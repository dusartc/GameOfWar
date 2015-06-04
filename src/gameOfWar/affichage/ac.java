package gameOfWar.affichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

class ac implements ActionListener {

  private Fenetre fenetre;

  public ac(Fenetre f) {
    this.fenetre = f;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Jeu")) {
      fenetre.showJeu();
    } else if (e.getActionCommand().equals("Parametre")) {
      JOptionPane.showMessageDialog(null, "Noisette !");
    } else if (e.getActionCommand().equals("Option")) {
      fenetre.showOption();
    }
  }

  public JFrame getFenetre() {
    return fenetre;
  }
}
