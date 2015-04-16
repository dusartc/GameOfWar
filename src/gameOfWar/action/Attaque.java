package gameOfWar.action;

import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Robot;

/**
 * La classe Attaque permet de produire une action de tir ou de poser une mine.
 * 
 * @author (Samantha, Mariam)
 * @author Clement
 */
public class Attaque extends Action {

  public Attaque(Robot robot) {
    super(robot, robot.getObjectif());
  }

  public Attaque(Robot robot, Coordonnees direction) {
    super(robot, direction);
  }

  @Override
  public void agit() {
    this.getRobot().getVue().getPlateau().getCelluleByCoordonnees(getObjectif()).getRobot()
        .subitTirDe(this.getRobot());
    this.getRobot().perdEnergieApresAction();
  }

}
