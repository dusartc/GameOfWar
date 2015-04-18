package gameOfWar.config;

/**
 * La classe Coordonnees correspond au coordonne a m'anipuler avec Cellule.
 * 
 * @author Mathieu
 */
public class Coordonnees {

  /** La largeur ou x d'une coordonnees sur l'axe des abscisses. */
  private int x;
  /** La longeur ou y d'une coordonnees sur l'axe des ordonnees. */
  private int y;

  /**
   * Construit un point de l'axe.
   * 
   * @param largeur
   * @param hauteur
   */
  public Coordonnees(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Ajout des coordonnees par rapport a l'initial.
   * 
   * @param coord
   * @return
   */
  public Coordonnees ajout(Coordonnees coord) {
    return new Coordonnees(coord.x + this.x, coord.y + this.y);
  }
  
  public Coordonnees difference(Coordonnees coordonnees) {
    return new Coordonnees(coordonnees.x - this.x, coordonnees.y - this.y);
  }

  /**
   * Calcule les coordonnees.
   * 
   * @param c
   * @return
   */
  public Coordonnees calculCoordonnees(Coordonnees c) {
    Coordonnees inter = new Coordonnees(this.x - c.x, this.y - c.y);
    return inter;
  }

  /**
   * Verifie si les coordonnees sont egales.
   * 
   * @param c
   * @return
   */
  public boolean equals(Coordonnees c) {
    return this.x == c.x && this.y == c.y;
  }

  public int getHauteur() {
    return this.y;
  }

  public int getLargeur() {
    return this.x;
  }

  /**
   * Affiche les coordonnees.
   */
  @Override
  public String toString() {
    return "Coordonnées : (" + this.x + "," + this.y + ")";
  }


}
