package gameOfWar.affichage;

import gameOfWar.jeux.Equipe;
import gameOfWar.jeux.Plateau;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Jeu extends JPanel {

  private static final long serialVersionUID = 1L;

  private Plateau plateau;
  private Equipe[] equipes;
  private Fenetre fenetre;

  public Jeu(Fenetre f, Equipe[] equipes, Plateau plateau) {
    this.fenetre = f;
    this.equipes = equipes;
    this.plateau = plateau;
    initComponent();
  }

  private void initComponent() {
    this.setLayout(null);
    this.setPreferredSize(new Dimension(1024, 650));
    // this.setBounds(0, 75, fenetre.getWidth(), fenetre.getHeight());
    this.setBackground(Color.white);
    this.setVisible(true);
    this.add(new Slider(0, 10, 5, 5, 20, 20));
  }

  @Override
  protected void paintComponent(Graphics g) {
    // TODO Auto-generated method stub
    super.paintComponent(g);
    Graphics2D graphics2d = (Graphics2D) g;
    GradientPaint gradientPaint =
        new GradientPaint(0, -(180), new Color(80, 80, 80), 0, 90, new Color(40, 40, 40), true);
    graphics2d.setPaint(gradientPaint);
    graphics2d.fillRoundRect(100, 30, 740, 550, 20, 20);
  }

}
