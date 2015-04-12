package gameOfWar.config;

/**
 * La classe Mine correspond au placement d'une mine.
 * @author Mathieu
 *
 */
public class Mine extends Cellule {

  /**
   * Le constructeur construit une Mine par rapport aux coordonnees donnees et a l'equipe
   * @param largeur
   * @param hauteur
   * @param equipe, l'equipe de la Mine.
   */
  public Mine(int largeur, int hauteur, int equipe) {
    super(largeur, hauteur);
    this.poseMine(equipe);
  }
}
