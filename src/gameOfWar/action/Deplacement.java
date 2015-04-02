package gameOfWar.action;
import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Piegeur;
import gameOfWar.robot.Robot;
import gameOfWar.robot.Tireur;


public class Deplacement extends Action {

  
  
  public Deplacement(Robot robot, Coordonnees direction) {
    super(robot, direction);
    // TODO Auto-generated constructor stub
  }


  @Override
  void agit() {
	if (this.getRobot() instanceof Tireur || this.getRobot() instanceof Piegeur) {
		if (true) {
			
		}
		this.getRobot().setCoordonnees(getObjectif());
	}

  }

}
