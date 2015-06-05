package gameOfWar.affichage;

import java.awt.Color;

import javax.swing.JSlider;

public class Slider extends JSlider {

  private static final long serialVersionUID = 1L;
  
  private String nom;

  public Slider(int min, int max, int x, int y, int w, int h) {
    //this.setPreferredSize(new Dimension(w,h));
    this.setMaximum(max);
    this.setMinimum(min);
    this.setBounds(x, y, w, h);
    this.setOpaque(false);
    this.setValue((max + min)/2);
    this.setPaintTicks(true);
    this.setPaintLabels(true);
    this.setMajorTickSpacing((max + min)/4);
    this.setForeground(Color.white);
  }
  
  public Slider(String nom, int min, int max, int x, int y, int w, int h) {
    this(min, max, x, y, w, h);
    this.nom = nom;
  }
  
  public String getNom() {
    return nom;
  }
}
