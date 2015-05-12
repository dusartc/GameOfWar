package gameOfWar.jeux;

import gameOfWar.config.Base;
import gameOfWar.config.Cellule;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.config.Factory;
import gameOfWar.config.Mur;
import gameOfWar.robot.Char;
import gameOfWar.robot.Piegeur;
import gameOfWar.robot.Robot;
import gameOfWar.robot.Tireur;
import gameOfWar.robot.Worker;


/**
 * Represente un affichage du plateau avec seulement les mines de l'equipe qui possede la vue
 * 
 * @author Mathieu
 * @author Clement
 */
public class Vue {

  private Plateau plateau;
  private int equipe;

  /**
   * Construit une vue en fonction du plateau et du numero de l'equipe la possedant
   * 
   * @param plateau le plateau associe
   * @param equipe l'equipe associee
   */
  public Vue(Plateau plateau, int equipe) {
    this.plateau = plateau;
    this.equipe = equipe;
  }

  /**
   * Renvoie vrai si les coordonnees sont bien compris entre largueur et longueur
   * 
   * @param coordonnees les coordonnees a test
   * @return boolean
   */
  public boolean estOK(Coordonnees coordonnees) {
    return coordonnees.getLargeur() > 0 && coordonnees.getHauteur() > 0
        && coordonnees.getLargeur() < this.plateau.getLargeur()
        && coordonnees.getLargeur() < this.plateau.getLongueur();
  }

  public void libereCelulle(Coordonnees coordonnees) {
    this.plateau.libereCellule(coordonnees.getLargeur(), coordonnees.getHauteur());
  }

  public void poserRobot(Robot robot, Coordonnees coordonnees) {
    this.plateau.poserRobot(coordonnees.getLargeur(), coordonnees.getHauteur(), robot);
  }

  public void retirerRobot(Coordonnees coordonnees) {
    this.plateau.retirerRobot(coordonnees);
  }

  // public void setMine(Robot robot, Coordonnees coordonnees){
  // this.plateau.poserUneMine(coordonnees.getLargeur(), coordonnees.getHauteur(),
  // robot.getEquipe());
  // }

  public void retirerMine(Coordonnees coordonnees) {
    this.plateau.retirerMine(coordonnees);
  }

  public Plateau getPlateau() {
    return this.plateau;
  }

  public int getEquipe() {
    return this.equipe;
  }

  @Override
  public String toString() {
    StringBuilder ans = new StringBuilder();
    ans.insert(ans.length(), quadrillage());
    for (int i = 0; i < this.plateau.getLongueur(); i++) {
      for (int j = 0; j < this.plateau.getLargeur(); j++) {
        if (this.plateau.getCellule(j, i) instanceof Mur) {
          if (this.plateau.getCellule(j, i).estMur()) {
            ans.insert(ans.length(), "| O ");
          }
        } else if (this.plateau.getCellule(j, i) instanceof Base) {
          if (this.plateau.estBase(j, i) == 1) {
            ans.insert(ans.length(), "\n| B ");
          } else if (this.plateau.estBase(j, i) == 2) {
            ans.insert(ans.length(), "| b |\n");
          }
        } 
        else if (this.plateau.estFactory(j, i) > 0) {
            if (this.plateau.estFactory(j, i) == 1) {
              ans.insert(ans.length(), "| F ");
            } else if (this.plateau.estFactory(j, i) == 2) {
              ans.insert(ans.length(), "| f ");
            }
            else {
                ans.insert(ans.length(), "|");
              }
          } else if (this.plateau.getCellule(j, i).contientMine() > 0) {
          String res = "";
          if (this.equipe == Constante.EQUIPE_UN) {
            res += "| M ";
          } else if (this.equipe == Constante.EQUIPE_DEUX) {
            res += "| m ";
          }
          ans.insert(ans.length(), (this.plateau.estMine(j, i) == this.getEquipe()) ? res : "|   ");
          if (j == this.plateau.getLargeur() - 1) {
              ans.insert(ans.length(), "|");
            }
        } else if (this.plateau.getCellule(j, i).getRobot() instanceof Piegeur) {
          if (this.plateau.estRobot(j, i) == 1) {
            ans.insert(ans.length(), "| P ");
            if (j == this.plateau.getLargeur() - 1) {
              ans.insert(ans.length(), "|");
            }
          } else if (this.plateau.estRobot(j, i) == 2) {
            ans.insert(ans.length(), "| p ");
            if (j == this.plateau.getLargeur() - 1) {
              ans.insert(ans.length(), "|");
            }
          } else if (j != this.plateau.getLargeur() - 1) {
            ans.insert(ans.length(), "|   ");
          } else {
            ans.insert(ans.length(), "|");
          }
        } else if (this.plateau.getCellule(j, i).getRobot() instanceof Tireur) {
          if (this.plateau.estRobot(j, i) == 1) {
            ans.insert(ans.length(), "| T ");
            if (j == this.plateau.getLargeur() - 1) {
              ans.insert(ans.length(), "|");
            }
          } else if (this.plateau.estRobot(j, i) == 2) {
            ans.insert(ans.length(), "| t ");
            if (j == this.plateau.getLargeur() - 1) {
              ans.insert(ans.length(), "|");
            }
          } else if (j != this.plateau.getLargeur() - 1) {
            ans.insert(ans.length(), "|   ");
          } else {
            ans.insert(ans.length(), "|");
          } 
        } else if (this.plateau.getCellule(j, i).getRobot() instanceof Worker) {
            if (this.plateau.estRobot(j, i) == 1) {
                ans.insert(ans.length(), "| W ");
                if (j == this.plateau.getLargeur() - 1) {
                  ans.insert(ans.length(), "|");
                }
              } else if (this.plateau.estRobot(j, i) == 2) {
                ans.insert(ans.length(), "| w ");
                if (j == this.plateau.getLargeur() - 1) {
                  ans.insert(ans.length(), "|");
                }
              } else if (j != this.plateau.getLargeur() - 1) {
                ans.insert(ans.length(), "|   ");
              } else {
                ans.insert(ans.length(), "|");
              }
        	}else if (this.plateau.getCellule(j, i).getRobot() instanceof Char) {
          if (this.plateau.estRobot(j, i) == 1) {
            ans.insert(ans.length(), "| C ");
            if (j == this.plateau.getLargeur() - 1) {
              ans.insert(ans.length(), "|");
            }
          } else if (this.plateau.estRobot(j, i) == 2) {
            ans.insert(ans.length(), "| c ");
            if (j == this.plateau.getLargeur() - 1) {
              ans.insert(ans.length(), "|");
            }
          } else if (j != this.plateau.getLargeur() - 1) {
            ans.insert(ans.length(), "|   ");
          } else {
            ans.insert(ans.length(), "|");
          }
        } else if (this.plateau.getCellule(j, i) instanceof Cellule) {
          ans.insert(ans.length(), "|   ");
          if (j == this.plateau.getLargeur() - 1) {
            ans.insert(ans.length(), "|");
          }
        }

      }
      if (i < this.plateau.getLongueur() - 1) {
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
    String[] chabadabada = new String[] {"base", "tireur", "piegeur", "char", "mine", "factory"};
    for (int i = 0; i < chabadabada.length; i++) {
      ans +=
          "|\t\t" + chabadabada[i].substring(0, 1).toUpperCase() + "\t|\t\t"
              + chabadabada[i].substring(0, 1) + "\t" + chabadabada[i] + "\t\t|\n";
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
    for (int i = 0; i < this.plateau.getLargeur(); i++) {
      ans += "---+";
    }
    return ans;
  }

}
