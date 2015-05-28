package gameOfWar.affichage;

import java.awt.Color;
//import java.awt.Font;
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
    try {
    	File fond = new File("ressources/Images/fond.jpg");
    	Image img = ImageIO.read(fond);
    	g.drawImage(img, 0, 0, this);
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    Graphics2D graphics2d = (Graphics2D)g;
    GradientPaint gradientPaint3 = new GradientPaint(0, 20, new Color(0xFF, 0xFF, 0xFF), 0, 90, new Color(110, 110, 110), true);
    graphics2d.setPaint(gradientPaint3);
    graphics2d.fillRoundRect(-(1), 0, 1025, 75, 20, 20);
    g.setColor(Color.BLACK);
    g.drawRoundRect(-(1), 0, 1025, 75, 20, 20);
  }
}
