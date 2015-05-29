package gameOfWar.affichage;

import java.awt.Color;
//import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class Forme extends JPanel{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public Forme(GridBagLayout gridBagLayout) {
    super(gridBagLayout);
  }
  
  public Forme() {
    super();
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D graphics2d = (Graphics2D)g;
    GradientPaint gradientPaint = new GradientPaint(0, -(180), new Color(80, 80, 80), 0, 90, new Color(40, 40, 40), true);
    graphics2d.setPaint(gradientPaint);
    graphics2d.fillRoundRect(140, 30, 740, 550, 20, 20);
    GradientPaint gradientPaint2 = new GradientPaint(0, 0, new Color(0xFF, 0xFF, 0xFF), 0, 90,  new Color(110, 110, 110), true);
    graphics2d.setPaint(gradientPaint2);
    graphics2d.fillRoundRect(140, 30, 740, 80, 20, 20);
  }
}
