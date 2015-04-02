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
    if (pourcentageObstacle > Constante.OBSTACLES_MAX) {
      System.err.println("trop d'obstacles ; "+Constante.OBSTACLES_MAX+" sera utilisé");
      pourcentageObstacle = Constante.OBSTACLES_MAX;
    }
    if (pourcentageObstacle < Constante.OBSTACLES_MIN) {
      System.err.println("pas assez d'obstacles ; "+Constante.OBSTACLES_MIN+" sera utilisé");
      pourcentageObstacle = Constante.OBSTACLES_MIN;
    }
    this.plateau = new Cellule[largeur][longueur];
    for (int i = 0; i < plateau.length; i++) {          //
      for (int j = 0; j < plateau[0].length; j++) {     // remplissage vide
        this.plateau[i][j] = new Cellule(j, i);            //
      }
    }
    this.plateau[0][0] = new Base(0, 0, Constante.EQUIPE_UN); //
    this.plateau[this.plateau.length - 1][this.plateau[0].length - 1] = // base par default
        new Base(this.plateau.length - 1, this.plateau[0].length - 1, Constante.EQUIPE_DEUX);  //
    
    double nbObstacles = ((double) pourcentageObstacle / 100) * (this.plateau[0].length * this.plateau.length);
    int currentObstacles = 0;
    Random rd = new Random();
    while (currentObstacles < nbObstacles) {
      int rdX = rd.nextInt(this.plateau.length - 2) + 1;
      int rdY = rd.nextInt(this.plateau[0].length - 2) + 1;
      if (!getCellule(rdY, rdX).estMur() &&
    		  getCellule(rdY, rdX).estBase() == 0 &&
    		  getCellule(rdY, rdX).contientMine() == 0 &&
    		  getCellule(rdY, rdX).estRobot() == 0) {
        this.plateau[rdX][rdY] = new Mur(rdX, rdY);
        currentObstacles += 1;
      }
    }
  }
  
  public Plateau(int longueur, int largeur, int x, int y, int direction){
    this.plateau = new Cellule[largeur][longueur];
  }
  
  public Cellule getCellule(int x, int y){
    return this.plateau[y][x];
  }
  
  public Cellule getCelluleByCoordonnees(Coordonnees coordonnees){
    return null;
  }
  
  public int getLargeur() {
    return this.largeur;
  }
  
  public int getLongueur() {
    return this.longueur;
  } 
  
  public boolean estMur(int x, int y){
	  return plateau[y][x].estMur();
  }
  
  public int estBase(int x, int y){
	  return plateau[y][x].estBase();
  }
  
  public int estMine(int x, int y){
	  return plateau[y][x].contientMine();
  }
  
  public int estRobot(int x, int y){
	  return plateau[y][x].estRobot();
  }
  
  public void libereCellule(int x, int y){
	  this.plateau[y][x].videCase();
  }
  public void poserUneMine(int x, int y, int equipe){
	  if (this.estBase(y,x) != 0 && !this.estMur(x, y) && this.estRobot(y, x) == 0) {
		this.plateau[y][x].poseMine(equipe);
	  }
	  else{
		  System.err.println("Erreur, placement impossible");
	  }
  }
  
  public void poserRobot(int x, int y, Robot robot){
	  if(!this.estMur(y,x) && this.estBase(x,y) > 0 && this.estMine(x,y) == 0){
			 this.plateau[y][x].poserRobot(robot);
	  }
  }
  
  @Override
  public String toString() {
    String ans= quadrillage();
    for (int i = 0; i < plateau.length; i++) {
      for (int j = 0; j < plateau[0].length; j++) {
      if (plateau[i][j] instanceof Mur) {
        Mur test = (Mur) plateau[i][j];
      	if(test.estMur()) {
            ans += "| X ";
        }
      }
      else if (plateau[i][j] instanceof Base) {
		Base test = (Base) plateau[i][j];
		if (test.estBase() == 1) {
			ans += "\n| B ";
		}
		else if(test.estBase() == 2){
			ans += "| b |\n";
		}
      }
      else if (plateau[i][j] instanceof Cellule){
        	ans += "|   ";
        	if (j == plateau[0].length-1) {
            ans += "|";
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
	//Vue test2 = new Vue(test);
	//Tireur test3 = new Tireur(test2, 3, 5, 1);
	//test2.poserRobot(robot, coordonnees);
	System.out.println(test);
}
}