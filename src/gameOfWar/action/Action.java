package gameOfWar.action;
import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Robot;

/**
 * La Classe Action permet de gérer les actions des robots sur le plateau.
 * @author Alexandre, Clement
 */
public abstract class Action {
  
  /** La direction que doit emprunter le robot*/
  private Coordonnees direction;
  /** L'objectif que doit atteindre le robot*/
  private Coordonnees objectif;
  /** Le robot */
  private Robot robot;
  
  public Action(Robot robot) {
    this(robot, null);
  }
  
  /**
   * Construit un objet Action avec le robot et les coordonnees donnees
   * @param robot le robot qui devra effectuer l'action
   * @param direction la direction de l'action
   */
  public Action(Robot robot, Coordonnees direction) {
    this.robot = robot;
    this.direction = direction;
    this.objectif = robot.getObjectif();
  }
  
  /**
   * agit realise l'action du robot
   */
  public abstract void agit();
  
  public Coordonnees getDirection() {
    return this.direction;
  }
  
  public Coordonnees getObjectif() {
    return this.objectif;
  }
  
  public Robot getRobot() {
    return this.robot;
  }
}