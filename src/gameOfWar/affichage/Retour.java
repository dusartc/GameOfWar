package gameOfWar.affichage;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Retour extends JButton {
  
  private static final long serialVersionUID = 1L;

  public Retour(final Fenetre f) {
    this.setBounds(750, 500, 50, 50);
    try {
      File fond = new File("ressources/Images/retour.png");
      Image img = ImageIO.read(fond);
      this.setIcon(new ImageIcon(img));
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    this.setActionCommand("Retour");
  }
  
}
