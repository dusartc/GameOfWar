package gameOfWar.affichage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import gameOfWar.jeux.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Option extends JPanel{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  protected void paintComponent(Graphics g) {
    try {
      Image img = ImageIO.read(new File("Images\\fond.jpg"));
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
    Font titre = new Font("Déjà Vu", Font.ROMAN_BASELINE, 40);
    g.setFont(titre);
    g.setColor(new Color(0x80,0x80,0x80));
    g.drawString("GAME OF WAR", (this.getWidth()/3)+20, this.getHeight()/12);
    
    Font copyright = new Font("Déjà Vu", Font.BOLD, 16);
    g.setFont(copyright);
    g.setColor(Color.black);
    g.drawString("© Copyright.", 12, 680);
   // g.g
    GradientPaint gradientPaint = new GradientPaint(0, -(180), new Color(80, 80, 80), 0, 90, new Color(40, 40, 40), true);
    graphics2d.setPaint(gradientPaint);
    graphics2d.fillRoundRect(160, 120, 700, 500, 20, 20);
    GradientPaint gradientPaint2 = new GradientPaint(0, 0, new Color(0xFF, 0xFF, 0xFF), 0, 90,  new Color(110, 110, 110), true);
    graphics2d.setPaint(gradientPaint2);
    graphics2d.fillRoundRect(160, 120, 700, 100, 20, 20);
    Font sousTitre = new Font("Déjà Vu", Font.ROMAN_BASELINE, 40);
    g.setFont(sousTitre);
    g.setColor(new Color(0x80,0x80,0x80));
    g.drawString("OPTIONS", (this.getWidth()/3)+80, (this.getHeight()/4)+15);
    Font textPlateau = new Font("Déjà Vu", Font.ROMAN_BASELINE, 24);
    g.setFont(textPlateau);
    g.setColor(new Color(0xFF,0xFF,0xFF));
    g.drawString("Taille du Plateau", (this.getWidth()/4)-25, (this.getHeight()/2)-35);
    g.setColor(Color.BLACK);
    g.drawRoundRect(160, 120, 700, 500, 20, 20);
  }
}
