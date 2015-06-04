package gameOfWar.affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Parametre extends JPanel {

  private static final long serialVersionUID = -5321344808799764748L;

  private JLabel sousTitre;
  private JButton retour;
  private Fenetre fenetre;

  public Parametre() {
    this.setLayout(null);
    this.setPreferredSize(new Dimension(900, 600));
    this.setOpaque(false);
    this.setLocation(60, 77);
    this.initComponent();
  }

  public Parametre(Fenetre fenetre) {
    this.setFenetre(fenetre);
    this.setLayout(null);
    this.setPreferredSize(new Dimension(900, 600));
    this.setOpaque(false);
    this.setLocation(60, 77);
    this.initComponent();
  }

  public void initComponent() {
    sousTitre = new JLabel("Parametre");
    sousTitre.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 45));
    sousTitre.setBounds(360, 45, 350, 50);
    retour = new Retour(fenetre);
    retour.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        fenetre.showMenu();
      }
    });
    this.add(sousTitre);
    this.add(retour);
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

  public Fenetre getFenetre() {
    return fenetre;
  }

  public void setFenetre(Fenetre fenetre) {
    this.fenetre = fenetre;
  }

}
