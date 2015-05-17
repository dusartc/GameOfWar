package gameOfWar.jeux;

import gameOfWar.config.Base;
import gameOfWar.config.Cellule;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.config.Mur;
import gameOfWar.robot.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Permet de modeliser un plateau
 * 
 * @author Clement
 */
public class Plateau {

  private Cellule[][] plateau;
  private int longueur;
  private int largeur;
  private int x;
  private int y;

  /**
   * Construit un plateau longueur*largeur avec un certain pourcentage d'obstacles
   * 
   * @param longueur la longueur du plateau
   * @param largeur la largeur du plateau
   * @param pourcentageObstacle le pourcentage d'obstacles que le plateau doit avoir
   */
  public Plateau(int longueur, int largeur, int pourcentageObstacle) {
    /*
     * on doit avoir un chemin entre les deux bases : on met des murs seulements au coordonnees 0+1
     * et max-1 pour avoir un chemin qui fait le tour
     */
    this.longueur = longueur;
    this.largeur = largeur;
    this.x = largeur;
    this.y = longueur;
    this.plateau = new Cellule[y][x];
    for (int i = 0; i < plateau.length; i++) { //
      for (int j = 0; j < plateau[0].length; j++) { // Remplissage vide
        this.plateau[i][j] = new Cellule(j, i); //
      }
    }
    this.plateau[0][0] = new Base(0, 0, Constante.EQUIPE_UN); //
    this.plateau[this.y - 1][this.x - 1] = // base par default
        new Base(this.x - 1, this.y - 1, Constante.EQUIPE_DEUX); //
    double nbObstacles =
        ((double) pourcentageObstacle / 100) * (this.plateau[0].length * this.plateau.length);
    int currentObstacles = 0;
    Random rd = new Random();
    while (currentObstacles < nbObstacles) {
      int rdX = rd.nextInt(this.largeur - 1);
      int rdY = rd.nextInt(this.longueur - 1);
      if (!getCellule(rdX, rdY).estMur() && getCellule(rdX, rdY).estBase() == 0
          && getCellule(rdX, rdY).contientMine() == 0 && getCellule(rdX, rdY).estRobot() == 0) {
        this.plateau[rdY][rdX] = new Mur(rdX, rdY);
        currentObstacles += 1;
      }
    }
    this.pathFinding(new Coordonnees(0, 0), new Coordonnees(this.x - 1, this.y - 1));
  }

  public void pathFinding(Coordonnees source, Coordonnees fin) {
    System.out.println("(" + fin.getLargeur() + "," + fin.getHauteur() + ")");
    Coordonnees searchPath = source;
    Random rd = new Random();
    int i;
    List<Coordonnees> path = new ArrayList<Coordonnees>();
    while (!searchPath.equals(fin)) {
      path.add(searchPath);
      if (searchPath.getHauteur() != fin.getHauteur()
          && searchPath.getLargeur() != fin.getLargeur()) {
        i = rd.nextInt(2);
        switch (i) {
          case 0:
            searchPath = searchPath.ajout(new Coordonnees(0, 1));
            break;
          case 1:
            searchPath = searchPath.ajout(new Coordonnees(1, 0));
            break;
          default:
            break;
        }
      } else if (searchPath.getLargeur() != fin.getLargeur()) {
        searchPath = searchPath.ajout(new Coordonnees(1, 0));
      } else
        searchPath = searchPath.ajout(new Coordonnees(0, 1));
      System.out.println("(" + searchPath.getLargeur() + "," + searchPath.getHauteur() + ")");
    }
    for (Coordonnees coordonnees : path) {
      getCelluleByCoordonnees(coordonnees).setMur(false);
    }
  }

  public Cellule getCellule(int x, int y) {
    return this.plateau[y][x];
  }

  public Cellule getCelluleByCoordonnees(Coordonnees coordonnees) {
    /**
     * un simple parcourt des cellules on renvoie celle possedant les memes coordonnees que param
     */
    for (Cellule[] cellules : plateau) {
      for (Cellule cellule : cellules) {
        if (cellule.getCoordonnees().equals(coordonnees)) {
          return cellule;
        }
      }
    }
    return null;
  }

  public int getLargeur() {
    return this.largeur;
  }

  public int getLongueur() {
    return this.longueur;
  }

  public boolean estMur(int x, int y) {
    return plateau[y][x].estMur();
  }

  public int estBase(int x, int y) {
    return plateau[y][x].estBase();
  }

  public int estMine(int x, int y) {
    return plateau[y][x].contientMine();
  }

  public int estRobot(int x, int y) {
    return plateau[y][x].estRobot();
  }

  public int estFactory(int x, int y) {
    return plateau[y][x].getNumFacto();
  }

  /**
   * Vide la Cellule en x, y
   * 
   * @param x indice sur l'axe x
   * @param y indice sur l'axe y
   */
  public void libereCellule(int x, int y) {
    this.plateau[y][x].videCase();
  }

  /**
   * pose un Robot en x, y
   * 
   * @param x indice sur l'axe x
   * @param y indice sur l'axe y
   * @param robot le Robot a poser
   */
  public void poserRobot(int x, int y, Robot robot) {
    /*
     * on peut poser un robot si la cellule passer en param n'est pas un mur, qu'elle ne contienne
     * pas de mine
     */
    if (!this.estMur(x, y)) {
      this.getCellule(x, y).poserRobot(robot);
    } else {
      System.err.println("Erreur, placement impossible");
    }
  }

  public void retirerRobot(Coordonnees coordonnees) {
    this.plateau[coordonnees.getHauteur()][coordonnees.getLargeur()].retirerRobot();
  }

  public void retirerMine(Coordonnees coordonnees) {
    this.plateau[coordonnees.getHauteur()][coordonnees.getLargeur()].retirerMine();
  }

  public Cellule[][] getPlateau() {
    return this.plateau;
  }

}
