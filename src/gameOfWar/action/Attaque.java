package gameOfWar.action;
import gameOfWar.config.Cellule;
import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Robot;


public class Attaque extends Action {

  public Attaque(Robot robot, Coordonnees direction) {
    super(robot, direction);
  }

 
  void agit(Cellule c) { // En cours 
    if(this.getRobot() instanceof Tireur){
    	
    }
    else if (this.getRobot() instanceof Piegeur){
    	
    }
    else if (this.getRobot() instanceof Char){
    	
    }
    
  }

}
