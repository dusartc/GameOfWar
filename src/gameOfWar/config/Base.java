package gameOfWar.config;

/**
 * La classe Base correspond au placement d'une base.
 * @author Mathieu
 *
 */
public class Base extends Cellule {

  /**
   * Le constructeur construit une base par rapport aux coordonnees donnees et a l'equipe
   * @param largeur
   * @param hauteur
   * @param equipe, l'equipe de la base.
   */
  public Base(int largeur, int hauteur, int equipe) {
    super(largeur, hauteur);
    this.poseBase(equipe);
  }
}
