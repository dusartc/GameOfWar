package gameOfWar.config;

/**
 * La classe Coordonnees correspond au coordonne a m'anipuler avec Cellule.
 * @author Mathieu
 *
 */
public class Coordonnees {
  
  /** La largeur ou x d'une coordonnees sur l'axe des abscisses. */
  private int largeur;
  /** La longeur ou y d'une coordonnees sur l'axe des ordonnees. */
  private int hauteur;

  /**
   * Construit un point de l'axe.
   * @param largeur
   * @param hauteur
   */
  public Coordonnees(int largeur, int hauteur) {
    this.largeur = largeur;
    this.hauteur = hauteur;
  }

  /**
   * Retournesi la mine appartient a aucune equipe, 1 pour l'equipe une et 2 pour l'equipe deux. la largeur.
   * @return
   */
  public int getLargeur() {
    return largeur;
  }
  
  /**
   * Retourne la longueur.
   * @return
   */
  public int getHauteur() {
    return hauteur;
  }

  /**
   * Verifie si les coordonnees sont egales.
   * @param c
   * @return
   */
  public boolean equals(Coordonnees c){
    if(this.largeur == c.largeur && this.hauteur == c.hauteur) {
      return true;
    }
    return false;
  }

  /**
   * Calcule les coordonnees.
   * @param c
   * @return
   */
  public Coordonnees calculCoordonnees(Coordonnees c){
    Coordonnees inter = new Coordonnees(this.largeur - c.largeur, this.hauteur - c.hauteur);
    return inter;
  }

  /**
   * Affiche les coordonnees.
   */
  @Override
  public String toString(){
    return "Coordonnées : ("+this.largeur+","+this.hauteur+")";
  }

  /**
   * Ajout des coordonnees par rapport a l'initial.
   * @param coord
   * @return
   */
  public Coordonnees ajout(Coordonnees coord){
    return new Coordonnees(coord.largeur + this.largeur, coord.hauteur + this.hauteur);
  }


}
