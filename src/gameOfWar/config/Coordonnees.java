package gameOfWar.config;

public class Coordonnees {
  private int largeur;
  private int hauteur;

  public Coordonnees(int largeur, int hauteur) {
    this.largeur = largeur;
    this.hauteur = hauteur;
  }

  public int getLargeur() {
    return largeur;
  }
  public int getHauteur() {
    return hauteur;
  }

  //verifie que les coordonnees sont egales
  public boolean equals(Coordonnees c){
    if(this.largeur == c.largeur && this.hauteur == c.hauteur) {
      return true;
    }
    return false;
  }

  //calcul des coordonnees
  public Coordonnees calculCoordonnees(Coordonnees c){
    Coordonnees inter = new Coordonnees(this.largeur - c.largeur, this.hauteur - c.hauteur);
    return inter;
  }

  @Override
  public String toString(){
    return "Coordonnées : ("+this.largeur+","+this.hauteur+")";
  }

  public Coordonnees ajout(Coordonnees coord){
    return new Coordonnees(coord.largeur + this.largeur, coord.hauteur + this.hauteur);
  }


}
