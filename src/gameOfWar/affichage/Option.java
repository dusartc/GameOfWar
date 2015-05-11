package gameOfWar.affichage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gameOfWar.jeux.*;

import javax.swing.JPanel;

public class Option extends JPanel implements ActionListener{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  protected void paintComponent(Graphics g) {
	Fond test = new Fond();
	test.paintComponent(g);
	Font Titre = new Font("Deja Vu", Font.ROMAN_BASELINE, 52);
    g.setFont(Titre);
    g.setColor(new Color(80,80,80));
    g.drawString("Game of war.", (this.getWidth()/3)+20, this.getHeight()/12);
    Graphics2D graphics2d = (Graphics2D)g;
    GradientPaint gradientPaint = new GradientPaint(0, -(180), new Color(80, 80, 80), 0, 90, new Color(40, 40, 40), true);
    graphics2d.setPaint(gradientPaint);
    graphics2d.fillRoundRect(160, 120, 700, 500, 20, 20);
    GradientPaint gradientPaint2 = new GradientPaint(0, 0, new Color(0xFF, 0xFF, 0xFF), 0, 90,  new Color(110, 110, 110), true);
    graphics2d.setPaint(gradientPaint2);
    graphics2d.fillRoundRect(160, 120, 700, 100, 20, 20);
    Font sousTitre = new Font("Deja Vu", Font.ROMAN_BASELINE, 40);
    g.setFont(sousTitre);
    g.setColor(new Color(0x80,0x80,0x80));
    g.drawString("OPTIONS", (this.getWidth()/3)+80, (this.getHeight()/4)+15);
    Font textPlateau = new Font("Deja Vu", Font.ROMAN_BASELINE, 24);
    g.setFont(textPlateau);
    g.setColor(new Color(0xFF,0xFF,0xFF));
    g.drawString("Taille du Plateau", (this.getWidth()/4)-25, (this.getHeight()/2)-35);
    g.setColor(Color.BLACK);
    g.drawRoundRect(160, 120, 700, 500, 20, 20);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
  }
}
