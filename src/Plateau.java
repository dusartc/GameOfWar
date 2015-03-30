import java.util.Random;


public class Plateau {

  private Cellule[][] plateau;
  private int longueur;
  private int largeur;
//  private static final int DROITE = 1;
//  private static final int GAUCHE = 2;
//  private static final int HAUT   = 3;
//  private static final int BAS    = 4;
  
  public Plateau(int longueur, int largeur, int pourcentageObstacle) {
    this.plateau = new Cellule[largeur][longueur];
    this.longueur = longueur;
    this.largeur = largeur;
    
    if (pourcentageObstacle > Constante.OBSTACLES_MAX) {
      System.err.println("trop d'obstacles ; "+Constante.OBSTACLES_MAX+" sera utiliser");
      pourcentageObstacle = Constante.OBSTACLES_MAX;
    }
    if (pourcentageObstacle < Constante.OBSTACLES_MIN) {
      System.err.println("pas assez d'obstacles ; "+Constante.OBSTACLES_MIN+" sera utiliser");
      pourcentageObstacle = Constante.OBSTACLES_MIN;
    }
    
    for (int i = 0; i < plateau.length; i++) {          //
      for (int j = 0; j < plateau[0].length; j++) {     // remplissage vide
        this.plateau[i][j] = new Case(j, i);            //
      }
    }
    this.plateau[0][0] = new Base(0, 0, 1);                                //
    this.plateau[this.plateau.length - 1][this.plateau[0].length - 1] = // base par default aka plantage de choux
        new Base(this.plateau.length - 1, this.plateau[0].length - 1 , 2);  //
    
    double nbObstacles = ((double) pourcentageObstacle / 100) * (this.plateau[0].length * this.plateau.length);
    int currentObstacles = 0;
    Random rd = new Random();
    while (currentObstacles < nbObstacles) {
      int rdX = rd.nextInt(this.plateau.length - 2) + 1;
      int rdY = rd.nextInt(this.plateau[0].length - 2) + 1;
      if (getCellule(rdY, rdX).estVide()) {
        this.plateau[rdX][rdY] = new Case(rdX, rdY, true);
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
  
  public int getLargeur() {
    return largeur;
  }
  
  public int getLongueur() {
    return longueur;
  } 
  
  @Override
  public String toString() {
    String ans= quadrillage();
    for (int i = 0; i < plateau.length; i++) {
      for (int j = 0; j < plateau[0].length; j++) {
        if (plateau[i][j] instanceof Case) {
          Case test = (Case) plateau[i][j];
          if (test.estPassable()) {
            ans += "|   ";
          }else {
            ans += "| X ";
          }if (j == plateau[0].length-1) {
            ans += "|";
          }
        }
        if (plateau[i][j] instanceof Base) {
			Base test = (Base) plateau[i][j];
			if (test.estBase() == 1) {
				ans += "\n| B ";
			}
			else if(test.estBase() == 2){
				ans += "| b |\n";
			}
		}
      }if(i < plateau.length - 1) {
        ans += "\n"+quadrillage()+"\n";
      }
    }
    return ans + quadrillage();    
  }
  
  private String quadrillage(){
    String ans = "+";
    for (int i = 0; i < plateau[0].length ; i++) {
      ans += "---+";
    }    
    return ans;
  }
  
  public static void main(String[] args) {
	Plateau test = new Plateau(5, 10, 20);
	System.out.println(test);
}
}
