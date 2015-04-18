package gameOfWar.action;

import gameOfWar.config.Cellule;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Char;
import gameOfWar.robot.Piegeur;
import gameOfWar.robot.Robot;
import gameOfWar.robot.Tireur;


/**
 * La classe Deplacement permet de produire une action de deplacement des robots.
 * 
 * @author Aurelia
 */
public class Deplacement extends Action {


  public Deplacement(Robot robot) {
    this(robot, robot.getObjectif());
  }

  /**
   * On donne les directions en fonction du robot
   * 
   * @param robot
   * @param direction
   */
  public Deplacement(Robot robot, Coordonnees direction) {
    super(robot, direction);
  }


  // @Override
  // public void agit() {
  // agit(this.getRobot().getVue().getPlateau().getCelluleByCoordonnees(this.getRobot().getObjectif()));
  // }


  /**
   * Agit() produit le deplacement.
   */
  public void agit() {
    moveTo(getObjectif());
  }

//  /**
//   * Test avec une Cellule donné si le deplacement est possible vers cette Cellule et retourne Vrai
//   * ou Faux.
//   * 
//   * @param c
//   * @return
//   */
//  public boolean deplacementPossible(Cellule c) {
//    if (this.getRobot() instanceof Tireur || this.getRobot() instanceof Piegeur) {
//      Cellule inter =
//          new Cellule(this.getRobot().getCoordonnees().getLargeur(), this.getRobot()
//              .getCoordonnees().getHauteur());
//      Coordonnees coord = inter.getCoordonnees().calculCoordonnees(c.getCoordonnees());
//      for (int i = 0; i < Constante.DEP_TIREUR.size(); i++) {
//        if (coord.equals(Constante.DEP_TIREUR.get(i))) {
//          if (c.estRobot() == 0 || c.contientMine() >= 0
//              || c.estBase() == this.getRobot().getEquipe().getEquipe() || !c.estMur()) {
//            return true;
//          }
//        }
//      }
//    }
//    if (this.getRobot() instanceof Char) {
//      Cellule inter =
//          new Cellule(this.getRobot().getCoordonnees().getLargeur(), this.getRobot()
//              .getCoordonnees().getHauteur());
//      // cree une cellule avec les coordonnes du robot courant
//      Coordonnees coord = inter.getCoordonnees().calculCoordonnees(c.getCoordonnees());
//      // renvoit a la fonction dans la classe cellule qui calule la distance entre les coordonnes du
//      // robot et celles de la cellule passee en parametre
//      for (int i = 0; i < Constante.DEP_CHAR.size(); i++) {
//        // parcourt le tableau des deplacements du char
//        if (coord.equals(Constante.DEP_CHAR.get(i))) {
//          // si les coordonnees calculees sont egales a une des coordonnees de la constante DEP_CHAR
//          if (c.estRobot() == 0 || c.contientMine() >= 0
//              || c.estBase() == this.getRobot().getEquipe().getEquipe() || !c.estMur()) {
//            // et si la cellule est vide alors le deplacement est possible
//            return true;
//          }
//        }
//      }
//    }
//    return false;
//  }

  /**
   * Fait bouger le robot dans la coordonnees données.
   * 
   * @param c
   */
  public void moveTo(Coordonnees c) {
    this.getRobot().getVue().retirerRobot(this.getRobot().getCoordonnees());
    this.getRobot().setCoordonnees(c);
    this.getRobot().getVue().poserRobot(getRobot(), c);
    this.getRobot().perdEnergieApresDep();
    if (this.getRobot().getVue().getPlateau().getCelluleByCoordonnees(c).contientMine() > 0) {
      System.out.println("EEEEEH BOOOM !!!");
      this.getRobot().subitMine();
      this.getRobot().getVue().getPlateau().getCelluleByCoordonnees(c).retirerMine();
    }
  }

}
