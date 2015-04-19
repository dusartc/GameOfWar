package gameOfWar.action;

import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Robot;

/**
 * Permet de gérer les actions des robots sur le plateau.
 * 
 * @author Alexandre
 * @author Clement
 */
public abstract class Action {

  private Coordonnees direction;
  private Coordonnees objectif;
  private Robot robot;


  /**
   * Construit une Action
   * 
   * @param robot le robot qui devra effectuer l'action
   */
  public Action(Robot robot) {
    this.robot = robot;
    this.objectif = robot.getObjectif();
  }

  /**
   * Realise l'action du robot
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
