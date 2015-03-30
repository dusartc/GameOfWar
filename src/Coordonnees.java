
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
  
  @Override
  public String toString(){
    return "Coordonnées : ("+this.largeur+","+this.hauteur+")";
  }
  
  public Coordonnees ajout(Coordonnees coord){
    return new Coordonnees(coord.largeur + this.largeur, coord.hauteur + this.hauteur);
  }
  
  
}
