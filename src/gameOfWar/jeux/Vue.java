package gameOfWar.jeux;

import gameOfWar.config.Cellule;
import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Robot;


/**
 * Represente un affichage du plateau avec seulement les mines de l'equipe qui possede la vue
 * 
 * @author Mathieu
 * @author Clement
 */
public class Vue {

  private Plateau plateau;
  private int equipe;

  /**
   * Construit une vue en fonction du plateau et du numero de l'equipe la possedant
   * 
   * @param plateau le plateau associe
   * @param equipe l'equipe associee
   */
  public Vue(Plateau plateau, int equipe) {
    this.plateau = plateau;
    this.equipe = equipe;
  }

  /**
   * Renvoie vrai si les coordonnees sont bien compris entre largueur et longueur
   * 
   * @param coordonnees les coordonnees a test
   * @return boolean
   */
  public boolean estOK(Coordonnees coordonnees) {
    return coordonnees.getLargeur() > 0 && coordonnees.getHauteur() > 0
        && coordonnees.getLargeur() < this.plateau.getLargeur()
        && coordonnees.getLargeur() < this.plateau.getLongueur();
  }

  public void libereCelulle(Coordonnees coordonnees) {
    this.plateau.libereCellule(coordonnees.getLargeur(), coordonnees.getHauteur());
  }

  public void poserRobot(Robot robot, Coordonnees coordonnees) {
    this.plateau.poserRobot(coordonnees.getLargeur(), coordonnees.getHauteur(), robot);
  }

  public void retirerRobot(Coordonnees coordonnees) {
    this.plateau.retirerRobot(coordonnees);
  }

  // public void setMine(Robot robot, Coordonnees coordonnees){
  // this.plateau.poserUneMine(coordonnees.getLargeur(), coordonnees.getHauteur(),
  // robot.getEquipe());
  // }

  public void retirerMine(Coordonnees coordonnees) {
    this.plateau.retirerMine(coordonnees);
  }

  public Plateau getPlateau() {
    return this.plateau;
  }

  public int getEquipe() {
    return this.equipe;
  }

  @Override
  public String toString() {
    StringBuilder ans = new StringBuilder();
    for (Cellule[] cellules : this.plateau.getPlateau()) {
      ans.insert(ans.length(), "\n" + quadrillage() + "\n| ");
      for (Cellule cellule : cellules) {
        ans.insert(ans.length(),
            (cellule.contientMine() == 0 ? cellule.getImage()
                : cellule.contientMine() == equipe ? cellule.getImage() : " ")
                + " | ");
      }
    }
    ans.insert(ans.length(), "\n" + quadrillage() + "\n\n" + legende());
    return ans.toString();
  }

  private String legende() {
    String ans = "+";
    for (int i = 0; i < 63; i++) {
      ans += "-";
    }
    ans += "+\n";
    ans += "|\tMAJUSCULES\t%\tminuscules\t\t\t|\n";
    String[] chabadabada =
        new String[] {"base", "tireur", "piegeur", "char", "mine", "factory", "worker"};
    for (int i = 0; i < chabadabada.length; i++) {
      ans +=
          "|\t\t" + chabadabada[i].substring(0, 1).toUpperCase() + "\t|\t\t"
              + chabadabada[i].substring(0, 1) + "\t" + chabadabada[i] + "\t\t|\n";
    }
    ans += "|\t";
    for (int i = 0; i < 47; i++) {
      ans += "-";
    }
    ans += "\t\t|\n";
    ans += "|\t\to\tobstacles\t\t\t\t|\n+";
    for (int i = 0; i < 63; i++) {
      ans += "-";
    }
    return ans + "+";
  }

  private String quadrillage() {
    String ans = "+";
    for (int i = 0; i < this.plateau.getLargeur(); i++) {
      ans += "---+";
    }
    return ans;
  }

}
