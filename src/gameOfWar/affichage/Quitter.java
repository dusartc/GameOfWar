package gameOfWar.affichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Quitter implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent arg0) {
    int retour = JOptionPane.showConfirmDialog(null, "Quitter ?");
    if (retour == JOptionPane.OK_OPTION) {
    JOptionPane.showMessageDialog(null, "Adieu !");
      System.exit(0);
    } else if (retour == JOptionPane.NO_OPTION) {
      JOptionPane.showMessageDialog(null, "Anullation !");
    }
  }

}
