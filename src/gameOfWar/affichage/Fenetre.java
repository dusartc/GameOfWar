package gameOfWar.affichage;

import java.awt.Component;
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
  private ParametreEquipe equipe;
  private Parametre parametre;

  public Fenetre() {
    this.main = new JPanel();
    this.option = new Option(this);
    this.menu = new Menu(this);
    this.equipe = new ParametreEquipe(this);
    this.parametre = new Parametre(this);
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
    this.main.setPreferredSize(jPanel.getPreferredSize());
    this.main.setLocation(jPanel.getLocation());
    this.main.setOpaque(false);
    this.main.add(jPanel);
    this.revalidate();
    this.repaint();
    //jPanel.setLocation(20,20);
  }
  
  public void showMenu() {
    this.changePanel(menu);
  }
  
  public void showOption() {
    this.changePanel(option);
  }
  
  public void showEquipe() {
    this.changePanel(equipe);
  }
  
  public void showParametre() {
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
