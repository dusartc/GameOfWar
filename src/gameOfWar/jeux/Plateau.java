package gameOfWar.jeux;

import gameOfWar.config.Base;
import gameOfWar.config.Cellule;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.config.Mur;
import gameOfWar.robot.Char;
import gameOfWar.robot.Piegeur;
import gameOfWar.robot.Robot;
import gameOfWar.robot.Tireur;

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
      int rdX = rd.nextInt(this.largeur - 2) + 1;
      int rdY = rd.nextInt(this.longueur - 2) + 1;
      if (!getCellule(rdX, rdY).estMur() && getCellule(rdX, rdY).estBase() == 0
          && getCellule(rdX, rdY).contientMine() == 0 && getCellule(rdX, rdY).estRobot() == 0) {
        this.plateau[rdY][rdX] = new Mur(rdX, rdY);
        currentObstacles += 1;
      }
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

  @Override
  public String toString() {
    StringBuilder ans = new StringBuilder();
    ans.insert(ans.length(), quadrillage());
    for (int i = 0; i < this.plateau.length; i++) {
      for (int j = 0; j < this.plateau[0].length; j++) {
        if (this.plateau[i][j] instanceof Mur) {
          if (this.plateau[i][j].estMur()) {
            ans.insert(ans.length(), "| O ");
          }
        } else if (this.plateau[i][j] instanceof Base) {
          if (this.estBase(j, i) == 1) {
            ans.insert(ans.length(), "\n| B ");
          } else if (this.estBase(j, i) == 2) {
            ans.insert(ans.length(), "| b |\n");
          }
        } else if (this.plateau[i][j].contientMine() > 0) {
          if (this.estMine(j, i) == 1) {
            ans.insert(ans.length(), "| M ");
          }
          if (this.estMine(j, i) == 2) {
            ans.insert(ans.length(), "| m ");
          }
        } else if (this.plateau[i][j].getRobot() instanceof Piegeur) {
          if (this.estRobot(j, i) == 1) {
            ans.insert(ans.length(), "| P ");
            if (j == this.plateau[0].length - 1) {
              ans.insert(ans.length(), "|");
            }
          } else if (this.estRobot(j, i) == 2) {
            ans.insert(ans.length(), "| p ");
            if (j == this.plateau[0].length - 1) {
              ans.insert(ans.length(), "|");
            }
          } else if (j != this.plateau[0].length - 1) {
            ans.insert(ans.length(), "|   ");
          } else {
            ans.insert(ans.length(), "|");
          }

        } else if (this.plateau[i][j].getRobot() instanceof Tireur) {
          if (this.estRobot(j, i) == 1) {
            ans.insert(ans.length(), "| T ");
            if (j == this.plateau[0].length - 1) {
              ans.insert(ans.length(), "|");
            }
          } else if (this.estRobot(j, i) == 2) {
            ans.insert(ans.length(), "| t ");
            if (j == this.plateau[0].length - 1) {
              ans.insert(ans.length(), "|");
            }
          } else if (j != this.plateau[0].length - 1) {
            ans.insert(ans.length(), "|   ");

          } else {
            ans.insert(ans.length(), "|");
          }
        } else if (this.plateau[i][j].getRobot() instanceof Char) {
          if (this.estRobot(j, i) == 1) {
            ans.insert(ans.length(), "| C ");
            if (j == this.plateau[0].length - 1) {
              ans.insert(ans.length(), "|");
            }
          } else if (this.estRobot(j, i) == 2) {
            ans.insert(ans.length(), "| c ");
            if (j == this.plateau[0].length - 1) {
              ans.insert(ans.length(), "|");
            }
          } else if (j != this.plateau[0].length - 1) {
            ans.insert(ans.length(), "|   ");
          } else {
            ans.insert(ans.length(), "|");
          }
        } else if (this.plateau[i][j] instanceof Cellule) {
          ans.insert(ans.length(), "|   ");
          if (j == this.plateau[0].length - 1) {
            ans.insert(ans.length(), "|");
          }
        }
      }
      if (i < this.plateau.length - 1) {
        ans.insert(ans.length(), "\n" + quadrillage() + "\n");
      }
    }
    ans.insert(ans.length(), quadrillage() + "\n\n" + legende());
    return ans.toString();
  }

  private String legende() {
    String ans = "+";
    for (int i = 0; i < 63; i++) {
      ans += "-";
    }
    ans += "+\n";
    ans += "|\tMAJUSCULES\t%\tminuscules\t\t\t|\n";
    String[] legende = new String[] {"base", "tireur", "piegeur", "char", "mine", "factory"};
    for (int i = 0; i < legende.length; i++) {
      ans +=
          "|\t\t" + legende[i].substring(0, 1).toUpperCase() + "\t|\t\t"
              + legende[i].substring(0, 1) + "\t" + legende[i] + "\t\t|\n";
    }
    ans += "|\t";
    for (int i = 0; i < 47; i++) {
      ans += "-";
    }
    ans += "\t\t|\n";
    ans += "|\t\to\tobstacles\t\t\t\t|\n+";
    for (int i = 0; i < 63; i++) {
      ans += "-";
    }
    return ans + "+";
  }

  private String quadrillage() {
    String ans = "+";
    for (int i = 0; i < plateau[0].length; i++) {
      ans += "---+";
    }
    return ans;
  }

}
