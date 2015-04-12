package gameOfWar.action;
import gameOfWar.config.Cellule;
import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Robot;
/**
 * La Classe Action permet de gérer les actions des robots sur le plateau.
 * @author Alexandre
 */
public abstract class Action {
  
  /** La direction que doit emprunter le robot*/
  private Coordonnees direction;
  /** L'objectif que doit atteindre le robot*/
  private Coordonnees objectif;
  /** Le robot */
  private Robot robot;
  
  /**
   * Construit un objet Action avec le robot et les coordonnees donnees
   * @param robot le robot qui devra effectuer l'action
   * @param direction la direction de l'action
   */
  public Action(Robot robot, Coordonnees direction) {
    this.robot = robot;
    this.direction = direction;
  }
  
  /**
   * Retourne le robot.
   * @return
   */
  public Robot getRobot() {
    return this.robot;
  }
  
  /**
   * Retour les coordonnees de la direction.
   * @return
   */
  public Coordonnees getDirection() {
    return this.direction;
  }
  
  /**
   * Retour les coordonnees de l'objectif.
   * @return
   */
  public Coordonnees getObjectif() {
    return this.objectif;
  }
  /**
   * agit realise l'action du robot
   */
  public abstract void agit(Cellule caseCible); // Modif du paramètre de type Cellule en caseCible pour moins d'ambigûtée
}