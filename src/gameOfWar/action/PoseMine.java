package gameOfWar.action;
import gameOfWar.config.Cellule;
import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Piegeur;
import gameOfWar.robot.Robot;

/**
 * 
 * @author Mariam
 *
 */
public class PoseMine extends Action{

  public PoseMine(Robot robot, Coordonnees direction) {
    super(robot, direction);
    //this.agit();
  }

  public boolean estPosable(Cellule cellule){
    if (this.getRobot() instanceof Piegeur) {
      
    }
    return false;
  }
  public void agit(Cellule c){
    
  }
   
}
