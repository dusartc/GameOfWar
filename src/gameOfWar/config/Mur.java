package gameOfWar.config;

/**
 * La classe Mur correspond au placement d'un Mur.
 * 
 * @author Mathieu
 */
public class Mur extends Cellule {

  /**
   * Pose un mur aux coordonnes donnees.
   * 
   * @param largeur indice sur l'axe x
   * @param hauteur indice sur l'axe y
   */
  public Mur(int largeur, int hauteur) {
    super(largeur, hauteur);
    this.setMur(true);
  }

}
