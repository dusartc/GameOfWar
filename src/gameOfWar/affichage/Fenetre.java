package gameOfWar.affichage;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame {


  private static final long serialVersionUID = 1L;

  private JPanel main = new JPanel();
  
  public Fenetre() {
    this.setPreferredSize(new Dimension(1024, 720));
    this.pack();
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setContentPane(new Fond());
    this.afficheLabelTitre("Game of War");
    this.main.setBounds(0, 75, this.getWidth(), this.getHeight());
    this.getContentPane().add(main);
    this.changePanel(new Menu(this)); 
    this.setLayout(null);
    this.setVisible(true);
  }
  
  public Fenetre(String nom) {
    this();
    this.setTitle(nom);
  }

  public void changePanel(JPanel jPanel) {
    this.main.removeAll();
    for (Component c : jPanel.getComponents()) {
      this.main.add(c);
    }
    this.revalidate();
    this.repaint();
  }

  public void afficheLabelTitre(String titre) {
    JLabel gameOfWar = new JLabel(titre);
    gameOfWar.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 52));
    gameOfWar.setBounds(380, 5, 500, 80);
    this.getContentPane().add(gameOfWar);
  }
}
