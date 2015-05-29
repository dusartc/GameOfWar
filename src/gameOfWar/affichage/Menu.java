package gameOfWar.affichage;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private JPanel jPanel = new Forme(new GridBagLayout());
  private JButton toutLesBoutons;
  private int nombreSousTitre = 0;

  public Menu() {
    super(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    this.getBoutonJeu(constraints, "Jeu", 250, 100, GridBagConstraints.VERTICAL, 50, 0, 1);
    this.getBoutonJeu(constraints, "Parametre", 250, 100, GridBagConstraints.VERTICAL, 0, 0, 2);
    this.getBoutonJeu(constraints, "Option", 250, 100, GridBagConstraints.VERTICAL, 0, 0, 3);
    this.getBoutonJeu(constraints, "X", 50, 50, GridBagConstraints.EAST, 0, 0, 4);
    this.add(jPanel);
  }

  public JPanel panel(JButton jButton, GridBagConstraints constraints) {
    jPanel.add(jButton, constraints);
    jPanel.setLocation(0, 0);
    jPanel.setMinimumSize(new Dimension(500, 500));
    jPanel.setPreferredSize(new Dimension(1024, 720));
    jPanel.setMaximumSize(new Dimension(1000, 650));
    if (nombreSousTitre == 0) {
      JLabel sousTitre = new JLabel("Menu");
      sousTitre.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 45));
      sousTitre.setLocation(150, 0);
      jPanel.add(sousTitre);
      nombreSousTitre++;
    }
    return jPanel;
  }


  private void getBoutonJeu(GridBagConstraints constraints, String nom, int x, int y, int fill,
      int insetsTop, int gridx, int gridy) {
    toutLesBoutons = new Bouton(nom);
    toutLesBoutons.setPreferredSize(new Dimension(x, y));
    constraints.fill = fill;
    constraints.weightx = 1;
    if (insetsTop > 0) {
      constraints.insets = new Insets(insetsTop, 40, 0, 20);
    }
    constraints.gridx = gridx;
    constraints.gridy = gridy;
    toutLesBoutons.setActionCommand(nom);
    toutLesBoutons.addActionListener(new ac(jPanel));
    this.panel(toutLesBoutons, constraints);
  }
}
