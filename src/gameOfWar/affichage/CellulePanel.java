package gameOfWar.affichage;

import gameOfWar.config.Cellule;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CellulePanel extends JPanel {

  private static final long serialVersionUID = 1L;

  private Cellule cellule;

  public CellulePanel() {
    // TODO Auto-generated constructor stub
  }

  public CellulePanel(Cellule cellule, int x, int y, int w, int h) {
    this.cellule = cellule;
    this.setBounds(x, y, w, h);
    this.setLayout(null);
    this.setBackground(Color.WHITE);
    try {
      if (cellule.getRobot() != null) {
        // this.setBackground(Color.RED);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    this.setVisible(true);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    try {
      if (cellule.getRobot() != null) {
//        File f = new File("ressources/Images/tireur.png");
//        Image img = ImageIO.read(f);
//        g.drawImage(img, 0, 0, this);
        this.setBackground(Color.red);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
