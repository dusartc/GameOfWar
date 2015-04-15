package gameOfWar.affichage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
//import gameOfWar.jeux.Images.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Fond extends JPanel{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  protected void paintComponent(Graphics g) {
    // TODO Auto-generated method stub
    super.paintComponent(g);
    try {
      Image img = ImageIO.read(new File("C:\\Users\\Mathieu\\workspace\\chaba\\bin\\gameOfWar\\jeux\\Images\\fond.jpg"));
      g.drawImage(img, 0, 0, this);
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    Graphics2D graphics2d = (Graphics2D)g;
    GradientPaint gradientPaint3 = new GradientPaint(0, 0, new Color(0xFF, 0xFF, 0xFF), 0, 90, new Color(110, 110, 110), true);
    graphics2d.setPaint(gradientPaint3);
    graphics2d.fillRoundRect(-(1), 0, 1025, 75, 20, 20);
    g.setColor(Color.BLACK);
    g.drawRoundRect(-(1), 0, 1025, 75, 20, 20);
    Font Titre = new Font("Déjà Vu", Font.ITALIC, 52);
    g.setFont(Titre);
    g.setColor(Color.white);
    g.drawString("Game of war.", (this.getWidth()/3)+20, this.getHeight()/12);
    
    Font copyright = new Font("Déjà Vu", Font.BOLD, 16);
    g.setFont(copyright);
    g.setColor(Color.black);
    g.drawString("© Copyright.", 12, 680);
  }
}
