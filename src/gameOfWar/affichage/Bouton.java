package gameOfWar.affichage;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class Bouton extends JButton{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private String name;
  
  public Bouton(String str){
    super(str);
    this.name=str;
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    // TODO Auto-generated method stub
    super.paintComponent(g);
    Graphics2D graphics2d = (Graphics2D)g;
    GradientPaint gradientPaint = new GradientPaint(0, -(180), new Color(80, 80, 80), 0, 90, new Color(40, 40, 40), true);
    graphics2d.setPaint(gradientPaint);
    graphics2d.fillRoundRect(160, 120, 700, 500, 20, 20);
    g.setColor(Color.BLACK);
    g.drawRoundRect(160, 120, 700, 500, 20, 20);
  }
}
