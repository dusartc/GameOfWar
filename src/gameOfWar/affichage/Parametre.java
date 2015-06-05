package gameOfWar.affichage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Parametre extends JPanel {

  private static final long serialVersionUID = -5321344808799764748L;

  private JLabel sousTitre;
  private JButton retour;
  private Fenetre fenetre;
  private JTabbedPane pane;

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
        try {
          writeProperties();
          fenetre.showMenu();
        } catch (Exception e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    });

    initPane();
    this.add(sousTitre);
    this.add(retour);
  }

  public void initPane() {
    this.pane = new JTabbedPane();
    this.pane.setBounds(125, 120, 700, 375);
    this.pane.setBackground(Color.black);
    this.pane.setForeground(Color.white);
    this.pane.setOpaque(false);
    String[] robot = new String[] {"Char", "Piegeur", "Tireur", "Worker"};
    for (String string : robot) {
      this.pane.addTab(string, new RobotPanel(string));
    }
    this.add(pane);
  }

  private void writeProperties() throws FileNotFoundException, IOException {
    String[] robot = new String[] {"Char", "Piegeur", "Tireur", "Worker"};
    Properties p = new Properties();
    p.load(new FileReader("ressources/gameOfWar.properties"));
    for (int i = 0; i < pane.getComponentCount(); i++) {
      Component t = pane.getComponentAt(i);
      if (t instanceof RobotPanel) {
        for (String string : ((RobotPanel) t).getDataMap().keySet()) {
          p.setProperty(robot[i].substring(0, 1).toLowerCase() + "_" + string, ((RobotPanel) t)
              .getDataMap().get(string) + "");
        }
      }
    }
    File file = new File("ressources/gameOfWar.properties");
    FileOutputStream output = new FileOutputStream(file);
    p.store(output, "");
    output.close();
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