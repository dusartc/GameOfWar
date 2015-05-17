package gameOfWar.action;

import gameOfWar.config.Base;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Robot;


/**
 * Permet de deplacer un robot
 * 
 * @author Aurelia
 */
public class Deplacement extends Action {

  /**
   * Construit un deplacement
   * 
   * @param robot le robot qui doit effectuer le deplacement
   * @see Action
   */
  public Deplacement(Robot robot) {
    super(robot);
  }

  /**
   * @see Action
   */
  public void agit() {
    moveTo(getObjectif());
  }

  private void moveTo(Coordonnees c) {
    this.getRobot().getVue().retirerRobot(this.getRobot().getCoordonnees());
    this.getRobot()
        .getVue()
        .getPlateau()
        .getCelluleByCoordonnees(this.getRobot().getCoordonnees())
        .setImage(
            this.getRobot().getVue().getPlateau()
                .getCelluleByCoordonnees(this.getRobot().getCoordonnees()) instanceof Base ? this
                .getRobot().getVue().getPlateau()
                .getCelluleByCoordonnees(this.getRobot().getCoordonnees()).getImage()
                : this.getRobot().getVue().getPlateau()
                    .getCelluleByCoordonnees(getRobot().getCoordonnees()).getNumFacto() == 0 ? " "
                    : this.getRobot().getVue().getPlateau()
                        .getCelluleByCoordonnees(getRobot().getCoordonnees()).getNumFacto() == Constante.EQUIPE_UN ? "F"
                        : "f");
    this.getRobot().setCoordonnees(c);
    this.getRobot().getVue().poserRobot(getRobot(), c);
    this.getRobot().perdEnergieApresDep();
    this.getRobot()
        .getVue()
        .getPlateau()
        .getCelluleByCoordonnees(this.getRobot().getCoordonnees())
        .setImage(
            this.getRobot().getVue().getPlateau()
                .getCelluleByCoordonnees(this.getRobot().getCoordonnees()) instanceof Base ? this
                .getRobot().getVue().getPlateau()
                .getCelluleByCoordonnees(this.getRobot().getCoordonnees()).getImage() : this
                .getRobot().getText());
    if (this.getRobot().getVue().getPlateau().getCelluleByCoordonnees(c).contientMine() > 0) {
      System.out.println("EEEEEH BOOOM !!!");
      this.getRobot().subitMine();
      this.getRobot().getVue().getPlateau().getCelluleByCoordonnees(c).retirerMine();
    }
  }

}
