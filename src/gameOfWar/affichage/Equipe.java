package gameOfWar.affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Equipe extends JPanel {

  private Fenetre fenetre;
  private Map<String, Integer> equipe;
  private JLabel sousTitre;
  
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public Equipe(Fenetre f) {
    this.equipe = new HashMap<String, Integer>();
    initMap();
    this.fenetre = f;
    this.setLayout(null);
    this.setPreferredSize(new Dimension(900, 600));
    this.setOpaque(false);
    this.setLocation(60, 77);
    initComponent();
  }
  
  private void initComponent() {
    
  }
  
  private void initMap() {
    String[] strings = new String[] {
        "nom","num"
    };
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D graphics2d = (Graphics2D) g;
    GradientPaint gradientPaint =
        new GradientPaint(0, -(180), new Color(80, 80, 80), 0, 90, new Color(40, 40, 40), true);
    graphics2d.setPaint(gradientPaint);
    graphics2d.fillRoundRect(100, 30, 740, 550, 20, 20);
    GradientPaint gradientPaint2 =
        new GradientPaint(0, 0, new Color(0xFF, 0xFF, 0xFF), 0, 90, new Color(110, 110, 110), true);
    graphics2d.setPaint(gradientPaint2);
    graphics2d.fillRoundRect(100, 30, 740, 80, 20, 20);
  }
  
}
