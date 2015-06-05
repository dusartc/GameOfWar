package gameOfWar.affichage;

import gameOfWar.jeux.Equipe;
import gameOfWar.jeux.Plateau;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Jeu extends JFrame {

  private static final long serialVersionUID = 1L;

  private Plateau plateau;
  private Equipe[] equipes;
  private Fenetre fenetre;
  private JPanel jPanel;

  public Jeu(Fenetre f, Equipe[] equipes, Plateau plateau) {
    this.fenetre = f;
    this.equipes = equipes;
    this.plateau = plateau;
    this.setLayout(null);
    this.setPreferredSize(new Dimension(1024, 720));
    this.pack();
    this.setTitle("Game Of War");
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    initComponent();
  }

  private void initComponent() {
    jPanel = new JPanel();
    jPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
    jPanel.setBackground(Color.darkGray);
    jPanel.add(new Slider(0, 10, 5, 5, 20, 20));
    this.add(jPanel);
  }

 /* @Override
  protected void paintComponent(Graphics g) {
    // TODO Auto-generated method stub
	super.paintComponent(g);
    Graphics2D graphics2d = (Graphics2D) g;
    GradientPaint gradientPaint =
        new GradientPaint(0, -(180), new Color(80, 80, 80), 0, 90, new Color(40, 40, 40), true);
    graphics2d.setPaint(gradientPaint);
    graphics2d.fillRoundRect(100, 30, 2000, 1000, 20, 20);
  }*/

}
