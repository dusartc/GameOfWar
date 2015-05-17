package gameOfWar.action;

import gameOfWar.robot.Robot;

/**
 * Permet à un robot de tirer
 * 
 * @author Samantha
 * @author Mariam
 * @author Clement
 */
public class Attaque extends Action {

  /**
   * @param robot le robot qui doit effectuer l'action
   * @see Action
   */
  public Attaque(Robot robot) {
    super(robot);
  }

  /**
   * @see Action
   */
  @Override
  public void agit() {
    System.out.println("Vous attaqu� "
        + this.getRobot().getVue().getPlateau().getCelluleByCoordonnees(getObjectif()).getRobot()
        + " pour un montant de " + this.getRobot().getDegatTir());
    this.getRobot().getVue().getPlateau().getCelluleByCoordonnees(getObjectif()).getRobot()
        .subitTirDe(this.getRobot());
    System.out.println("Il lui reste desormais "
        + this.getRobot().getVue().getPlateau().getCelluleByCoordonnees(getObjectif()).getRobot()
            .getEnergie() + " energie");
    this.getRobot().perdEnergieApresAction();
  }

}
