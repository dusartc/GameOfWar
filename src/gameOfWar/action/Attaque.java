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
    System.out.println("Vous attaqué "
        + this.getRobot().getVue().getPlateau().getCelluleByCoordonnees(getObjectif()).getRobot()
        + " pour un montant de " + this.getRobot().getDegatTir());
    this.getRobot().getVue().getPlateau().getCelluleByCoordonnees(getObjectif()).getRobot()
        .subitTirDe(this.getRobot());
    System.out.println("Il lui reste desormais "
        + this.getRobot().getVue().getPlateau().getCelluleByCoordonnees(getDirection()).getRobot()
            .getEnergie() + " energie");
    this.getRobot().perdEnergieApresAction();
  }

}
