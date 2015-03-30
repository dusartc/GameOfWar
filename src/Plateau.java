
public class Plateau {

  private Cellule[][] plateau;
  
  public Plateau(int longueur, int largeur, int pourcentageObstacle) {
    this.plateau = new Cellule[largeur][longueur];
    for (int i = 0; i < plateau[0].length; i++) {   //
      for (int j = 0; j < plateau.length; j++) {    // remplissage vide
        this.plateau[i][j] = new Case(j, i);        //
      }
    }
    this.plateau[0][0] = new Base(0, 0);                                //
    this.plateau[this.plateau[0].length - 1][this.plateau.length - 1] = // base par default
        new Base(this.plateau[0].length - 1, this.plateau.length - 1);  //
    
    
    
  }
  
  public Cellule getCellule(int x, int y){
    return this.plateau[y][x];
  }
  
  
  
}
