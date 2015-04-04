package gameOfWar.action;
import gameOfWar.config.Cellule;
import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Piegeur;
import gameOfWar.robot.Robot;


public class PoseMine extends Action{

	public PoseMine(Robot robot, Coordonnees direction) {
		super(robot, direction);
		//this.agit();
	}
	
	public void agit(Cellule c){
		if (this.getRobot() instanceof Piegeur) {
			this.getRobot().getVue().setMine(getRobot(), getObjectif());
		}
		else {
			System.err.println("Erreur, placement impossible.");
		}
	}
	 
}
