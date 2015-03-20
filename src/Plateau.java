import java.util.Random;


public class Plateau {

  private Cellule[][] plateau;
//  private static final int DROITE = 1;
//  private static final int GAUCHE = 2;
//  private static final int HAUT   = 3;
//  private static final int BAS    = 4;
  
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
    
    int nbObstacles = (pourcentageObstacle / 100) * (this.plateau[0].length * this.plateau.length);
    int currentObstacles = 0;
    Random rd = new Random();
    while (currentObstacles < nbObstacles) {
      int rdX = rd.nextInt(this.plateau.length - 2) + 1;
      int rdY = rd.nextInt(this.plateau[0].length - 2) + 1;
      if (getCellule(rdX, rdY).estVide()) {
        this.plateau[rdY][rdX] = new Case(rdX, rdY, 1);
        currentObstacles += 1;
      }
    }
  }
  
  public Plateau(int longueur, int largeur, int x, int y, int direction){
    this.plateau = new Cellule[largeur][longueur];
    // TODO
  }
  
  public Cellule getCellule(int x, int y){
    return this.plateau[y][x];
  }
  
  public Cellule getCelluleByCoordonnees(Coordonnees coordonnees){
    return null;
  }
  
  
  
}
