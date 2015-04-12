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
    /** on doit avoir un chemin entre les deux bases :
     *  on met des murs seulements au coordonnees 0+1 et max-1 pour avoir un chemin qui fait le tour
     */
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
    System.out.println("toto");
    for (int i = 0; i < plateau.length; i++) {          //
      for (int j = 0; j < plateau[0].length; j++) {     // Remplissage vide
        this.plateau[i][j] = new Cellule(j, i);         //
      }
    }System.out.println("hehe");
    this.plateau[0][0] = new Base(0, 0, Constante.EQUIPE_UN);                  //
    this.plateau[this.longueur - 1][this.largeur - 1] =                        // base par default
        new Base(this.longueur - 1, this.largeur - 1, Constante.EQUIPE_DEUX);  //

    double nbObstacles = ((double) pourcentageObstacle / 100) * (this.plateau[0].length * this.plateau.length);
    int currentObstacles = 0;
    Random rd = new Random();
    while (currentObstacles < nbObstacles) {
      int rdX = rd.nextInt(this.longueur - 2) + 1;
      int rdY = rd.nextInt(this.largeur - 2) + 1;
      if (!getCellule(rdY, rdX).estMur() &&
          getCellule(rdY, rdX).estBase() == 0 &&
          getCellule(rdY, rdX).contientMine() == 0 &&
          getCellule(rdY, rdX).estRobot() == 0) {
        this.plateau[rdX][rdY] = new Mur(rdX, rdY);
        currentObstacles += 1;
      }
    }System.out.println("done");
  }

  public Plateau(int longueur, int largeur, int x, int y, int direction){
    this.plateau = new Cellule[largeur][longueur];
  }

  public Cellule getCellule(int x, int y){
    return this.plateau[y][x];
  }

  public Cellule getCelluleByCoordonnees(Coordonnees coordonnees){
    /** un simple parcourt des cellules
     *  on renvoie celle possedant les memes coordonnees que param
     */
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
    /** on peut poser une mine seulement sur une case vide */
    if (this.plateau[y][x].estVide()) {
      this.plateau[y][x] = new Mine(y, x, equipe);
      System.out.println("Mine posée pour l'équipe :"+equipe+" Au coordonnée ("+x+","+y+")");
    }
    else{
      System.err.println("Erreur, placement impossible au coordonnée ("+x+","+y+")");
    }
  }

  public void poserRobot(int x, int y, Robot robot){
    /** on peut poser un robot seulement sur une base
     * on test si la cellule passer en param n'est pas un mur, qu'elle ne contienne pas de mine et que cela correspond bien a une mine
     */
    if(!this.estMur(y,x) && this.estBase(x,y) > 0 && this.estMine(x,y) == 0){
      this.plateau[y][x].poserRobot(robot);
    }
    else{
      System.err.println("Erreur, placement impossible");
    }
  }
  
  public void retirerRobot(Coordonnees coordonnees) {
    this.plateau[coordonnees.getHauteur()][coordonnees.getLargeur()].retirerRobot();
  }
  
  public void retirerMine(Coordonnees coordonnees) {
    this.plateau[coordonnees.getHauteur()][coordonnees.getLargeur()].retirerMine();
  }
  
  @Override
  public String toString() {
    StringBuilder ans = new StringBuilder();
    ans.insert(ans.length(), quadrillage());
    for (int i = 0; i < this.plateau.length; i++) {
      for (int j = 0; j < this.plateau[0].length; j++) {
        if (this.plateau[i][j] instanceof Mur) {
          if(this.plateau[i][j].estMur()) {
            ans.insert(ans.length(), "| O ");
          }
        }
        else if (this.plateau[i][j] instanceof Base) {
          if (this.estBase(i,j) == 1) {
            ans.insert(ans.length(), "\n| B ");
          }
          else if(this.estBase(i,j) == 2){
            ans.insert(ans.length(),"| b |\n");
          }
        }
        else if (this.plateau[i][j] instanceof Mine) {
          if (this.estMine(i, j) == 1) {
            ans.insert(ans.length(),"| M ");
          }
          if (this.estMine(i, j) == 2) {
            ans.insert(ans.length(),"| m ");
          }
        }
        else if (this.plateau[i][j] instanceof Cellule){
          ans.insert(ans.length(),"|   ");
          if (j == this.plateau[0].length -1) {
            ans.insert(ans.length(),"|");
          }
        }
      }if(i < this.plateau.length - 1) {
        ans.insert(ans.length(),"\n"+quadrillage()+"\n");
      }
    }ans.insert(ans.length(),quadrillage() + "\n\n" + legende());
    return ans.toString();
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
      ans += "|\t\t"
          + chabadabada[i].substring(0, 1).toUpperCase()
          + "\t|\t\t" + chabadabada[i].substring(0, 1) + "\t"
          + chabadabada[i] + "\t\t|\n";
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
