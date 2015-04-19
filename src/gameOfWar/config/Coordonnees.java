package gameOfWar.config;

/**
 * Correspond au coordonnee a manipuler avec Cellule.
 * 
 * @author Mathieu
 */
public class Coordonnees {

  private int x;
  private int y;

  /**
   * Construit un point de l'axe.
   * 
   * @param x indice sur l'axe x
   * @param y indice sur l'axe y
   */
  public Coordonnees(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Ajout des coordonnees par rapport a l'initial.
   * 
   * @param coord les coordonnees a ajouter
   * @return Coordonnees
   */
  public Coordonnees ajout(Coordonnees coord) {
    return new Coordonnees(coord.x + this.x, coord.y + this.y);
  }

  /**
   * Soustrait les coordonnees par rapport aux coordonnees courantes
   * 
   * @param coordonnees les coordonnees dont on doit faire la difference
   * @return Coordonnees 
   */
  public Coordonnees difference(Coordonnees coordonnees) {
    return new Coordonnees(coordonnees.x - this.x, coordonnees.y - this.y);
  }

  /**
   * Calcule les coordonnees.
   * 
   * @param c chabada
   * @return Coordonnees
   */
  public Coordonnees calculCoordonnees(Coordonnees c) {
    Coordonnees inter = new Coordonnees(this.x - c.x, this.y - c.y);
    return inter;
  }

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
