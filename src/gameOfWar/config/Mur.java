package gameOfWar.config;


public class Mur extends Cellule {

  public Mur(int largeur, int hauteur){
    super(largeur, hauteur);
    this.setMur(true);
  }
  public boolean estPassable(){
    return this.estMur();
  }
}
