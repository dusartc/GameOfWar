package gameOfWar.jeux;
import gameOfWar.config.Base;
import gameOfWar.config.Cellule;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.config.Mine;
import gameOfWar.config.Mur;
import gameOfWar.robot.Robot;

import java.util.Random;


/**
 * @author dusartc
 */
public class Plateau {

  private Cellule[][] plateau;
  private int longueur;
  private int largeur;

  public Plateau(int longueur, int largeur, int pourcentageObstacle) {
    this.longueur = longueur;
    this.largeur = largeur;
    if (pourcentageObstacle > Constante.OBSTACLES_MAX) {
      System.err.println("trop d'obstacles ; " + Constante.OBSTACLES_MAX + " sera utilise");
      pourcentageObstacle = Constante.OBSTACLES_MAX;
    }
    if (pourcentageObstacle < Constante.OBSTACLES_MIN) {
      System.err.println("pas assez d'obstacles ; " + Constante.OBSTACLES_MIN + " sera utilise");
      pourcentageObstacle = Constante.OBSTACLES_MIN;
    }
    this.plateau = new Cellule[largeur][longueur];
    for (int i = 0; i < plateau.length; i++) {          //
      for (int j = 0; j < plateau[0].length; j++) {     // Remplissage vide
        this.plateau[i][j] = new Cellule(j, i);         //
      }
    }
    this.plateau[0][0] = new Base(0, 0, Constante.EQUIPE_UN);                  //
    this.plateau[this.longueur - 1][this.largeur - 1] =                        // base par default
        new Base(this.longueur - 1, this.largeur - 1, Constante.EQUIPE_DEUX);  //

    double nbObstacles = ((double) pourcentageObstacle / 100) * (this.plateau[0].length * this.plateau.length);
    int currentObstacles = 0;
    Random rd = new Random();
    while (currentObstacles < nbObstacles) {
      int rdX = rd.nextInt(this.longueur - 3) + 1;
      int rdY = rd.nextInt(this.largeur - 3) + 1;
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
    for (Cellule[] cellules : plateau) {
      for (Cellule cellule : cellules) {
        if (cellule.getCoordonnees().equals(coordonnees)) {
          return cellule;
        }
      }
    }return null;
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
    if (this.estBase(y,x) == 0 && !this.estMur(y, x) && this.estRobot(y, x) == 0) {
      this.plateau[y][x] = new Mine(y, x, equipe);
    }
    else{
      System.err.println("Erreur, placement impossible");
    }
  }

  public void poserRobot(int x, int y, Robot robot){
    /** on peut poser un robot seulement sur une base
     * on test si la cellulle passer en param n'est pas un mur, qu'elle ne contienne pas de mine et que cela correspond bien a une mine
     */
    if(!this.estMur(y,x) && this.estBase(x,y) > 0 && this.estMine(x,y) == 0){
      this.plateau[y][x].poserRobot(robot);
    }
    else{
      System.err.println("Erreur, placement impossible");
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
          }if (j == plateau[0].length - 1) {
            ans += "|";
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
        else if (plateau[i][j] instanceof Mine) {
          Mine testMine = (Mine) plateau[i][j];
          if (testMine.contientMine() == 1) {
            ans += "| O ";
          }
          if (testMine.contientMine() == 2) {
            ans += "| o ";
          }
        }
        else if (plateau[i][j] instanceof Cellule){
          ans += "|   ";
          if (j == plateau[0].length -1) {
            ans += "|";
          }
        }

      }if(i < plateau.length - 1) {
        ans += "\n"+quadrillage()+"\n";
      }
    }
    return ans + quadrillage() + "\n\n" + legende();    
  }
  
  private String legende() {
    String ans = "+";
    for (int i = 0; i < 63; i++) {
      ans += "-";
    } ans += "+\n";
    ans += "|\tMAJUSCULES\t%\tminuscules\t\t\t|\n";
    String[] chabadabada = new String[] {
        "base","tireur","piegeur","char","mine"
    };
    for (int i = 0; i < chabadabada.length; i++) {
      ans += "|\t\t" + chabadabada[i].substring(0, 1).toUpperCase() + "\t|\t\t" + chabadabada[i].substring(0, 1) + "\t" + chabadabada[i] + "\t\t|\n";
    }ans += "|\t";
    for (int i = 0; i < 47; i++) {
      ans += "-";
    }ans += "\t\t|\n";
    ans += "|\t\to\tobstacles\t\t\t\t|\n+";
    for (int i = 0; i < 63; i++) {
      ans += "-";
    }
    return ans + "+";
  }

  private String quadrillage(){
    String ans = "+";
    for (int i = 0; i < plateau[0].length ; i++) {
      ans += "---+";
    }    
    return ans;
  }
}