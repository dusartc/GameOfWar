package gameOfWar.affichage;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame {


  private static final long serialVersionUID = 1L;

  private JPanel main;
  private Option option;
  private Menu menu;
  private ParametreEquipe parametre;

  public Fenetre() {
    this.main = new JPanel();
    this.option = new Option(this);
    this.menu = new Menu(this);
    this.parametre = new ParametreEquipe(this);
    this.setPreferredSize(new Dimension(1024, 720));
    this.pack();
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setContentPane(new Fond());
    this.afficheLabelTitre("Game of War");
    this.main.setBounds(0, 75, this.getWidth(), this.getHeight());
    this.getContentPane().add(main);
    this.changePanel(new ParametreEquipe(this));
    this.setLayout(null);
    this.setVisible(true);
  }

  public Fenetre(String nom) {
    this();
    this.setTitle(nom);
  }

  public void changePanel(JPanel jPanel) {
    this.main.removeAll();
    this.main.setPreferredSize(jPanel.getPreferredSize());
    this.main.setLocation(jPanel.getLocation());
    this.main.setOpaque(false);
    // for (Component c : jPanel.getComponents()) {
    // this.main.add(c);
    // }
    this.main.add(jPanel);
    this.revalidate();
    this.repaint();
  }
  
  public void showMenu() {
    this.changePanel(menu);
  }
  
  public void showOption() {
    this.changePanel(option);
  }
  
  public void showJeu(){
    this.changePanel(parametre);
  }

  public void afficheLabelTitre(String titre) {
    JLabel gameOfWar = new JLabel(titre);
    gameOfWar.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 52));
    gameOfWar.setBounds(380, 5, 500, 80);
    this.getContentPane().add(gameOfWar);
  }
  
  public Map<String, Integer> getOptionMap(){
    return this.option.getOption();
  }
}
