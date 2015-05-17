package gameOfWar.affichage;

//import java.awt.Color;
//import java.awt.GradientPaint;
//import java.awt.Graphics;
//import java.awt.Graphics2D;

import javax.swing.Icon;
import javax.swing.JButton;

public class Bouton extends JButton{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  @SuppressWarnings("unused")
  private Icon name;
  private String names;
  
  public Bouton(String str, int x, int y){
    super(str);
    this.setLocation(x, y);
    this.names=str;
  }
  
  public Bouton(Icon str, int x, int y){
    super(str);
    this.setLocation(x, y);
    this.name=str;
  }
  
  /*@Override
  protected void paintComponent(Graphics g) {
    // TODO Auto-generated method stub
    super.paintComponent(g);
    Graphics2D graphics2d = (Graphics2D)g;
    GradientPaint gradientPaint = new GradientPaint(0, -(180), new Color(80, 80, 80), 0, 90, new Color(40, 40, 40), true);
    graphics2d.setPaint(gradientPaint);
    graphics2d.fillRoundRect(160, 120, 700, 500, 20, 20);
    g.setColor(Color.BLACK);
    g.drawRoundRect(160, 120, 700, 500, 20, 20);
  }*/
}
